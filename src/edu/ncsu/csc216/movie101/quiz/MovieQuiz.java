/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ncsu.csc216.movie101.quiz;

import edu.ncsu.csc216.movie101.util.EmptyQuestionListException;

public class MovieQuiz implements QuizMaster{

    /**
     * Are there any more questions remaining in this test?
     * @return true if there are, false if there are not
     */
    @Override
    public boolean hasMoreQuestions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Get the text for the current question.
     * @return the current question text
     * @throws EmptyQuestionListException if there is no current question
     */
    @Override
    public String getCurrentQuestionText() throws EmptyQuestionListException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    	/**
	 * Get the possible answers for the current question
	 * @return the possible answers for the current question -- each answer
	 *         is a separate array element
	 * * @throws EmptyQuestionListException if there is no current question
	 */
    @Override
    public String[] getCurrentQuestionChoices() throws EmptyQuestionListException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String processAnswer(String answer) throws EmptyQuestionListException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNumCorrectQuestions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNumAttemptedQuestions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
