/*
 * Author:     John Andrew S Duvall
 * Date:       (Insert date here)
 * Project:    (Insert project here)
 */

package edu.ncsu.csc216.movie101.question;
import java.util.List;

import edu.ncsu.csc216.movie101.util.EmptyQuestionListException;
import edu.ncsu.csc216.question_library.Question;

public abstract class QuestionState<T> extends Question{
	
	private static final int FRONT = 0;
	
	private T currentQuestion;
	private List<T> questions;
	
	public QuestionState(List<T> questions) throws EmptyQuestionListException {
		this.questions = questions;
		currentQuestion = questions.get(FRONT);
		
	}
    
	public abstract String processAnswer(String ans) throws EmptyQuestionListException;
	
	public boolean hasMoreQuestions() {
		if(questions.iterator().hasNext() == true) {
			return true;
		} else {
			return false;
		}
	}
	
	public String getCurrentQuestionText() throws EmptyQuestionListException {
		return getCurrentQuestion().toString();
	}
	
	
	public String[] getCurrentQuestionChoices() throws EmptyQuestionListException {
		String[] questionChoices = new String[4];
		questionChoices[FRONT] = ((Question) getCurrentQuestion()).getChoiceA();
		questionChoices[1] = ((Question) getCurrentQuestion()).getChoiceB();
		questionChoices[2] = ((Question) getCurrentQuestion()).getChoiceC();
		questionChoices[3] = ((Question) getCurrentQuestion()).getChoiceD();
		
		return questionChoices;
	}
	
	public String getCurrentQuestionAnswer() throws EmptyQuestionListException {
		
		return ((Question) getCurrentQuestion()).getAnswer();
	}
	
	public T getCurrentQuestion() throws EmptyQuestionListException {
		
		return currentQuestion;
	}
	
	public void nextQuestion() {
		questions.iterator().next();
	}
	
	
}
