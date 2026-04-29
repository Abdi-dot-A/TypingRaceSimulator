import javax.swing.*;

/*
* This is the GUI window for the typing race program
 */
public class TypingRaceGUI {
    
    final passage PassA = new passage("Short", "the quick brown fox jumps over the lazy dog", 43);
    final passage PassB = new passage("Medium", "the quick brown fox jumped over the lazy dog but was not able to jump higher than the fence", 91);
    final passage PassC = new passage("Long", "the quick brown fox jumped over the lazy dog, but was unable to jump over the fence, so it had to go to the pond instead.", 121);
    public static void main (String [] args){
        startWindow();
    }

    public static void startWindow(){
        JFrame frame = new JFrame("Start Window GUI");
        frame.setSize(500,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        JButton startButton = new JButton("Start Race");
        startButton.setBounds(125,200,220,50);

        frame.add(startButton);
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