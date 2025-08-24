# NextLearn Platform
# Intelligent-Online-Education-Platform-based-on-LangChain
# 基于 LangChain 的线上智能教育平台 

---

## Project Introduction
## 项目简介
NextLearn is an integrated learning platform with an AI-agent, featuring role switching in the upper right corner. For students, the primary functions include AI guidance, intelligent study plan generation, and online communication. For teachers, the main features are AI-assisted quiz generation, intelligent teaching plan customization, and online communication. For parents, the key functions include viewing students' progress paths, online communication, and monitoring learning status.

NextLearn 是一个集成了 AI Agent 的学习平台，支持右上角角色切换。

- 对于 学生：主要功能包括 AI 辅导、智能学习计划生成以及在线交流。

- 对于 教师：主要功能包括 AI 辅助出题、智能教学计划定制以及在线交流。

- 对于 家长：主要功能包括查看学生学习进度路径、在线交流以及学习状态监控。

---

## Project Members
## 项目成员
1. Siyu Chen 530666064
2. Sirui Li 530548597
3. Zhaoyu Wang 530454704
4. Zhehang Xu 540210303
5. Wenxing Zhou 540347447

---

## Key Features
## 主要功能：
1. **Teacher End （教师端）：**

   1. **AI Quizzes Generation / AI智能出题：**
   
      Teachers can interact with an LLM-based intelligent agent by specifying their desired question parameters, such as knowledge topics, question types (e.g., multiple-choice, fill-in-the-blank, short answer), and difficulty levels. The system automatically extracts key semantics from the teacher’s request and generates a tailored set of questions in real time.
      
      教师可以通过与 LLM 驱动的智能代理 进行交互对话，指定想要的题目类型，例如 知识点范围、题目类型（选择题/填空题/简答题等）、题目难度。系统会自动从教师的描述中提取关键语义，并即时生成对应的题目集合。
      
      - Semantic-based interaction: Teachers can simply describe their needs in natural language without configuring complex settings.
      
        基于语义理解的交互：教师无需手动设置复杂参数，只需自然语言描述即可。

      - Personalized quizzes: Each generated question is accompanied by a difficulty rating, helping teachers assess the question level.
      
        个性化出题：每个生成的题目会附带 难度标注，教师可根据标注结果，进一步调整对题目的需求。

      - Iterative refinement: Through multiple rounds of interaction, teachers can continuously fine-tune the question difficulty and style, leading to more effective and customized assessment design.
      
        通过多轮对话，教师能够逐步精准地控制题目质量与难度，实现高效的题目生成与定制化教学。
        
   2. **Personalized Teaching Plan Generation / 个性化教学计划生成：**
      
      The system designs personalized teaching plans by analyzing students’ current learning status, subject type, and learning objectives, while also taking into account their learning preferences, background, and other influencing factors. This ensures a tailored learning experience that improves both teaching effectiveness and student outcomes, while reducing the workload for teachers.

      系统能够根据学生的 当前学习情况、科目类型与学习目标，结合其 学习偏好、背景信息以及其他影响学习的因素，为其量身定制个性化教学方案。这样不仅能提升教学效果与学生的学习成果，同时也能有效减轻教师的教学负担。

      - Student-centered: Teaching plans are tailored to students’ levels and preferences, ensuring relevance and engagement.
        
        以学生为中心：根据学生的学习水平与偏好进行教学计划设计，确保学习内容的针对性。
        
      - Multi-dimensional data-driven: Integrates background information, learning history, and subject-specific characteristics for deeper analysis.
        
        多维度数据支持：结合学生背景、学习记录、学科特点等多种数据源进行个性化分析。
        
      - Enhance learning outcomes: Personalized learning paths enable students to grasp knowledge more efficiently and improve performance.
        
        提升学习效果：通过个性化教学路径，帮助学生更高效地掌握知识点，提升成绩与学习体验。
        
      - Reduce teacher workload: Automatically generates teaching plans to assist teachers in course design, saving preparation time.
        
        减轻教师压力：智能生成教学方案，辅助教师规划课程，节省大量备课时间。
        
