import os, io
from collections import deque
from google.cloud import vision
from google.oauth2 import service_account


def f(n, decimals=3):
    return "{:.{}f}".format(n, decimals)

def set_credentials():
    global credentials
    
    credentials_file = "service_account.json"  
    if not credentials_file:
        raise Exception("Missing service_account.json or --key")
    
    credentials = service_account.Credentials.from_service_account_file(credentials_file)

def detect_text(vision_image, language_hints=[], full=False):
    client = vision.ImageAnnotatorClient(credentials=credentials)
    image_context = vision.ImageContext(language_hints=language_hints)
    response = client.text_detection(image=vision_image, image_context=image_context)

    texts = response.text_annotations
    result = ""

    if texts:
        print(f"Language: {texts[0].locale}")
        result += texts[0].description.strip()

    if full:
        for text in texts:
            
            vertices = ([f'({vertex.x},{vertex.y})' for vertex in text.bounding_poly.vertices])
            boundaries = ','.join(vertices)
            result += f'\nbounds: {boundaries}\n'
            
   
    return result

def detect_document_text(vision_image, language_hints=[], full=False):
    client = vision.ImageAnnotatorClient(credentials=credentials)
    image_context = vision.ImageContext(language_hints=language_hints)
    response = client.document_text_detection(image=vision_image, image_context=image_context)

    text = response.text_annotations[0]
    result = ""

    print(f"Language: {text.locale}\n")
    
    result += text.description.strip()

    if full:
        paragraphs, lines = extract_paragraphs(response.full_text_annotation)
        print('\nSINGLE LINE\n')
        print(' '.join(map(str.strip, lines)))
        print('\nPARAGRAPHS\n\n--')
        print('\n\n'.join(paragraphs) + '\n--')

    return result
    
def extract_paragraphs(full_text_annotation):
    breaks = vision.TextAnnotation.DetectedBreak.BreakType
    paragraphs = []
    lines = []

    for page in full_text_annotation.pages:
        for block in page.blocks:
            for paragraph in block.paragraphs:
                para = ""
                line = ""
                for word in paragraph.words:
                    for symbol in word.symbols:
                        line += symbol.text
                        if symbol.property.detected_break.type == breaks.SPACE:
                            line += ' '
                        if symbol.property.detected_break.type == breaks.EOL_SURE_SPACE:
                            line += ' '
                            lines.append(line)
                            para += line
                            line = ''
                        if symbol.property.detected_break.type == breaks.LINE_BREAK:
                            lines.append(line)
                            para += line
                            line = ''
                paragraphs.append(para)

    return deque(paragraphs), lines

def get_image_file(path):
    with io.open(path, 'rb') as image_file:
        content = image_file.read()
    return vision.Image(content=content)

def get_image_uri(uri):
    image = vision.Image()
    image.source.image_uri = uri
    return image

def main():
   
    image_path = "source/calculation_picture2.jpg"  
    is_document = True  
    use_url = False 
    language_hints = ['en']  

    
    set_credentials()

  
    get_image = get_image_uri if use_url else get_image_file
    vision_image = get_image(image_path)

    
    convert = detect_document_text if is_document else detect_text
    finalresult = convert(vision_image, language_hints, full=True) 
    print("Final result:", finalresult)

if __name__ == "__main__":
    main()