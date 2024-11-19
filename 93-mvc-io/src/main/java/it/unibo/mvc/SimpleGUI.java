package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();
    public SimpleGUI(final Controller contr) {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        JTextField textField = new JTextField();
        textField.setEditable(true);
        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        JButton print = new JButton("Print");
        JButton showHistory = new JButton("Show History");

        mainPanel.add(textField, BorderLayout.NORTH);
        mainPanel.add(textArea, BorderLayout.CENTER);
        mainPanel.add(print, BorderLayout.SOUTH);
        mainPanel.add(showHistory, BorderLayout.SOUTH);

        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent e) {
                final int n = JOptionPane.showConfirmDialog(frame, "Do you really want to quit?", "Quitting..", JOptionPane.YES_NO_OPTION);
                if(n == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }



    /**
     * Launches the application.
     * @param args
     */
    public static void main(final String[] args) {
        
    }

}
