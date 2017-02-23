package ru.popovich.server.model1;


import ru.popovich.server.model1.OptionInterface;
import ru.popovich.server.model1.QuizAbstract;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class OptionImpl extends QuizAbstract implements OptionInterface {

    private boolean correct;
    private boolean userAnswer;

    public OptionImpl(String text, boolean correct){
        setText(text);
        this.correct = correct;
    }

    public void startQuiz() {
        setStartTime(new Date());

    }

    public void stopQuiz() {

    }

    public byte getResult() {
        return 0;
    }

    public void setOptions(OptionInterface optionInterface) {

    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public boolean isUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(boolean userAnswer) {
        this.userAnswer = userAnswer;
    }
}
