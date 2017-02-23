package ru.popovich.server.controller;


import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.core.Application;

@ApplicationPath("rest")
public class ApplicationRest extends Application{

    @GET
    public String getText(){
        return "Any text";
    }

}
