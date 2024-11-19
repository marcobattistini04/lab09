package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final JFrame frame = new JFrame("SimpleGUIWithFileChooser");
    private static final int PROPORTION = 5;

    /**
     * Sets a simple GUI with file chooser. Has two buttons: 
     * -Save: save the current text of the textArea in the selected file by the controller
     * -Browse..: open the file chooser in order to choose the next selected file.
     * The main panel il a border Layout and it contains a secondary Panel, that is always
     * a Border Panel but located in the north section of main panel.
     * @param contr
     */
    public SimpleGUIWithFileChooser(final Controller contr) {
        final JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        final JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        final JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        mainPanel.add(textArea, BorderLayout.CENTER);

        // CPD-OFF
        // suppressed the CPD rule because the button save is designed to be same
        final JButton save = new JButton("Save");
        mainPanel.add(save, BorderLayout.SOUTH);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final int option = JOptionPane.showConfirmDialog(frame, "Do you really want to save?");
                if (option == JOptionPane.YES_OPTION) {
                    try {
                        contr.writeInCurrentFile(textArea.getText());
                    } catch (final IOException e1) {
                        JOptionPane.showMessageDialog(frame, "An error occurred while trying saving the progress in file "
                        + contr.getCurrentFileName());
                    }
                }
            }
        });
        //CPD-ON
        final JPanel upperPanel = new JPanel();
        upperPanel.setLayout(new BorderLayout());
        final JTextField textField = new JTextField();
        textField.setText(contr.getCurrentFileName());
        textField.setEditable(false);
        upperPanel.add(textField, BorderLayout.CENTER);
        final JButton browse = new JButton("Browse..");
        upperPanel.add(browse, BorderLayout.AFTER_LINE_ENDS);
        browse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final JFileChooser fileChooser = new JFileChooser();
                final int option = fileChooser.showOpenDialog(browse.getParent());
                if (option == JFileChooser.APPROVE_OPTION) {
                    final File file = fileChooser.getSelectedFile();
                    contr.setCurrentFile(file);
                    textField.setEditable(true);
                    textField.setText(contr.getCurrentFileName());
                    textField.setEditable(false);
                }
            }
        });
        mainPanel.add(upperPanel, BorderLayout.NORTH);
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent e) {
                final int n = JOptionPane.showConfirmDialog(frame, "Do you really want to quit?");
                if (n == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }
    /**
     * sets the visual aspects of the GUI with the file chooser(ex the correct dimensions compared to the screen).
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
        new SimpleGUIWithFileChooser(new Controller()).display();
    }
}
