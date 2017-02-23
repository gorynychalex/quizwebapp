package ru.popovich.server.model1;


public interface QuizInterface {

    void startQuiz();
    void stopQuiz();
    byte getResult();
    void setOptions(OptionInterface optionInterface);

}
