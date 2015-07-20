/*
 * Author:     John Andrew S Duvall
 * Date:       (Insert date here)
 * Project:    (Insert project here)
 */

package edu.ncsu.csc216.movie101.question;

import edu.ncsu.csc216.question_library.*;
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
    public MovieQuestions(List<StandardQuestion> stdQues,List<ElementaryQuestion> elemQues,List<AdvancedQuestion> advQues) {
        stdQues = new List<StandardQuestion>();
        elemQues = new List<ElementarQuestion>();
        advQues = new List<AdvancedQuestion>();
    }
    public boolean hasMoreQuestions() {
        if()
    }
    public String getCurrentQuestionText()
    {
        return null;
    }
    public String[] getCurrentQuestionChoices()
    {
        return null;
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
