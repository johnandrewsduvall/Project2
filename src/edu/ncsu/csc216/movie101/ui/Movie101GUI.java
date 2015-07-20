/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ncsu.csc216.movie101.ui;

import edu.ncsu.csc216.movie101.quiz.*;
import edu.ncsu.csc216.question_library.QuestionException;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import javax.swing.*;

public class Movie101GUI  extends JFrame implements ActionListener{

    private MovieQuiz quiz;
    
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
    
    private JRadioButton answer1;
    private JRadioButton answer2;
    private JRadioButton answer3;
    private JRadioButton answer4;
    
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
        
    }
    private void initializeUI()
    {
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
