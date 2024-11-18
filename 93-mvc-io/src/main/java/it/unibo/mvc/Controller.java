package it.unibo.mvc;

import java.util.List;

/**
 * A simple controller that manage I/O access 
 * and it is able to print on the standard output.
 */
public interface Controller {
    /**
     * Sets the next string to be printed.
     * @param str the next string to be printed
     * @throws IllegalArgumentException if the string passed is null
     */
    public void setNextString(final String str);

    /**
     * @return the next string to be printed
     */
    public String getNextString();

    /**
     * @return the list of all printed strings
     */
    public List<String> getPrintedStringHistory();

    /**
     * Prints the current string.
     * @throws IllegalStateException if it is not setted any current string
     */
    public void printCurrentString();

}
