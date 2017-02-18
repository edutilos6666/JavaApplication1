package com.edutilos.multiplechoice;


import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class Main extends JFrame {

    public static void main(String[] args) {
        new Main("Multiple Choice Example");
    }

    public Main(String title) {
        super(title);
        prepareGUI();
    }



    public void prepareGUI() {
        this.setSize(new Dimension(500, 500));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addComponents();
        registerEvents();
        this.setVisible(true);
    }

    private JPanel panelRoot ;
    private List<QuestionComponent> listComps;
    private JButton btnCheck ;

    public void addComponents()  {
        panelRoot = new JPanel();
        panelRoot.setLayout(new BoxLayout(panelRoot, BoxLayout.Y_AXIS));
        this.getContentPane().add(panelRoot);

        listComps = generateQuestionComponents();
        for(QuestionComponent comp: listComps)
            panelRoot.add(comp);

        btnCheck = new JButton("Check");
        panelRoot.add(btnCheck);
    }


     public void registerEvents() {
         btnCheck.addActionListener(l -> {
             int rightAnswers = 0 , wrongAnswers = 0 ;
           for(QuestionComponent comp: listComps) {
               Question question = comp.getQuestion();
               String rightAnswer = question.getRightAnswer();
               String selectedAnswer = comp.getSelectedAnswer();
               if(rightAnswer.equals(selectedAnswer)) {
                   rightAnswers++;
               } else {
                   wrongAnswers++;
               }
           }

             new ResultDialog(Main.this, rightAnswers, wrongAnswers);
         });
     }


    private List<QuestionComponent> generateQuestionComponents() {
        List<Question> list = generateQuestions();
        List<QuestionComponent> listComps = new ArrayList<>(list.size());
        for(Question q: list) {
            listComps.add(new QuestionComponent(q));
        }
        return listComps;
    }
    private List<Question> generateQuestions() {
        List<Question> list = new ArrayList<>();
/*        list.add(new Question("1+2 = ", "1", "2", "3", "4", "3"));
        list.add(new Question("1+2 = ", "1", "2", "3", "4", "3"));
        list.add(new Question("1+2 = ", "1", "2", "3", "4", "3"));
        list.add(new Question("1+2 = ", "1", "2", "3", "4", "3"));
        list.add(new Question("1+2 = ", "1", "2", "3", "4", "3"));*/


        list.add(new Question("Which of the following is not a keyword in java?", "static", "Boolean", "void","private", "Boolean"));
        list.add(new Question("What is the default value of byte variable?", "0", "0.0", "null", "undefined", "0"));
        list.add(new Question("Which of the following is true about String?", "String is mutable.", "String is immutable.", "String is a data type.",
                "None of the above.", "String is immutable."));

        list.add(new Question("What is an immutable object?", " An immutable object can be changed once it is created.",
                "An immutable object can't be changed once it is created.",
                "An immutable object is an instance of an abstract class.", "None of the above.",
                "An immutable object can't be changed once it is created."));


        list.add(new Question("What kind of variables a class can consist of?",
                "class variables, instance variables", "class variables, local variables, instance variables",
                "class variables", "class variables, local variables","class variables, local variables, instance variables" ));
        return list ;
    }
}
