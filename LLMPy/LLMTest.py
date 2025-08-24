from flask import Flask, request, jsonify
#from langchain_openai import OpenAI
#from langchain_openai.chat_models import ChatOpenAI
from langchain_openai import ChatOpenAI
import threading
from multiprocessing import Process

OPENAI_API_KEY = "..."
llm = ChatOpenAI(model="gpt-3.5-turbo", api_key=OPENAI_API_KEY)


def create_app( handler_fun):

  app = Flask(__name__)

  @app.route('/process', methods=['POST'])
  def process_file():
      try:
          #print(f"Received files: {request.files}")
          uploaded_file = request.files.get('file')  # Flask automatically processes files in the 'file' field
          if uploaded_file:
              text = uploaded_file.read().decode('utf-8')  # read document content can decode
              result = handler_fun(text)  # call LangChain to generate result
              #print({'text':text})
              return jsonify({"result": result})  # return JSON result
          else:
              return "No file uploaded", 400  # if did not recerive file，return 400 error
      except Exception as e:
          # catch and print error log
          print(f"Error occurred: {e}")
          return "Internal Server Error", 500
  return app

# 启动函数，将Flask应用与指定端口关联
def run_app(port, handler_func):
    app = create_app(handler_func)
    app.run(port=port)

def AI_tutoring_5000(text):
    # call LangChain to  ask LLM generate AI-tutoring content
    #print(text,'text in requirements')
    prompt_template = """
    You are an AI tutor, you will generate AI-tutoring content based on the student's requirements.
    if the requirements is empty, just print"Pleasing waiting, the answer is generating..."
    Here is the requirements:
    """ + text
    print(prompt_template)
    result = llm.invoke(prompt_template)
    print(result.content)
    return result.content

def Personalized_teaching_plan_5001(text):
    # call LangChain to  ask LLM generate personalized teaching plan
    #print(text,'text in requirements')
    prompt_template = """
    You are a smart AI,
    You should help teacher to generate a personalized teaching plan for the teacher based on the requirements,
    Here is the requirements:
    """ + text
    print(prompt_template)
    result = llm.invoke(prompt_template)
    print(result.content)
    return result.content

def Personalized_learning_plan_5002(text):
    # call LangChain to  ask LLM generate AI-tutoring content
    #print(text,'text in requirements')
    prompt_template = """
    You are a smart AI,
    You should help student to generate a personalized learning plan for the student based on the requirements,
    the requirements including the subject, learning goals, prefered guration, preferred learning style and learning paln time range,
    Could you please generate learning plan beased on these parameters,
    You should describe more detail, for example, what knowledge they should learn, and how to learn and what recommandation materials they can use, and how many time they should spend one day and what they can do to learn these knowledge.
    Here is the requirements:
    """ + text
    print(prompt_template)
    result = llm.invoke(prompt_template)
    print(result.content)
    return result.content

def Quiz_generator_5003(text):
    # call LangChain to  ask LLM generate AI-tutoring content
    #print(text,'text in requirements')
    prompt_template = """
    Please generate quiz questions based on the following requirements:
    """ + text
    print(prompt_template)
    result = llm.invoke(prompt_template)
    print(result.content)
    return result.content

if __name__ == '__main__':
    #app.run(port=5000)
    # Start four ports, each performing different processing logic
    #threading.Thread(target=create_app, args=(5000, AI_tutoring_5000)).start()
    #threading.Thread(target=create_app, args=(5001, Personalized_teaching_plan_5001)).start()
    #threading.Thread(target=create_app, args=(5002, Personalized_learning_plan_5002)).start()
    #threading.Thread(target=create_app, args=(5003, Quiz_generator_5003)).start()

    processes = [
        Process(target=run_app, args=(5000, AI_tutoring_5000)),
        Process(target=run_app, args=(5001, Personalized_teaching_plan_5001)),
        Process(target=run_app, args=(5002, Personalized_learning_plan_5002)),
        Process(target=run_app, args=(5003, Quiz_generator_5003))
    ]

    # 启动所有进程
    for process in processes:
        process.start()

    # 确保所有进程在主进程关闭前都能正常运行
    for process in processes:
        process.join()
