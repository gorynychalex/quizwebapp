package ru.popovich.server.model1;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;

@XmlRootElement
public class QuestionImpl extends QuizAbstract implements OptionInterface {

    public QuestionImpl(String name, List<OptionInterface> optionInterfaces) {
        super(name, optionInterfaces);
    }


    public void startQuiz() {

        setStartTime(new Date());

    }

    public void stopQuiz() {
        setStopTime(new Date());

    }

    public byte getResult() {
        return 0;
    }

    public void setOptions(OptionInterface optionInterface) {

    }
}