2. Student End （学生端）：
   
   1. **Personalized Learning Plan Generation / 个性化学习计划生成：**
      
      Students can upload their current knowledge status and recent exam scores, along with their learning objectives. The system leverages an AI agent to analyze the students’ error sets (wrongly answered questions) and identify key knowledge gaps responsible for score loss.

      学生可以将自己的 当前知识掌握情况 与 近期成绩 上传至系统，并提供学习目标。系统会通过 AI 智能代理 (AI Agent) 对学生的 错题集 进行分析，挖掘导致失分的主要知识点。
      
      Alternatively, students can directly upload their weak knowledge areas, and the AI agent will generate a personalized learning plan based on both their weaknesses and learning goals.
      
      学生也可以直接上传自己认为的 薄弱知识点，AI Agent 会结合数据与学习目标，为学生生成一份 个性化学习计划。
      
      The plan provides not only a detailed analysis of weak knowledge points but also a step-by-step learning roadmap that specifies what learning tasks should be completed at each time interval, helping students progressively improve their performance.
      
      该计划不仅详细分析了学生的薄弱知识，还会给出 分阶段的学习建议，明确每个时间节点应完成的学习任务，从而帮助学生循序渐进地提升学习效果。

   2. **AI-Tutoring / AI实时答疑：**
      
      Students can log in to their accounts and, within their permissions, access the AI tutoring feature. When encountering questions, students can either type them in the designated input box or upload images/files.

      学生可以登录到个人账户，并在权限范围内使用 AI 辅导答疑功能。当学生遇到学习问题时，可以通过系统的输入框直接输入问题，或选择上传 图片/文件。
      
      The AI agent automatically recognizes the question and provides relevant answers or problem-solving guidance in the designated display area of the system, helping students resolve doubts efficiently.
      
      系统中的 AI Agent 会自动识别问题，并在界面中生成相应的 答案或解题思路，帮助学生更快获得解答。
      
      At the same time, all AI tutoring history (including questions and answers) is stored in the system’s database, enabling students to review their learning records later.
      
      此外，系统会自动保存所有的 AI 辅导记录（包括问题与答案），存入数据库，方便学生在后续学习中进行复习与回顾。

   3. **Consultation Appointment / 预约老师咨询：**
      
      This feature provides students with a convenient online system to schedule teacher consultations based on their individual learning needs. Students can select suitable time slots to engage in one-on-one communication with teachers. The feature establishes an efficient and instant communication channel between students and teachers, helping to enhance learning effectiveness and understanding of course content.
      
      本功能为学生提供一个便捷的线上系统，可以根据个人学习需求预约教师咨询。学生可以选择合适的时间段，与教师建立一对一沟通，该功能为学生和教师建立起高效即时的交流渠道，有助于提升学习效果和课程理解度。
      
   4. **Study Resource Recommendation / 学习资源推荐：**
      
      The Study Resource Recommendation Feature is an intelligent system designed to recommend the most suitable study resources based on students’ submitted learning status and needs. It analyzes students’ learning background, current challenges, and goals, automatically filtering and providing relevant materials to help them acquire knowledge more effectively.

      本功能是一个智能化学习资源推荐系统，能够根据学生提交的 学习状况与学习需求，自动筛选并推送最合适的学习资料。系统会综合分析学生的 学习背景、当前学习挑战以及学习目标，精准推荐相关的学习资源，帮助学生更高效地掌握知识内容。
      
3. Parent End（家长端）：
   
   1. **Analysis Academic Performance / 成绩分析：**
      
       Teachers can upload students’ exam scores along with keywords of unmastered knowledge points into the system. The system will then automatically generate two types of charts:
        
       教师可以将学生的 考试成绩 与 未掌握的知识点关键词 上传到系统中。系统会基于这些数据，自动生成两类图表：
    
       - **Class-level Analysis:** Displays the distribution of scores across the class and the collective distribution of unmastered knowledge points.
    
         **班级整体分析：** 展示班级分数分布情况，以及未掌握知识点的整体分布。
      
       - **Individual Student Analysis:** Shows a student’s specific exam score along with a list of unmastered knowledge points.
    
         **个人学生分析：** 展示单个学生的考试分数，以及该学生未掌握的知识点清单。
      
        By reviewing these data and visualizations, parents and teachers can gain a comprehensive understanding of students’ academic progress and design more targeted educational strategies.
    
        通过这些数据与可视化图表，家长和教师能够全面了解学生的学习状况，从而制定更具针对性的教育策略。
      
---

## Project Architecture & Tech Stack
## 项目架构和技术栈
- 前端 (Frontend)：

  Bootstrap + Responsive Design

  The UI leverages Bootstrap 5 for responsive and modern design components.

  前端采用 Bootstrap 5 实现响应式与现代化的 UI 组件。
  
- 后端 (Backend)：
  
  SpringBoot + Flask + RESTful API

  The project utilizes Spring Boot with MyBatis for database operations and Maven for dependency management and project build.

  项目使用 Spring Boot 搭配 MyBatis 进行数据库操作，并使用 Maven 管理依赖与构建。
  
- 数据库 (Database)：

   MySQL + NaviCat
  
- AI 模块 (AI Module)：
  
  LangChain + OpenAI API

  Applied to the AI-assisted question-asking feature. The platform integrates Google Cloud Vision API and LangChain's AI agent. When users upload an image, the backend extracts text via Google Cloud Vision API, passes it to the LangChain AI agent, and generates intelligent tutoring responses.

  应用于 AI 辅助答疑功能。平台集成了 Google Cloud Vision API 与 LangChain AI Agent。用户上传图片后，后端利用 Vision API 提取文字，再交给 LangChain AI Agent 分析并生成智能辅导回答。

- 数据加密（Data Encryption）：

  We implemented RSA asymmetric encryption to secure sensitive data within the application.

  实现了 RSA 非对称加密，用于保护应用中的敏感数据。

- CI/CD / 持续集成与部署：

  We employed GitHub Actions as our CI/CD workflow to automate testing and deployment.

  使用 GitHub Actions 构建 CI/CD 工作流，实现测试与部署自动化。

---

## Configuration
## 环境配置
Set environment variable url to the MySQL database URL.

Requirements: Java 8.0, Python 3.12.2

```yaml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/ruanxie?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
    username: root
    password: 123456

server:
  port: 8181

mybatis:
  type-aliases-package: com.example.pojo
  mapper-locations: classpath:mybatis/mapper/*.xml
  config-locations: classpath:mybatis/mybatis-config.xml

Main Class: nextLearnApplication
```
---

## Deployment Instructions
## 部署说明
**Deploy to Production:**

1. Ensure the target production server has the necessary dependencies.

   确保目标服务器已安装必要的依赖。
   
3. Copy the project files to the server:

   将项目文件复制到服务器：
   
```bash
scp -r /local/path/to/nextlearn user@production_server:/path/to/deploy
```

3. Run the project using the same build and run commands mentioned above.

   使用相同的构建与运行命令启动项目。
   
4. Optionally, set up a CI/CD pipeline to automate the deployment process.

   可选：配置 CI/CD 流水线，实现自动化测试与部署。

---

## Project Demonstration
## 项目展示
**Stage1 Group Presentation / 阶段一小组汇报：**

[Link] (https://www.youtube.com/watch?v=qIol8uABpuU)

This stage mainly focuses on the requirements and UML diagrams of the project

