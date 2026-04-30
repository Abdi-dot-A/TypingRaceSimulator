import javax.swing.*;
import java.awt.event.*;

/*
* This is the GUI window for the typing race program
 */
public class TypingRaceGUI {

    
    final static passage PassA = new passage("Short", "the quick brown fox jumps over the lazy dog", 43);
    final static passage PassB = new passage("Medium", "the quick brown fox jumped over the lazy dog but was not able to jump higher than the fence", 91);
    final static passage PassC = new passage("Long", "the quick brown fox jumped over the lazy dog, but was unable to jump over the fence, so it had to go to the pond instead.", 121);
    final passage [] passages = {PassA, PassB, PassC};
    public static void main (String [] args){
        startWindow();
    }

    public static void startWindow(){
        JFrame sWindow = new JFrame("Start Window GUI");
        sWindow.setSize(500,300);
        sWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sWindow.setLocationRelativeTo(null);
        sWindow.setLayout(null);

        JLabel passageLabel = new JLabel("Select a passage length");
        passageLabel.setBounds(50, 50, 150, 30);

        JComboBox passageSelection = new JComboBox<>();
        passageSelection.addItem("Short");
        passageSelection.addItem("Medium");
        passageSelection.addItem("Long");
        passageSelection.setBounds(200, 50, 200, 30);

        JLabel seatLabel = new JLabel("Number of typists (2-6)");
        seatLabel.setBounds(50, 100, 150, 30);

        JComboBox seatCount = new JComboBox<>();
        seatCount.addItem("2");
        seatCount.addItem("3");
        seatCount.addItem("4");
        seatCount.addItem("5");
        seatCount.addItem("6");
        seatCount.setBounds(200, 100, 200, 30);
        seatCount.setSelectedItem("2");

        JButton startButton = new JButton("Start Race");
        startButton.setBounds(125, 200, 220, 50);
        startButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String passageType = (String)passageSelection.getSelectedItem();
                int numTypists = Integer.parseInt((String)seatCount.getSelectedItem());
                raceWindow(passageType, numTypists);
                sWindow.setVisible(false);
            }
        });

        sWindow.add(passageLabel);
        sWindow.add(passageSelection);
        sWindow.add(seatLabel);
        sWindow.add(seatCount);
        sWindow.add(startButton);

        sWindow.setVisible(true);
    }
    
    public static void raceWindow(String passLength, int numTypists){
        JFrame rWindow = new JFrame("Race Window GUI");
        rWindow.setSize(500,300);
        rWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rWindow.setLocationRelativeTo(null);
        rWindow.setLayout(null);

        passage passageSelected;

        if (passLength.equals("Short")){
            passageSelected = PassA;
        }
        else if (passLength.equals("Medium")){
            passageSelected = PassB;
        }
        else{
            passageSelected = PassC;
        }

        rWindow.setVisible(true);
    }
}