/*
 * Author:     John Andrew S Duvall
 * Date:       (Insert date here)
 * Project:    (Insert project here)
 */

package edu.ncsu.csc216.movie101.question;
import java.util.list;

public class QuestionState {
	
	private static final int FRONT;
	
	public QuestionState(List<Question> questionList) {
		questionList = new List<Question>();
	}
    
	public abstract String processAnswer(String ans) {
		//todo
		return null
	}
	
	public boolean hasMoreQuestions() {
		if(questionList.hasNext() == true) {
			return true;
		} else {
			return false;
		}
	}
	
	public String getCurrentQuestionText() {
		
	}
	
	public String[] getCurrentQuestionChoices() {
		//todo
		return null
	}
	
	public String getCurrentQuestionAnswer() {
		//todo
		return null
	}
	
	public Question getCurrentQuestion() {
		//todo
		return null
	}
	
	public void nextQuestion() {
		//todo
	}
	
	
}
