package ru.popovich.server.controller;

import ru.popovich.server.model.Question;
import ru.popovich.server.model.Quiz;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class QuizController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    Quiz quiz;

    Question question;

    List<Question> questions;

    List<String> options;

    //initialise question
    { addQuestions();}


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        int n = 0;
        String reqQuestionId;
        if(quiz != null) {
            session.setAttribute("quizName",quiz.getName());
            session.setAttribute("questionNums", quiz.getQuestions().size());
            if ((reqQuestionId = req.getParameter("questionId")) != null && req.getParameter("action").equals("Next") && (n = Integer.parseInt(reqQuestionId)) < quiz.getQuestions().size()-1) {
                session.setAttribute("question", quiz.getQuestions().get(n+1));
            } else if(reqQuestionId != null && req.getParameter("action").equals("Prev") && (n = Integer.parseInt(reqQuestionId)) >= 1){
                session.setAttribute("question", quiz.getQuestions().get(n-1));
            } else if(reqQuestionId != null && req.getParameter("action").equals("Finish")){
                req.getRequestDispatcher("/index.html").forward(req, resp);
            } else {
                session.setAttribute("question", quiz.getQuestions().get(0));
            }
        }

        req.getRequestDispatcher("/web/question.jsp").forward(req, resp);
    }

    protected void addQuestions(){

        questions = new ArrayList<Question>();

        options = new ArrayList<String>();
        options.add("abstraction");
        options.add("incapsulation");
        options.add("polimorphism");
        question = new Question(0,"OOP-principles", options);
        questions.add(question);

        options = new ArrayList<String>();
        options.add("toString()");
        options.add("hashCode()");
        options.add("equals()");
        question = new Question(1,"Object has methods: ", options);
        questions.add(question);

        options = new ArrayList<String>();
        options.add("abstract method");
        options.add("simple class");
        options.add("method");
        question = new Question(2,"Interface: ", options);
        questions.add(question);

        quiz = new Quiz("Java",questions);

    }
}
