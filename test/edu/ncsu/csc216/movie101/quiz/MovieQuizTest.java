/*
 * Author:     John Andrew S Duvall
 * Date:       date
 * Project:    project
 */
package edu.ncsu.csc216.movie101.quiz;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alabastor
 */
public class MovieQuizTest {
    
    public MovieQuizTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of hasMoreQuestions method, of class MovieQuiz.
     */
    @Test
    public void testHasMoreQuestions() {
        System.out.println("hasMoreQuestions");
        MovieQuiz instance = null;
        boolean expResult = false;
        boolean result = instance.hasMoreQuestions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentQuestionText method, of class MovieQuiz.
     */
    @Test
    public void testGetCurrentQuestionText() throws Exception {
        System.out.println("getCurrentQuestionText");
        MovieQuiz instance = null;
        String expResult = "";
        String result = instance.getCurrentQuestionText();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentQuestionChoices method, of class MovieQuiz.
     */
    @Test
    public void testGetCurrentQuestionChoices() throws Exception {
        System.out.println("getCurrentQuestionChoices");
        MovieQuiz instance = null;
        String[] expResult = null;
        String[] result = instance.getCurrentQuestionChoices();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of processAnswer method, of class MovieQuiz.
     */
    @Test
    public void testProcessAnswer() throws Exception {
        System.out.println("processAnswer");
        String answer = "";
        MovieQuiz instance = null;
        String expResult = "";
        String result = instance.processAnswer(answer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumCorrectQuestions method, of class MovieQuiz.
     */
    @Test
    public void testGetNumCorrectQuestions() {
        System.out.println("getNumCorrectQuestions");
        MovieQuiz instance = null;
        int expResult = 0;
        int result = instance.getNumCorrectQuestions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumAttemptedQuestions method, of class MovieQuiz.
     */
    @Test
    public void testGetNumAttemptedQuestions() {
        System.out.println("getNumAttemptedQuestions");
        MovieQuiz instance = null;
        int expResult = 0;
        int result = instance.getNumAttemptedQuestions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
