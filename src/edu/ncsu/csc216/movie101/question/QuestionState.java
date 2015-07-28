/*
 * Author:     John Andrew S Duvall
 * Date:       (Insert date here)
 * Project:    (Insert project here)
 */

package edu.ncsu.csc216.movie101.question;
import java.util.List;

import edu.ncsu.csc216.movie101.util.EmptyQuestionListException;
import edu.ncsu.csc216.question_library.Question;

public abstract class QuestionState {
	
	private static final int FRONT = 0;
	
	private Question currentQuestion;
	private List<Question> questions;
	
	public QuestionState() {
		
	}
	
	public QuestionState(List<Question> questions) throws EmptyQuestionListException {
		this.questions = questions;
		
		
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
		questionChoices[FRONT] = getCurrentQuestion().getChoiceA();
		questionChoices[1] = getCurrentQuestion().getChoiceB();
		questionChoices[2] = getCurrentQuestion().getChoiceC();
		questionChoices[3] = getCurrentQuestion().getChoiceD();
		
		return questionChoices;
	}
	
	public String getCurrentQuestionAnswer() throws EmptyQuestionListException {
		
		return getCurrentQuestion().getAnswer();
	}
	
	public Question getCurrentQuestion() throws EmptyQuestionListException {
		
		return currentQuestion;
	}
	
	public void nextQuestion() {
		questions.iterator().next();
	}

	public void setCurrentQuestion(Question currentQuestion) {
		this.currentQuestion = currentQuestion;
	}
	
	
}
