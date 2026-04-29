import javax.swing.*;

/*
* This is the GUI window for the typing race program
 */
public class TypingRaceGUI {
    
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