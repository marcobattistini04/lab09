package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private File currentFile;
    private boolean setted = false;
    private static final String PATH = System.getProperty("user.home") + File.separator;

    public void setCurrentFile(File file) {
        this.currentFile = file;
        this.setted = true;
    } 

    public File getCurrentFile() {
        File defensiveCopy = currentFile;
        return defensiveCopy;
    }

    public String getCurrentFileName() {
        if (!setted) {
            return PATH + "output.txt";
        }
        return PATH + this.currentFile.getName();
    }

    public void writeInCurrentFile(String content) {
        try (PrintStream ps = new PrintStream(getCurrentFileName(), StandardCharsets.UTF_8)){
            ps.println(content);
        } catch (IOException e) {
            System.out.println("IO ERROR");
        }
    }

}
