package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public final class Controller {
    private static final String PATH = System.getProperty("user.home") + File.separator;
    private File currentFile = new File(PATH + "output.txt");

    /**
     * Set the current file.
     * @param file
     */
    public void setCurrentFile(final File file) {
        this.currentFile = file;
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
        return PATH + this.currentFile.getName();
    }

    /**
     * write the string content in the current file.
     * @param content
     */
    public void writeInCurrentFile(final String content) throws IOException {
        try (PrintStream ps = new PrintStream(getCurrentFileName(), StandardCharsets.UTF_8)) {
            ps.println(content);
        }
    }

}
