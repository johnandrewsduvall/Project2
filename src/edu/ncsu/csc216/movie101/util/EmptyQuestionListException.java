/*
 * Author:     John Andrew S Duvall
 * Date:       date
 * Project:    project
 */
package edu.ncsu.csc216.movie101.util;

public class EmptyQuestionListException extends Exception{
    private final String MESSAGE;
    private final long serialVersionUID;
    public EmptyQuestionListException()
            {
                MESSAGE = "Something went wrong with the questions!";
                serialVersionUID = 0L;
            }
    public EmptyQuestionListException(String message)
            {
                MESSAGE = message;
                serialVersionUID = 0L;
            }

    /**
     *
     * @return error message
     */
    @Override
    public String getMessage()
    {
        return MESSAGE;
    }
}
