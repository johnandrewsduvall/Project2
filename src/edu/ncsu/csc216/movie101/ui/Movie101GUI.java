/*
 * @Author: John Andrew S Duvall
 * Date: 27 July 2015
 * Project: CSC 216 Project 2, Part 2
 */

package edu.ncsu.csc216.movie101.ui;

import edu.ncsu.csc216.movie101.quiz.*;
import edu.ncsu.csc216.movie101.util.EmptyQuestionListException;
import edu.ncsu.csc216.question_library.QuestionException;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * The GUI for Movie Quiz 101
 * 
 */
public class Movie101GUI  extends JFrame
{
    //Variable Declaration
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
    private String selectedAnswer;
    ButtonGroup ansBtnGroup;
    private JRadioButton btnAnswer1;
    private JRadioButton btnAnswer2;
    private JRadioButton btnAnswer3;
    private JRadioButton btnAnswer4;
    
    private JLabel question;
    private JLabel messageLabel;
    
    private Container window ;
    
    //Constructor, if the user send the filename in the command line argument, the filename is used.  Otherwise, a file chooser is opened for the user to selection the question xml file.
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
    //Initial build of GUI
    private void initializeUI()
    {
        
        setSize(FRAME_WIDTH,FRAME_HEIGHT);
        setTitle(TITLE);
        window = getContentPane();
        window.setLayout(new GridLayout(0,1,10,10));
        
        
        
        try {
        String[] answers = quiz.getCurrentQuestionChoices();
        question = new JLabel(quiz.getCurrentQuestionText());
        messageLabel = new JLabel(" ");
        
        } catch (EmptyQuestionListException ex) {
        JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), QUIZ_ERROR, JOptionPane.ERROR_MESSAGE);
        }
        
        //Test Strings
        /*question = new JLabel("Question");
        answers[0] = "Answer 1";
        answers[1] = "Answer 2";
        answers[2] = "Answer 3";
        answers[3] = "Answer 4";*/
        
        btnAnswer1 = new JRadioButton("A"+answers[0]);
        btnAnswer2 = new JRadioButton("B"+answers[1]);
        btnAnswer3 = new JRadioButton("C"+answers[2]);
        btnAnswer4 = new JRadioButton("D"+answers[3]);
        messageLabel = new JLabel(" "); 
        
        window.add(question);
        
        window.add(btnAnswer1);
        window.add(btnAnswer2);
        window.add(btnAnswer3);
        window.add(btnAnswer4);
        
        window.add(messageLabel);
        
        ButtonGroup pushBtnGroup = new ButtonGroup();
        pushBtnGroup.add(btnNext);
        pushBtnGroup.add(btnQuit);
        pushBtnGroup.add(btnSubmit);
        btnNext.setEnabled(false);
        btnSubmit.setEnabled(false);
        
        window.add(btnSubmit);
        window.add(btnNext);
        window.add(btnQuit);
        
        
        ansBtnGroup = new ButtonGroup();
        ansBtnGroup.add(btnAnswer1);
        ansBtnGroup.add(btnAnswer2);
        ansBtnGroup.add(btnAnswer3);
        ansBtnGroup.add(btnAnswer4);
        
        ButtonHandler btnHandler = new ButtonHandler();
        
        btnNext.addActionListener(btnHandler);
        btnQuit.addActionListener(btnHandler);
        btnSubmit.addActionListener(btnHandler);
        btnAnswer1.addItemListener(btnHandler);
        btnAnswer2.addItemListener(btnHandler);
        btnAnswer3.addItemListener(btnHandler);
        btnAnswer4.addItemListener(btnHandler);
        
        setVisible(true);
    }
    //Brings up the next question once the "Next" button is pressed.
    private void refreshWindow()
    {
        ansBtnGroup.clearSelection();
        question.setText("New Question");
        btnAnswer1.setText("New Answer 1");
        btnAnswer2.setText("New Answer 2");
        btnAnswer3.setText("New Answer 3");
        btnAnswer4.setText("New Answer 4");
        messageLabel.setText(" ");
        btnNext.setEnabled(false);
        btnSubmit.setEnabled(false);
    }
    //This method handles all user interactions with the UI
    private class ButtonHandler implements ActionListener, ItemListener
    {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(ae.getSource().equals(btnSubmit))
            {
                messageLabel.setText("Correct!");
                btnNext.setEnabled(true);
                btnSubmit.setEnabled(false);
                /*try {
                quiz.processAnswer(TITLE);
                } catch (EmptyQuestionListException ex) {
                JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }*/
            }
            //Actions for the "Next" Button 
            if(ae.getSource().equals(btnNext))
            {
                refreshWindow();
            }
            //Actions for the "Quit" button
            if(ae.getSource().equals(btnQuit))
            {
                JOptionPane.showMessageDialog(new JFrame("End of Quiz"), "You Answered "+0+ " questions correctly out of a possible " +0);
                //JOptionPane.showMessageDialog(new JFrame("End of Quiz"), "You Answered "+quiz.getNumCorrectQuestions()+ " questions correctly out of  possible" +quiz.getNumAttemptedQuestions());
                stopExecution();
            }
        }

        @Override
        public void itemStateChanged(ItemEvent ie) {
            btnSubmit.setEnabled(true);
            if(ie.getSource()==btnAnswer1)
            {
                selectedAnswer = "a";
                
            }
            else if(ie.getSource()==btnAnswer2)
            {
                selectedAnswer = "b";
                
            }
            else if(ie.getSource()==btnAnswer3)
            {
                selectedAnswer = "c";
                
            }
            else if(ie.getSource()==btnAnswer4)
            {
                selectedAnswer = "d";
                
            }
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
