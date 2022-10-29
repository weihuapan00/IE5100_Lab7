import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

import javax.swing.*;

public class GUI extends JFrame{
    // use fileOpener obj
    private fileOpener f;
    GUI(){
        // set up the frame default constraint 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set the GridLayout to Jframe
        this.setLayout(new GridLayout(5,2,10,10));
        this.setPreferredSize(new Dimension(800,800));

        // and two Jlabel to frame
        this.add(new JLabel("Reading FIle Name"));
        this.add(new JLabel("File name to write"));

        // create and add textfield for input and output file
        JTextField tf1 = new JTextField("annual.csv");
        this.add(tf1);
        JTextField tf2 = new JTextField("<user input>");
        this.add(tf2);

        // add two button for read and write operation
        JButton b1 = new JButton("Click to read from file");
        JButton b2 = new JButton("Click to write to file");
        this.add(b1);
        this.add(b2);

        // add two labels
        this.add(new JLabel("First five lines of file"));
        this.add(new JLabel("First five lines of new file"));

        // create two textarea , first one with horizontal_scrollbar
        var ta1 = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(ta1);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.add(scrollPane);
        var ta2 = new JTextArea();
        this.add(ta2);

        // add actionlistener for read button
        b1.addActionListener(e -> {
            ta1.setText("");
            String filename = tf1.getText();
            f = new fileOpener(filename);
            f.readFile();
            LinkedList<String> list = f.getStr_list();
            for (int i=0; i<5; i++){
                ta1.append(list.get(i)+ "\n");
            }
        });

        // add actionlistener for write button
        b2.addActionListener(e -> {
            ta2.setText("");
            String filename = tf2.getText(); // get the filename from textfield
            f.writeFile(filename);
            f = new fileOpener(filename);
            f.readFile();
            LinkedList<String> list = f.getStr_list(); 
            for (int i=0; i<5; i++){
                ta2.append(list.get(i)+ "\n");
            }
        });

        // make the Jframe visitable
        this.pack();
        this.setVisible(true);

    }

    public static void main(String[] args){
        // start the GUI program
        new GUI();
    
    }
}