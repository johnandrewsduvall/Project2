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
    public String[] getCurrentQuestionChoices() throws EmptyQuestionListException {
        try {
			return state.getCurrentQuestionChoices();
		} catch (EmptyQuestionListException e) {
                    throw e;
		}
    }
    public int getNumCorrectQuestions() {
    	return numCorrectAnswers;
    }
    public int getNumAttemptedQuestions() {
    	return numAttemptQuestions;
    }
    
    public String processAnswer(String answer) throws EmptyQuestionListException
    {
        return state.processAnswer(answer);
        
    }
    

    public class AdvancedQuestionState extends QuestionState {
    	private List<AdvancedQuestion> advQuestions;
		public AdvancedQuestionState(List<Question> questions, List<AdvancedQuestion> advQuestions) {
			super(questions);
			this.advQuestions = advQuestions;
		}

		
            @Override
		public String processAnswer(String ans) throws EmptyQuestionListException {
			if(ans == advState.getCurrentQuestionAnswer()){
				numCorrectAnswers++;
				return CORRECT;
			} else {
				numAttemptQuestions++;
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

		
            @Override
		public String processAnswer(String ans) throws EmptyQuestionListException {
			if(ans == stdState.getCurrentQuestionAnswer()) {
				numCorrectInARow ++;
				numCorrectAnswers++;
				return CORRECT;
			} else {
				numAttemptQuestions++;
				numCorrectInARow = 0;
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

		
            @Override
		public String processAnswer(String ans) throws EmptyQuestionListException {
			if(ans != elemState.getCurrentQuestionAnswer()) {
				numCorrectInARow = 0;
				numAttemptQuestions++;
				attempts++;
				return INCORRECT;
			} else {
				numCorrectAnswers++;
				numCorrectInARow++;
				return CORRECT;
			}
		}
    
    }	
}
