/*
 * Author:     John Andrew S Duvall
 * Date:       (Insert date here)
 * Project:    (Insert project here)
 */

package edu.ncsu.csc216.movie101.question;

import edu.ncsu.csc216.movie101.util.EmptyQuestionListException;
import edu.ncsu.csc216.question_library.*;

import java.util.List;

public class MovieQuestions {
	private StandardQuestionState stdState;
	private AdvancedQuestionState advState;
	private ElementaryQuestionState elemState;
	private QuestionState state;
    private int numCorrectAnswers;
    private int numAttemptQuestions;
    public static final String CORRECT = "Correct!";
    public static final String INCORRECT = "Incorrect";
    public static final String SEPERATOR = " ";
    public MovieQuestions(List<StandardQuestion> stdQues,List<ElementaryQuestion> elemQues,List<AdvancedQuestion> advQues) {
    	
    }
    public boolean hasMoreQuestions() {
        if(state.hasMoreQuestions() == true) {
        	return true;
        } else {
        	return false;
        }
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
    public int getNumAttemptedQuestions() {
    	return numAttemptQuestions;
    }
    
    public String processAnswer(String ans) throws EmptyQuestionListException {
    	return state.processAnswer(ans);
		
		
    	
    	
    }

    public class AdvancedQuestionState extends QuestionState {
    	private List<AdvancedQuestion> advQuestions;
		public AdvancedQuestionState(List<Question> questions, List<AdvancedQuestion> advQuestions) {
			super(questions);
			this.advQuestions = advQuestions;
		}

		
		public String processAnswer(String ans) throws EmptyQuestionListException {
			if(ans == advState.getCurrentQuestionAnswer()){
				numCorrectAnswers++;
				return CORRECT;
			} else {
				numAttemptQuestions++;
				state = stdState;
				return INCORRECT;
			}
		}
    
    }
    public class StandardQuestionState extends QuestionState {
    	private int numCorrectInARow;
    	private List<StandardQuestion> stdQuestions;
		public StandardQuestionState(List<Question> questions, List<StandardQuestion> stdQuestions) {
			super(questions);
			this.stdQuestions = stdQuestions;
		}

		
		public String processAnswer(String ans) throws EmptyQuestionListException {
			if(ans == stdState.getCurrentQuestionAnswer()) {
				numCorrectInARow ++;
				numCorrectAnswers++;
				if(numCorrectInARow == 2) {
					state = advState;
					numCorrectInARow = 0;
				}
				return CORRECT;
			} else {
				numAttemptQuestions++;
				numCorrectInARow = 0;
				state = elemState;
				return INCORRECT;
			}
			
		}
    
    }
    public class ElementaryQuestionState extends QuestionState {
    	private int attempts;
    	private int numCorrectInARow;
    	private List<ElementaryQuestion> elemQuestions;
    	public ElementaryQuestionState(List<Question> questions, List<ElementaryQuestion> elemQuestions) {
			super(questions);
			this.elemQuestions = elemQuestions;
		}

		
		public String processAnswer(String ans) throws EmptyQuestionListException {
			if(ans != elemState.getCurrentQuestionAnswer()) {
				attempts++;
				numCorrectInARow = 0;
				numAttemptQuestions++;
				return INCORRECT;
			} else {
				numCorrectAnswers++;
				numCorrectInARow++;
				if(numCorrectInARow == 2) {
					state = stdState;
					numCorrectInARow = 0;
				}
				return CORRECT;
				
			}
		}
    
    }	
}
