package ru.popovich.server.controller;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class StartQuizController extends HttpServlet {

    public static final String[] quizNames = {"Java", "Android", "Database", "Patterns"};

    public static final String[] users = {"Попович Алексей Борисович", "Иванов Иван Иванович"};

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        session.setAttribute("quizNames", quizNames);
        session.setAttribute("users", users);

        req.getRequestDispatcher("/web/index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



    }
}
