import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame{
    GUI(){
        // set up the frame default constraint 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(5,2,10,10));
        this.setPreferredSize(new Dimension(800,800));

        this.add(new JLabel("Reading FIle Name"));
        this.add(new JLabel("File name to write"));
        this.add(new JLabel("Annual.csv"));
        this.add(new JTextField("<user input>"));
        this.add(new Button("Click to read from file"));
        this.add(new Button("Click to write to file"));
        this.add(new JLabel("First five lines of file"));
        this.add(new JLabel("First five lines of new file"));
        this.add(new JTextArea());
        this.add(new JTextArea());

        

        this.pack();
        this.setVisible(true);

    }

    public static void main(String[] args){
        new GUI();
    }
}