package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.List;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame();

    /**
     * Sets the structure of all the application, in this case:
     * TextField, TextArea and 2 Buttons.
     * @param contr the designed controller
     */
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

        JPanel flowPanel = new JPanel();
        flowPanel.setLayout(new FlowLayout());
        flowPanel.add(print);
        flowPanel.add(showHistory);

        mainPanel.add(textField, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(flowPanel, BorderLayout.SOUTH);

        this.frame.setContentPane(mainPanel);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Manages the visual aspect of the application
     */
    public void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        this.frame.setSize(sw/PROPORTION, sh/PROPORTION);
        this.frame.setLocationByPlatform(true);
        this.frame.setVisible(true);
    }
    /**
     * Launches the application.
     * @param args
     */
    public static void main(final String[] args) {
        new SimpleGUI(new SimpleController()).display();
    }

}
