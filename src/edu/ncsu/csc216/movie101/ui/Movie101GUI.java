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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Movie101GUI  extends JFrame implements ActionListener{

    private QuizMaster quiz;
    
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 600;
    
    private static final String TITLE = "Movies 101";
    private static final String SUBMIT = "Submit Answer";
    private static final String NEXT = "Next Question";
    private static final String QUIT = "Quit";
    private static final String ERROR = "Error";
    
    private JButton btnSubmit = new JButton(SUBMIT);
    private JButton btnNext = new JButton(NEXT);
    private JButton btnQuit = new JButton(QUIT);
    
    private JRadioButton btnAnswer1;
    private JRadioButton btnAnswer2;
    private JRadioButton btnAnswer3;
    private JRadioButton btnAnswer4;
    
    private JLabel question;
    private JLabel hint;
    private JLabel labelAnswer1;
    private JLabel labelAnswer2;
    private JLabel labelAnswer3;
    private JLabel labelAnswer4;
    
    private Container window = getContentPane();
    
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
            JOptionPane.showMessageDialog(new JFrame(), iae.getMessage(), ERROR, JOptionPane.ERROR_MESSAGE);
        }
        initializeUI();
    }
    private void initializeUI()
    {
        setSize(WIDTH,HEIGHT);
        setTitle(TITLE);
        
        try {
            String[] answers = quiz.getCurrentQuestionChoices();
            question = new JLabel(quiz.getCurrentQuestionText());
            labelAnswer1 = new JLabel(answers[0]);
            labelAnswer2 = new JLabel(answers[1]);
            labelAnswer3 = new JLabel(answers[2]);
            labelAnswer4 = new JLabel(answers[3]);
            hint = new JLabel(" ");
            
        } catch (EmptyQuestionListException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), ERROR, JOptionPane.ERROR_MESSAGE);
        }
        
        
        window.add(question);
        window.add(btnAnswer1);
        window.add(labelAnswer1);
        window.add(btnAnswer2);
        window.add(labelAnswer2);
        window.add(btnAnswer3);
        window.add(labelAnswer3);
        window.add(btnAnswer4);
        window.add(labelAnswer4);
        window.add(hint);
        
        window.add(btnNext);
        window.add(btnQuit);
        window.add(btnSubmit);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(btnSubmit))
        {
            //Submit logic
        }
        if(ae.getSource().equals(btnNext))
        {
            //Next button logic
        }
        if(ae.getSource().equals(btnQuit))
        {
            stopExecution();
        }
    }
    //ADDITION!

    private static void stopExecution() {
        System.exit(0);
    }
    
    public static void main(String [] args)
    {
        try
        {
            if(args.length > 0)
            {
                new Movie101GUI(args[0]);
            }
            else
                new Movie101GUI(null);
        }
        catch(IllegalArgumentException iae)
        {
            JOptionPane.showMessageDialog(new JFrame(), "Incorrect Quiz File Selected");
            stopExecution();
        }
    }
}
