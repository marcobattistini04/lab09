package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;

/**
 * Class implementing the Controller interface. 
 */
public final class SimpleController implements Controller {
    private final List<String> list = new ArrayList<>();
    private String currentString;
    @Override
    public void setNextString(final String str) {
        if (str == null) {
            throw new IllegalArgumentException("Cannot pass a null argument");
        }
        this.currentString = str;
    }

    @Override
    public String getNextString() {
        return this.currentString;
    }

    @Override
    public List<String> getPrintedStringHistory() {
        return List.copyOf(this.list);
    }

    @Override
    public void printCurrentString() {
        if (this.currentString == null) {
            throw new IllegalStateException("Cannot print anything beacuse the current string was not setted");
        }
        System.out.println(this.currentString); //NOPMD 
        //in this case, the System.out is specificly requested
        list.addFirst(this.currentString);
    }

}
