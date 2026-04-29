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
    }   
}
