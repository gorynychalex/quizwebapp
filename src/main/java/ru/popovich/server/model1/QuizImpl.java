package ru.popovich.server.model1;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class QuizImpl extends QuizAbstract {

    public QuizImpl(String name, List<OptionInterface> optionInterfaces) {
        super(name, optionInterfaces);
    }

    public void startQuiz() {

    }

    public void stopQuiz() {

    }

    public byte getResult() {
        return 0;
    }

    public void setOptions(OptionInterface optionInterface) {

    }
}
