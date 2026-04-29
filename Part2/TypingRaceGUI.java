import javax.swing.*;

/*
* This is the GUI window for the typing race program
 */
public class TypingRaceGUI {
    
    final passage PassA = new passage("Short", "the quick brown fox jumps over the lazy dog", 43);
    final passage PassB = new passage("Medium", "the quick brown fox jumped over the lazy dog but was not able to jump higher than the fence", 91);
    final passage PassC = new passage("Long", "the quick brown fox jumped over the lazy dog, but was unable to jump over the fence, so it had to go to the pond instead.", 121);
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

        JButton startButton = new JButton("Start Race");
        startButton.setBounds(125,200,220,50);

        JComboBox passageSelection = new JComboBox<>();
        passageSelection.addItem("Short");
        passageSelection.addItem("Medium");
        passageSelection.addItem("Long");
        passageSelection.addItem("Custom");
        passageSelection.setBounds(200, 50, 200, 30);

        JLabel passageLabel = new JLabel("Select a passage length");
        passageLabel.setBounds(50,50, 150, 30);

        sWindow.add(startButton);
        sWindow.add(passageSelection);
        sWindow.add(passageLabel);

        sWindow.setVisible(true);
    }
    
    public static void raceWindow(){

    }
}

/*
* This is the class for each passage object
*/
public class passage{
    String classification;
    String passageWords;
    int charLength;

    public passage (String classify, String passWords, int charlen){
        this.classification = classify;
        this.passageWords = passWords;
        this.charLength = charlen;
    }
}