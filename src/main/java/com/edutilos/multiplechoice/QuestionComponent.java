package com.edutilos.multiplechoice;


import javax.swing.*;
import java.awt.*;

public class QuestionComponent extends JPanel{

    private Question question ;

    public QuestionComponent(Question question) {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      this.question = question;
        addComponents();
    }


    private ButtonGroup bg = new ButtonGroup();
    private JRadioButton rbA , rbB , rbC , rbD ;
    public void addComponents() {
        rbA = new JRadioButton(question.getChoiceA());
        rbB = new JRadioButton(question.getChoiceB());
        rbC = new JRadioButton(question.getChoiceC());
        rbD = new JRadioButton(question.getChoiceD());
        bg.add(rbA);
        bg.add(rbB);
        bg.add(rbC);
        bg.add(rbD);
        JPanel panelButtons = new JPanel();
        panelButtons.add(rbA);
        panelButtons.add(rbB);
        panelButtons.add(rbC);
        panelButtons.add(rbD);

        JLabel lblQuest = new JLabel(question.getQuest());
        this.add(lblQuest);
        this.add(panelButtons);
    }

    public String getSelectedAnswer() {
        if(rbA.isSelected()) return rbA.getText();
        if(rbB.isSelected()) return rbB.getText();
        if(rbC.isSelected()) return rbC.getText();
        if(rbD.isSelected()) return rbD.getText();
        return null ;
    }


    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
