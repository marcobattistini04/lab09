package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {
    private static final  int PROPORTION = 5;
    private final JFrame frame = new JFrame("SimpleGUI");

    /**
     * Create a simple GUI with a Border Layout and a "Save" button, 
     * in order to write the content of the textArea in the selected file.
     * @param contr  the designed controller
     */
    public SimpleGUI(final Controller contr) {
        final JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        final JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        final JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        mainPanel.add(textArea, BorderLayout.CENTER);

        final JButton save = new JButton("Save");
        mainPanel.add(save, BorderLayout.SOUTH);

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(frame, "Do you really want to save?");
                if (option == JOptionPane.YES_OPTION) {
                    contr.writeInCurrentFile(textArea.getText());
                }
            }
        });

        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * sets the visual aspects of the simple GUI (ex the correct dimensions).
     */
    public void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        /*
         * Instead of appearing at (0,0), upper left corner of the screen, this
         * flag makes the OS window manager take care of the default positioning
         * on screen. Results may vary, but it is generally the best choice.
         */
        frame.setLocationByPlatform(true);
        /*
         * OK, ready to push the frame onscreen
         */
        frame.setVisible(true);
    }
    /**
     * Launches the application.
     * @param args
     */
    public static void main(final String[] args) {
        new SimpleGUI(new Controller()).display();
    }
}
