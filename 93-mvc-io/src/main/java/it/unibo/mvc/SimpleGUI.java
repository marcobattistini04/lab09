package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.util.List;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contr.setNextString(textField.getText());
                contr.printCurrentString();
            }
        });

        showHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> list = new ArrayList<>();
                list = contr.getPrintedStringHistory();
                for(String str: list) {
                    textArea.append(str + "\n");
                }
            }
        });

        mainPanel.add(textField, BorderLayout.NORTH);
        mainPanel.add(textArea, BorderLayout.CENTER);
        mainPanel.add(print, BorderLayout.SOUTH);
        mainPanel.add(showHistory, BorderLayout.SOUTH);

        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Launches the application.
     * @param args
     */
    public static void main(final String[] args) {
        
    }

}
