/*
 * Author:     John Andrew S Duvall
 * Date:       date
 * Project:    project
 */
package edu.ncsu.csc216.movie101.question;

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
public class MovieQuestionsTest {
    
    public MovieQuestionsTest() {
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
     * Test of hasMoreQuestions method, of class MovieQuestions.
     */
    @Test
    public void testHasMoreQuestions() {
        System.out.println("hasMoreQuestions");
        MovieQuestions instance = null;
        boolean expResult = false;
        boolean result = instance.hasMoreQuestions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentQuestionText method, of class MovieQuestions.
     */
    @Test
    public void testGetCurrentQuestionText() {
        System.out.println("getCurrentQuestionText");
        MovieQuestions instance = null;
        String expResult = "";
        String result = instance.getCurrentQuestionText();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentQuestionChoices method, of class MovieQuestions.
     */
    @Test
    public void testGetCurrentQuestionChoices() throws Exception {
        System.out.println("getCurrentQuestionChoices");
        MovieQuestions instance = null;
        String[] expResult = null;
        String[] result = instance.getCurrentQuestionChoices();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumCorrectQuestions method, of class MovieQuestions.
     */
    @Test
    public void testGetNumCorrectQuestions() {
        System.out.println("getNumCorrectQuestions");
        MovieQuestions instance = null;
        int expResult = 0;
        int result = instance.getNumCorrectQuestions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumAttemptedQuestions method, of class MovieQuestions.
     */
    @Test
    public void testGetNumAttemptedQuestions() {
        System.out.println("getNumAttemptedQuestions");
        MovieQuestions instance = null;
        int expResult = 0;
        int result = instance.getNumAttemptedQuestions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of processAnswer method, of class MovieQuestions.
     */
    @Test
    public void testProcessAnswer() throws Exception {
        System.out.println("processAnswer");
        String answer = "";
        MovieQuestions instance = null;
        String expResult = "";
        String result = instance.processAnswer(answer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
