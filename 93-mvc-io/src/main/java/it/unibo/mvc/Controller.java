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
    void setNextString(String str);

    /**
     * @return the next string to be printed
     */
    String getNextString();

    /**
     * @return a copy of the list of all printed strings
     */
    List<String> getPrintedStringHistory();

    /**
     * Prints the current string.
     * @throws IllegalStateException if it is not setted any current string
     */
    void printCurrentString();

}
