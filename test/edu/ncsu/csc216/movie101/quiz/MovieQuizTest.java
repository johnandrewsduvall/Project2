/*
 * Author:     John Andrew S Duvall
 * Date:       date
 * Project:    project
 */
package edu.ncsu.csc216.movie101.quiz;


import java.util.Arrays;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc216.movie101.util.EmptyQuestionListException;
import edu.ncsu.csc216.question_library.QuestionException;


public class MovieQuizTest extends TestCase {
	
	private MovieQuiz mq;
    @Before
    public void setUp() throws QuestionException {
    	mq = new MovieQuiz("questions1.xml");
    }
    


    /**
     * Test of hasMoreQuestions method, of class MovieQuiz.
     */
    @Test
    public void testHasMoreQuestions() {
       assertTrue(mq.hasMoreQuestions());
    }

    /**
     * Test of getCurrentQuestionText method, of class MovieQuiz.
     */
    @Test
    public void testGetCurrentQuestionText() throws Exception {
    	assertEquals("Standard Question 1", mq.getCurrentQuestionText());
    	mq.processAnswer("d"); //correct answer move on
    	assertEquals("Standard Question 2", mq.getCurrentQuestionText());
    	mq.processAnswer("c"); //correct move up to advanced
    	assertEquals("Advanced Question 1", mq.getCurrentQuestionText());
    	mq.processAnswer("c"); //incorrect move down to standard
    	assertEquals("Standard Question 1", mq.getCurrentQuestionText());
    	mq.processAnswer("a"); //incorrect move down to elementary
    	assertEquals("Elementary Question 1", mq.getCurrentQuestionText());
    	mq.processAnswer("a"); //incorrect first try repeat question
    	assertEquals("Elementary Question 1", mq.getCurrentQuestionText());
    	mq.processAnswer("b"); //incorrect second try move to next question
    	assertEquals("Elementary Question 2", mq.getCurrentQuestionText());
    }

    /**
     * Test of getCurrentQuestionChoices method, of class MovieQuiz.
     */
    @Test
    public void testGetCurrentQuestionChoices() throws Exception {
    	String[] questionChoice = new String[4];
    	questionChoice[0] = "Choice a";
    	questionChoice[1] = "Choice b";
    	questionChoice[2] = "Choice c";
    	questionChoice[3] = "The Correct Answer";
    
    	String[] realChoice;
    	realChoice = mq.getCurrentQuestionChoices();
        assertTrue(Arrays.equals(realChoice, questionChoice));
    }

    /**
     * Test of processAnswer method, of class MovieQuiz.
     */
    @Test
    public void testProcessAnswer() throws Exception {
        assertEquals("Correct!", mq.processAnswer("d"));
        assertEquals("Correct!", mq.processAnswer("c"));
        assertEquals("Correct! Good Job!", mq.processAnswer("d"));
        assertEquals("Incorrect", mq.processAnswer("l"));
        assertEquals("Incorrect", mq.processAnswer("f"));
        assertEquals("Incorrect Here is a hint. The correct answer is d.", mq.processAnswer("a"));
    }

    /**
     * Test of getNumCorrectQuestions method, of class MovieQuiz.
     * @throws EmptyQuestionListException 
     */
    @Test
    public void testGetNumCorrectQuestions() throws EmptyQuestionListException {
    	assertEquals(0, mq.getNumCorrectQuestions());
        mq.processAnswer("d"); //correct answer
        assertEquals(1, mq.getNumCorrectQuestions());
        mq.processAnswer("s"); //incorrect answer
        assertEquals(1, mq.getNumCorrectQuestions());
    }

    /**
     * Test of getNumAttemptedQuestions method, of class MovieQuiz.
     * @throws EmptyQuestionListException 
     */
    @Test
    public void testGetNumAttemptedQuestions() throws EmptyQuestionListException {
        assertEquals(0, mq.getNumAttemptedQuestions());
        mq.processAnswer("d"); //correct answer
        assertEquals(1, mq.getNumAttemptedQuestions());
        mq.processAnswer("f"); //incorrect answer
        assertEquals(2, mq.getNumAttemptedQuestions());
        mq.processAnswer("f"); //incorrect elementary answer retry same attempt
        assertEquals(2, mq.getNumAttemptedQuestions());
        mq.processAnswer("f"); //second attempt move on to next question
        assertEquals(3, mq.getNumAttemptedQuestions());
    }
}
