/*
 * Author:     John Andrew S Duvall
 * Date:       (Insert date here)
 * Project:    (Insert project here)
 */

package edu.ncsu.csc216.movie101.question;

import edu.ncsu.csc216.question_library.*;
import java.util.LinkedList;
import java.util.List;

public class MovieQuestions {
	/*
	 * This is a test 2
	 */
    private int numCorrectAnswers;
    private int numAttemptQuestions;
    public static final String CORRECT = "Correct";
    public static final String INCORRECT = "Incorrect";
    public static final String SEPERATOR = " ";
    public MovieQuestions(LinkedList<StandardQuestion> stdQues,LinkedList<ElementaryQuestion> elemQues,LinkedList<AdvancedQuestion> advQues) {
        stdQues = new LinkedList<StandardQuestion>();
        elemQues = new LinkedList<ElementaryQuestion>();
        advQues = new LinkedList<AdvancedQuestion>();
    }
    public boolean hasMoreQuestions() {
        return false;
    }
    
    public String getCurrentQuestionText()
    {
        return null;
    }
    public String[] getCurrentQuestionChoices()
    {
        return null;
    }

    public String processAnswer(String answer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getNumCorrectQuestions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getNumAttemptedQuestions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
class AdvancedQuestionState
{
    
}
class StandardQuestionState
{
    
}
class ElementaryQuestionState
{
    
}
