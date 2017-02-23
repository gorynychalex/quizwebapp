package ru.popovich.server.model;

import java.util.List;

public class Student  extends User {

    private String groupName;
    private List<Integer> availQuizId;
    private List<Integer> chooseQuizId;

    public Student(int id, String firstname, String lastname, String password, String userCategory) {
        super(id, firstname, lastname, password, userCategory);
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Integer> getAvailQuizId() {
        return availQuizId;
    }

    public void setAvailQuizId(List<Integer> availQuizId) {
        this.availQuizId = availQuizId;
    }

    public List<Integer> getChooseQuizId() {
        return chooseQuizId;
    }

    public void setChooseQuizId(List<Integer> chooseQuizId) {
        this.chooseQuizId = chooseQuizId;
    }
}
