/*
 * Author:     John Andrew S Duvall
 * Date:       (Insert date here)
 * Project:    (Insert project here)
 */

package edu.ncsu.csc216.movie101.question;
import java.util.List;
import java.util.list;

import src.edu.ncsu.csc216.movie101.util.EmptyQuestionListException;
import edu.ncsu.csc216.question_library.Question;

public abstract class QuestionState {
	
	private static final int FRONT = 0;
	
	private Question currentQuestion;
	private List<Question> questions;
	public QuestionState(List<Question> questions) {
		this.questions = questions;
	}
    
	public abstract String processAnswer(String ans);
	
	public boolean hasMoreQuestions() {
		if(questions.iterator().hasNext() == true) {
			return true;
		} else {
			return false;
		}
	}
	
	public String getCurrentQuestionText() throws EmptyQuestionListException {
		return currentQuestion.toString();
	}
	
	
	public String[] getCurrentQuestionChoices() throws EmptyQuestionListException {
		String[] questionChoices = new String[4];
		questionChoices[0] = currentQuestion.getChoiceA();
		questionChoices[1] = currentQuestion.getChoiceB();
		questionChoices[2] = currentQuestion.getChoiceC();
		questionChoices[3] = currentQuestion.getChoiceD();
		
		return questionChoices;
	}
	
	public String getCurrentQuestionAnswer() throws EmptyQuestionListException {
		
		return currentQuestion.getAnswer();
	}
	
	public Question getCurrentQuestion() throws EmptyQuestionListException {
		
		return currentQuestion;
	}
	
	public void nextQuestion() {
		questions.iterator().next();
	}
	
	
}
