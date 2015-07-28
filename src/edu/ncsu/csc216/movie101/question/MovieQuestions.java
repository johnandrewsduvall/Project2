/*
 * Author:     John Andrew S Duvall
 * Date:       (Insert date here)
 * Project:    (Insert project here).
 */

package edu.ncsu.csc216.movie101.question;

import edu.ncsu.csc216.movie101.util.EmptyQuestionListException;
import edu.ncsu.csc216.question_library.*;

import java.util.ArrayList;
import java.util.List;

public class MovieQuestions {
	private QuestionState stdState;
	private QuestionState advState;
	private QuestionState elemState;
	private QuestionState state;
    private int numCorrectAnswers;
    private int numAttemptQuestions;
    public static final String CORRECT = "Correct!";
    public static final String INCORRECT = "Incorrect";
    public static final String SEPERATOR = " ";
    public MovieQuestions(List<StandardQuestion> stdQues,List<ElementaryQuestion> elemQues,List<AdvancedQuestion> advQues) {
    	try {
			stdState = new StandardQuestionState(stdQues);
			elemState = new ElementaryQuestionState(elemQues);
    		advState = new AdvancedQuestionState(advQues);
    		state = stdState;
    		state.setCurrentQuestion(stdQues.get(0));
    	} catch (EmptyQuestionListException e) {
 			e.printStackTrace();
 		}
    	
    	
		
    }
    public boolean hasMoreQuestions() {
        return state.hasMoreQuestions();
    }
    public String getCurrentQuestionText() {
        try {
			return state.getCurrentQuestionText();
		} catch (EmptyQuestionListException e) {
			return null;
		}
    }
    public String[] getCurrentQuestionChoices() {
        try {
			return state.getCurrentQuestionChoices();
		} catch (EmptyQuestionListException e) {
			return null;
		}
    }
    public int getNumCorrectQuestions() {
    	return numCorrectAnswers;
    }
    public void incrementNumCorrectQuestions() {
    	numCorrectAnswers++;
    }
    public int getNumAttemptedQuestions() {
    	return numAttemptQuestions;
    }
    public void incrementNumAttemptedQuestions() {
    	numAttemptQuestions++;
    }
    public String processAnswer(String ans) throws EmptyQuestionListException {
    	return state.processAnswer(ans);
		
		
    	
    	
    }

	public class AdvancedQuestionState extends QuestionState {
		public AdvancedQuestionState(List<AdvancedQuestion> advQuestions) throws EmptyQuestionListException {
			super(new ArrayList<Question>(advQuestions));
			
		}

		
		public String processAnswer(String ans) throws EmptyQuestionListException {
			incrementNumAttemptedQuestions();
			if(ans.equals(state.getCurrentQuestionAnswer())){				
				incrementNumCorrectQuestions();
				state.nextQuestion();
				return CORRECT;
			} else {
				state = stdState;
				state.nextQuestion();
				return INCORRECT;
			}
		}
    
    }
	public class StandardQuestionState extends QuestionState {
    	private int numCorrectInARow;
		public StandardQuestionState(List<StandardQuestion> stdQuestions) throws EmptyQuestionListException {
			super(new ArrayList<Question>(stdQuestions));
			
		}

		
		public String processAnswer(String ans) throws EmptyQuestionListException {
			incrementNumAttemptedQuestions();
			if(ans.equals(state.getCurrentQuestionAnswer())) {
				numCorrectInARow++;
				incrementNumCorrectQuestions();
				if(numCorrectInARow == 2) {
					state = advState;
					numCorrectInARow = 0;
					state.nextQuestion();
				} else {
					state.nextQuestion();
				}
				return CORRECT;
			} else {
				numCorrectInARow = 0;
				state = elemState;
				state.nextQuestion();
				return INCORRECT;
			}
			
		}
    
    }
	public class ElementaryQuestionState extends QuestionState {
    	private int attempts;
    	private int numCorrectInARow;
    	private int numElemQuesAttempted = 0;
    	public ElementaryQuestionState(List<ElementaryQuestion> elemQuestions) throws EmptyQuestionListException {
			super(new ArrayList<Question>(elemQuestions));
			
		}

		
		public String processAnswer(String ans) throws EmptyQuestionListException {
			incrementNumAttemptedQuestions();
			if(!ans.equals(state.getCurrentQuestionAnswer())) {
				attempts++;
				numCorrectInARow = 0;
				
				if(attempts == 2) {
					state.nextQuestion();
					numElemQuesAttempted++;
					attempts = 0;
				}
				return INCORRECT;
			} else {
				numElemQuesAttempted++;
				incrementNumCorrectQuestions();
				numCorrectInARow++;
				if(numCorrectInARow == 2) {
					state = stdState;
					numCorrectInARow = 0;
				}
				state.nextQuestion();
				return CORRECT;
				
			}
		}
    
    }	
}
