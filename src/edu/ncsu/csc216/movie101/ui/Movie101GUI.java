/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ncsu.csc216.movie101.ui;

import edu.ncsu.csc216.movie101.quiz.*;
import edu.ncsu.csc216.movie101.util.EmptyQuestionListException;
import edu.ncsu.csc216.question_library.QuestionException;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Movie101GUI  extends JFrame
{

    private QuizMaster quiz;
    
    
    private static final int FRAME_WIDTH = 600;
    private static final int FRAME_HEIGHT = 300;
    
    private static final String TITLE = "Movies 101";
    private static final String SUBMIT = "Submit Answer";
    private static final String NEXT = "Next Question";
    private static final String QUIT = "Quit";
    private static final String QUIZ_ERROR = "Error";
    
    private final JLabel SPACER = new JLabel(" ");
    
    private JButton btnSubmit = new JButton(SUBMIT);
    private JButton btnNext = new JButton(NEXT);
    private JButton btnQuit = new JButton(QUIT);
    
    private String[] answers = new String[4];
    private JRadioButton btnAnswer1;
    private JRadioButton btnAnswer2;
    private JRadioButton btnAnswer3;
    private JRadioButton btnAnswer4;
    
    private JLabel question;
    private JLabel hint;
    
    private Container window ;
    
    public Movie101GUI(String filename)
    {
        try
        {
            if(filename == null)
            {
                String userPickFile = null;
                JFileChooser fc = new JFileChooser(".");
                fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                int returnVal = fc.showOpenDialog(fc);
                if(returnVal== JFileChooser.APPROVE_OPTION)
                {
                    userPickFile = fc.getSelectedFile().getName();
                }
                quiz = new MovieQuiz(userPickFile);
                
            }
            else
            {
                quiz = new MovieQuiz(filename);
            }
        }
        catch(IllegalArgumentException | QuestionException iae)
        {
            JOptionPane.showMessageDialog(new JFrame(), iae.getMessage(), QUIZ_ERROR, JOptionPane.ERROR_MESSAGE);
        }
        initializeUI();
    }
    private void initializeUI()
    {
        
        setSize(FRAME_WIDTH,FRAME_HEIGHT);
        setTitle(TITLE);
        window = getContentPane();
        window.setLayout(new GridLayout(0,3,10,10));
        
        
        /*
        try {
            String[] answers = quiz.getCurrentQuestionChoices();
            question = new JLabel(quiz.getCurrentQuestionText());
            labelAnswer1 = new JLabel(answers[0]);
            labelAnswer2 = new JLabel(answers[1]);
            labelAnswer3 = new JLabel(answers[2]);
            labelAnswer4 = new JLabel(answers[3]);
            hint = new JLabel(" ");
            
        } catch (EmptyQuestionListException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), QUIZ_ERROR, JOptionPane.ERROR_MESSAGE);
        }
        */
        //Test Strings
        answers[0] = "Answer 1";
        answers[1] = "Answer 2";
        answers[2] = "Answer 3";
        answers[3] = "Answer 4";
        
        question = new JLabel("Question!");
        btnAnswer1 = new JRadioButton(answers[0]);
        btnAnswer2 = new JRadioButton(answers[1]);
        btnAnswer3 = new JRadioButton(answers[2]);
        btnAnswer4 = new JRadioButton(answers[3]);
        hint = new JLabel(" ");
        
        
        
        
        window.add(question);
        
        window.add(btnAnswer1);
        window.add(btnAnswer2);
        window.add(btnAnswer3);
        window.add(btnAnswer4);
        
        window.add(hint);
        
        window.add(btnNext);
        window.add(btnQuit);
        window.add(btnSubmit);
        
        ButtonGroup ansBtnGroup = new ButtonGroup();
        ansBtnGroup.add(btnNext);
        ansBtnGroup.add(btnQuit);
        ansBtnGroup.add(btnSubmit);
        
        ButtonHandler btnHandler = new ButtonHandler();
        
        btnNext.addActionListener(btnHandler);
        btnQuit.addActionListener(btnHandler);
        btnSubmit.addActionListener(btnHandler);
        
        setVisible(true);
    }
    
    private void refreshWindow()
    {
        question.setText("New Question");
        btnAnswer1.setText("New Answer 1");
        btnAnswer2.setText("New Answer 2");
        btnAnswer3.setText("New Answer 3");
        btnAnswer4.setText("New Answer 4");
        
    }
    
    private class ButtonHandler implements ActionListener, ItemListener
    {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(ae.getSource().equals(btnSubmit))
            {
                try {
                    quiz.processAnswer(TITLE);
                } catch (EmptyQuestionListException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }
            }
            if(ae.getSource().equals(btnNext))
            {
                refreshWindow();
            }
            if(ae.getSource().equals(btnQuit))
            {
                stopExecution();
            }
        }

        @Override
        public void itemStateChanged(ItemEvent ie) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    

    private static void stopExecution() {
        System.exit(0);
    }
    
    public static void main(String [] args)
    {
        Movie101GUI mv101;
        try
        {
            
            if(args.length > 0)
            {
                mv101 = new Movie101GUI(args[0]);
            }
            else
            {
                mv101 = new Movie101GUI(null);
            }
            mv101.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        catch(IllegalArgumentException iae)
        {
            JOptionPane.showMessageDialog(new JFrame(), "Incorrect Quiz File Selected");
            stopExecution();
        }
        
    }
}
