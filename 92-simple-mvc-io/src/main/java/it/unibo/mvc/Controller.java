package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public final class Controller {
    private File currentFile;
    private boolean setted = false;
    private static final String PATH = System.getProperty("user.home") + File.separator;

    /**
     * Set the current file.
     * @param file
     */
    public void setCurrentFile(final File file) {
        this.currentFile = file;
        this.setted = true;
    } 

    /**
     * @return the current file
     */
    public File getCurrentFile() {
        return this.currentFile;
    }

    /**
     * get the current file name. If the current name is never setted returns "output.txt".
     * @return current file name
     */ 
    public String getCurrentFileName() {
        if (!setted) {
            return PATH + "output.txt";
        }
        return PATH + this.currentFile.getName();
    }

    /**
     * write the string content in the current file.
     * @param content
     */
    public void writeInCurrentFile(final String content) {
        try (PrintStream ps = new PrintStream(getCurrentFileName(), StandardCharsets.UTF_8)) {
            ps.println(content);
        } catch (IOException e) {
            System.out.println("IO ERROR");
        }
    }

}
