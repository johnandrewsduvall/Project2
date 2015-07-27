/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ncsu.csc216.movie101.quiz;

import edu.ncsu.csc216.movie101.question.MovieQuestions;
import edu.ncsu.csc216.movie101.util.EmptyQuestionListException;
import edu.ncsu.csc216.question_library.*;

public class MovieQuiz implements QuizMaster{
    private QuestionReader reader;
    private MovieQuestions questions;
    public MovieQuiz(String filename) throws QuestionException {
        reader = new QuestionReader(filename);
        questions = new MovieQuestions(reader.getStandardQuestions(), reader.getElementaryQuestions(), reader.getAdvancedQuestions());
    }

    /**
     * Are there any more questions remaining in this test?
     * @return true if there are, false if there are not
     */
    public boolean hasMoreQuestions() {
        return questions.hasMoreQuestions();
    }

    /**
     * Get the text for the current question.
     * @return the current question text
     * @throws EmptyQuestionListException if there is no current question
     */
    public String getCurrentQuestionText() throws EmptyQuestionListException {
        return questions.getCurrentQuestionText();
    }

    /**
     * Get the possible answers for the current question
     * @return the possible answers for the current question -- each answer
     *         is a separate array element
     * * @throws EmptyQuestionListException if there is no current question
     * @throws edu.ncsu.csc216.movie101.util.EmptyQuestionListException
     */
    public String[] getCurrentQuestionChoices() throws EmptyQuestionListException {
    	return questions.getCurrentQuestionChoices();
    }

    /**
    * Process the user's answer to the current question.
    * @param answer  the user's answer to the question
    * @return the graded response to the question
    * @throws EmptyQuestionListException if there is no current question
    */
    public String processAnswer(String answer) throws EmptyQuestionListException {
		return questions.processAnswer(answer);
		
    }

    /**
    * How many questions has the user answered correctly?
    * @return the number of correct answers
    */
    public int getNumCorrectQuestions() {
        return questions.getNumCorrectQuestions();
    }

    /**
    * How many questions has the user attempted to answer.
    * @return the number of attempts
    */
    public int getNumAttemptedQuestions() {
       return questions.getNumAttemptedQuestions();
    }
    
}
