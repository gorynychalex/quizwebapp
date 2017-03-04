package ru.popovich.server.controller;

import ru.popovich.server.controller.*;
import ru.popovich.server.model.Question;
import ru.popovich.server.model.Quiz;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("questrs")
public class QuizQuestionRest {

    @Path("all")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Question> getQuestions(){
        return QuizController.quiz.getQuestions();
    }


    @GET
    @Path("{qid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Question getQuestion(@PathParam("qid") int id){
        if(id > QuizController.quiz.getQuestions().size()-1)
            return QuizController.quiz.getQuestions().get(QuizController.quiz.getQuestions().size()-1);
        else
            return QuizController.quiz.getQuestions().get(id);
    }

    @GET
    @Path("text")
    public String getText(){
        return "Hello from rest/questrs!";
    }
}
