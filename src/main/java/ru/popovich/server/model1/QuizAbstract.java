package ru.popovich.server.model1;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;

//Common optionInterfaces for Quiz, Question, Option

@XmlRootElement
public abstract class QuizAbstract implements QuizInterface {

    private Number id;
    private String name;
    private String text;
    private Date startTime;
    private Date stopTime;
    private float mark;

    private List<OptionInterface> options;

    public QuizAbstract(){}

    public QuizAbstract(String name, List<OptionInterface> optionInterfaces) {
        this.name = name;
        this.options = optionInterfaces;
    }

    public Number getId() {
        return id;
    }

    public void setId(Number id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getStopTime() {
        return stopTime;
    }

    public void setStopTime(Date stopTime) {
        this.stopTime = stopTime;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    public List<OptionInterface> getOptionInterfaces() {
        return options;
    }

    public void setOptionInterfaces(List<OptionInterface> optionInterfaces) {
        this.options = optionInterfaces;
    }
}
