package ru.popovich.server.controller;

import ru.popovich.server.model.*;
import ru.popovich.server.model1.OptionImpl;
import ru.popovich.server.model1.OptionInterface;
import ru.popovich.server.model1.QuestionImpl;
import ru.popovich.server.model1.QuizImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class QuizController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    static Quiz quiz;
    static QuizImpl quiz1;

    static Question question;
    static QuestionImpl question1;

    static List<Question> questions;
    static List<OptionInterface> questions1;

    static List<Option> options;
    static List<OptionInterface> options1;

    static Map<Integer,Quiz> userQuizCurrent = new HashMap<Integer, Quiz>();
    static Map<Integer, Integer> usersQuestionCurrent = new HashMap<Integer, Integer>();
    static int userIdCurrent, quizIdCurrent, questionIdcurrent=0;
    //initialise question
    static {
        addQuiz(); addQuestions();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Проверка GET userId. Назначаем локальной переменной. Если отсутствует - перенаправляем на start
        if(req.getParameter("userId") != null) {
            userIdCurrent = Integer.parseInt(req.getParameter("userId"));
            req.setAttribute("userId",userIdCurrent);
        }
        else {
            req.getRequestDispatcher("start").forward(req,resp);
        }

        // Проверка quizId. Если есть и есть соответствие userId - quizId, то просто назначаем quizIdCurrent
        if(req.getParameter("quizId") != null && quiz != null){

            quizIdCurrent=Integer.parseInt(req.getParameter("quizId"));

        } else if (req.getParameter("quizId") != null && userQuizCurrent.get(userIdCurrent) != null && quiz == null){

            userQuizCurrent.put(userIdCurrent,quiz);

            quizIdCurrent=Integer.parseInt(req.getParameter("quizId"));

        } else if (req.getParameter("quizId") != null && userQuizCurrent.get(userIdCurrent) != null && quiz == null){

            addQuestions();

            userQuizCurrent.put(userIdCurrent,quiz);

            quizIdCurrent=Integer.parseInt(req.getParameter("quizId"));

        }
        else {

            req.getRequestDispatcher("start").forward(req,resp);
        }


        questionIdcurrent = req.getParameter("questionId") != null? Integer.parseInt(req.getParameter("questionId")) : 0;
        req.setAttribute("questionId",questionIdcurrent);
        usersQuestionCurrent.put(userIdCurrent,questionIdcurrent);

        //Переход на post
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();


        // Запись результата при его наличии
        if(req.getParameter("option") != null){
            quiz.getQuestions()
                    .get(questionIdcurrent)
                    .getOptions()
                    .get(Integer.parseInt(req.getParameter("option")))
                    .setUserAnswer(true);
        }

        if(req.getParameter("action").equals("finishQuiz")){
            int[] resultInt = new int[quiz.getQuestions().size()];
            for (int i = 0; i < quiz.getQuestions().size(); i++) {
                resultInt[i]=(int) quiz.getQuestions().get(i).getResult();
            }
            session.setAttribute("result",resultInt);
            req.getRequestDispatcher("/web/result.jsp").forward(req,resp);
        }

        //Если questionId передан, то назначаеться переменная состояния
        if(req.getParameter("questionId") != null){

            if(req.getParameter("action") != null ) {
                //Если нажата кнопка Next, Prev
                if (req.getParameter("action").equals("nextQuestionButton")) {
                    ++questionIdcurrent;
                } else if (req.getParameter("action").equals("prevQuestionButton")) {
                    --questionIdcurrent;
                }
                else {
                    questionIdcurrent = Integer.parseInt(req.getParameter("questionId"));
                }
            }
        }

        req.setAttribute("questionId",questionIdcurrent);
        usersQuestionCurrent.put(userIdCurrent,questionIdcurrent);

        //Выбрать вопрос из массива вопросов исходя из текущего номера вопроса
        session.setAttribute("question",quiz.getQuestions().get(questionIdcurrent));
        session.setAttribute("quizName",quiz.getName());
        session.setAttribute("questionNums",quiz.getQuestions().size());

        // Параметры для кнопок Next & Prev
        if(questionIdcurrent < (quiz.getQuestions().size()-1)) {
            session.setAttribute("nextId", (questionIdcurrent + 1));
        } else session.removeAttribute("nextId");

        if(questionIdcurrent > 0){
            session.setAttribute("prevId", (questionIdcurrent - 1));
        } else session.removeAttribute("prevId");

        req.getRequestDispatcher("/web/question.jsp").forward(req, resp);
    }

    protected static void addQuestions(){

        questions = new ArrayList<Question>();

        options = new ArrayList<Option>();
        options.add(new Option("abstraction,incapsulation,polimorphism",true));
        options.add(new Option("objection,hierarhial,polimorphism",false));
        options.add(new Option("function common style",false));
        question = new Question(0,"OOP-principles", options);
        questions.add(question);

        options = new ArrayList<Option>();
        options.add(new Option("toString()",true));
        options.add(new Option("object()",false));
        options.add(new Option("toHash()",false));
        question = new Question(1,"Object has methods: ", options);
        questions.add(question);

        options = new ArrayList<Option>();
        options.add(new Option("abstract class",true));
        options.add(new Option("implement",false));
        options.add(new Option("simple method",false));
        question = new Question(2,"Interface: ", options);
        questions.add(question);

        quiz = new Quiz("Java",questions);

    }

    protected static void addQuiz(){
        questions1 = new ArrayList<OptionInterface>();

        options1 = new ArrayList<OptionInterface>();
        options1.add(new OptionImpl("Абстракция, инкапсуляция, наследование, полиморфизм", true));
        options1.add(new OptionImpl("Иерархичность, поведение, условия, полиморфизм", false));
        options1.add(new OptionImpl("Агрегация, объектность, морфизм", false));
        questions1.add(new QuestionImpl("Принципы Объектно-ориентированного программирования",options1));

        options1 = new ArrayList<OptionInterface>();
        options1.add(new OptionImpl("toString()", true));
        options1.add(new OptionImpl("codeHash()", false));
        options1.add(new OptionImpl("result()", false));
        questions1.add(new QuestionImpl("Методы, имеющиеся у всех объектов",options1));

        options1 = new ArrayList<OptionInterface>();
        options1.add(new OptionImpl("абстрактный метод", true));
        options1.add(new OptionImpl("простой класс", false));
        options1.add(new OptionImpl("метод", false));
        questions1.add(new QuestionImpl("Interface",options1));

        quiz1 = new QuizImpl("Java", questions1);
    }
}
