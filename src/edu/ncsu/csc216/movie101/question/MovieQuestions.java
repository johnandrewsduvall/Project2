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
    	stdState = new StandardQuestionState(stdQues);
    	elemState = new ElementaryQuestionState(elemQues);
    	advState = new AdvancedQuestionState(advQues);
    	state = stdState;
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
    public int getNumAttemptedQuestions() {
    	return numAttemptQuestions;
    }
    
    public String processAnswer(String ans) throws EmptyQuestionListException {
    	return state.processAnswer(ans);
		
		
    	
    	
    }

    public class AdvancedQuestionState extends QuestionState {
    	private List<AdvancedQuestion> advQuestions;
		public AdvancedQuestionState(List<AdvancedQuestion> advQuestions) {
			this.advQuestions = advQuestions;
			
		}

		
		public String processAnswer(String ans) throws EmptyQuestionListException {
			numAttemptQuestions++;
			if(ans == state.getCurrentQuestionAnswer()){				
				numCorrectAnswers++;
				state.nextQuestion();
				return CORRECT;
			} else {
				state = stdState;
				return INCORRECT;
			}
		}
    
    }
    public class StandardQuestionState extends QuestionState {
    	private int numCorrectInARow;
    	private List<StandardQuestion> stdQuestions;
		public StandardQuestionState(List<StandardQuestion> stdQuestions) {
			this.stdQuestions = stdQuestions;
			
			setCurrentQuestion(stdQuestions.get(0));
			
			
		}

		
		public String processAnswer(String ans) throws EmptyQuestionListException {
			numAttemptQuestions++;
			if(ans == state.getCurrentQuestionAnswer()) {
				numCorrectInARow++;
				numCorrectAnswers++;
				if(numCorrectInARow == 2) {
					state = advState;
					numCorrectInARow = 0;
				}
				state.nextQuestion();
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
    	private List<ElementaryQuestion> elemQuestions;
    	public ElementaryQuestionState(List<ElementaryQuestion> elemQuestions) {
			
			this.elemQuestions = elemQuestions;
			
		}

		
		public String processAnswer(String ans) throws EmptyQuestionListException {
			if(ans != state.getCurrentQuestionAnswer()) {
				attempts++;
				numCorrectInARow = 0;
				elemQuestions.get(numElemQuesAttempted).getHint();
				if(attempts == 2) {
					numAttemptQuestions++;
					state.nextQuestion();
					numElemQuesAttempted++;
				}
				return INCORRECT;
			} else {
				numElemQuesAttempted++;
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
