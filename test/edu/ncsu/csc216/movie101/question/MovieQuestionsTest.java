package edu.ncsu.csc216.movie101.question;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc216.question_library.AdvancedQuestion;
import edu.ncsu.csc216.question_library.ElementaryQuestion;
import edu.ncsu.csc216.question_library.StandardQuestion;
import junit.framework.TestCase;

public class MovieQuestionsTest extends TestCase {
	private List<ElementaryQuestion> elemQues;
	private List<StandardQuestion> stdQues;
	private List<AdvancedQuestion> advQues ;
	private ElementaryQuestion elemQues1;
	private ElementaryQuestion elemQues2;
	private StandardQuestion stdQues1;
	private StandardQuestion stdQues2;
	private AdvancedQuestion advQues1;
	private AdvancedQuestion advQues2;
	private MovieQuestions mq;
	@Before
	public void setUp() throws Exception {
		elemQues = new ArrayList<ElementaryQuestion>();
		stdQues = new ArrayList<StandardQuestion>();
		advQues = new ArrayList<AdvancedQuestion>();
		elemQues1 = new ElementaryQuestion();
		elemQues2 = new ElementaryQuestion();
		elemQues1.setAnswer("d");
		elemQues1.setChoiceA("Choice a");
		elemQues1.setChoiceB("Choice b");
		elemQues1.setChoiceC("Choice c");
		elemQues1.setChoiceD("Choice d");
		elemQues1.setQuestion("Elementary Question 1");
		elemQues2.setAnswer("c");
		elemQues2.setChoiceA("Choice a");
		elemQues2.setChoiceB("Choice b");
		elemQues2.setChoiceC("Choice c");
		elemQues2.setChoiceD("Choice d");
		elemQues2.setQuestion("Elementary Question 2");
		elemQues.add(0, elemQues1);
		elemQues.add(1, elemQues2);
		stdQues1 = new StandardQuestion();
		stdQues2 = new StandardQuestion();
		stdQues1.setAnswer("a");
		stdQues1.setChoiceA("Choice a");
		stdQues1.setChoiceB("Choice b");
		stdQues1.setChoiceC("Choice c");
		stdQues1.setChoiceD("Choice d");
		stdQues1.setQuestion("Standard Question 1");
		stdQues2.setAnswer("b");
		stdQues2.setChoiceA("Choice a");
		stdQues2.setChoiceB("Choice b");
		stdQues2.setChoiceC("Choice c");
		stdQues2.setChoiceD("Choice d");
		stdQues2.setQuestion("Standard Question 2");
		stdQues.add(0, stdQues1);
		stdQues.add(1, stdQues2);
		advQues1 = new AdvancedQuestion();
		advQues2 = new AdvancedQuestion();
		advQues1.setAnswer("b");
		advQues1.setChoiceA("Choice a");
		advQues1.setChoiceB("Choice b");
		advQues1.setChoiceC("Choice c");
		advQues1.setChoiceD("Choice d");
		advQues1.setQuestion("Standard Question 1");
		advQues2.setAnswer("d");
		advQues2.setChoiceA("Choice a");
		advQues2.setChoiceB("Choice b");
		advQues2.setChoiceC("Choice c");
		advQues2.setChoiceD("Choice d");
		advQues2.setQuestion("Standard Question 2");
		advQues.add(0, advQues1);
		advQues.add(1, advQues2);
		mq = new MovieQuestions(stdQues, elemQues, advQues);
	}


	 /**
     * Test of hasMoreQuestions method, of class MovieQuestions.
     */
    @Test
    public void testHasMoreQuestions() {
    	assertTrue(mq.hasMoreQuestions());
    	
    	
    	
    }
    
    /**
     * Test of getCurrentQuestionText method, of class MovieQuestions.
     */
    @Test
    public void testGetCurrentQuestionText() {
    	assertEquals("Standard Question 1", mq.getCurrentQuestionText());
    }
    
    /**
     * Test of getCurrentQuestionChoices method, of class MovieQuestions.
     */
    @Test
    public void testGetCurrentQuestionChoices() throws Exception {
    	String[] questionChoice = new String[4];
    	questionChoice[0] = "Choice a";
    	questionChoice[1] = "Choice b";
    	questionChoice[2] = "Choice c";
    	questionChoice[3] = "Choice d";
    
    	String[] realChoice;
    	realChoice = mq.getCurrentQuestionChoices();
    	String expected;
    	String actual;
    	
    	expected = questionChoice.toString();
    	actual = realChoice.toString();
    	
    	assertEquals(expected, actual);
    }
    
    /**
     * Test of getNumCorrectQuestions method, of class MovieQuestions.
     *

    public void testGetNumCorrectQuestions() {
    	
    }
    
    /**
     * Test of getNumAttemptedQuestions method, of class MovieQuestions.
     *

    public void testGetNumAttemptedQuestions() {
    	
    }
    
    /**
     * Test of processAnswer method, of class MovieQuestions.
     *

    public void testProcessAnswer() throws Exception {
    	
    }
    
    
    */
    
    
    
    
    
    

}

