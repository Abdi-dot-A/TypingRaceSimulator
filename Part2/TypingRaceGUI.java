import java.awt.event.*;
import javax.swing.*;

/*
* This is the GUI window for the typing race program
 */
public class TypingRaceGUI {

    
    final static passage PassA = new passage("Short", "the quick brown fox jumps over the lazy dog", 43);
    final static passage PassB = new passage("Medium", "the quick brown fox jumped over the lazy dog but was not able to jump higher than the fence", 91);
    final static passage PassC = new passage("Long", "the quick brown fox jumped over the lazy dog, but was unable to jump over the fence, so it had to go to the pond instead.", 121);
    public static void main (String [] args){
        startWindow();
    }

    public static void startWindow(){
        JFrame sWindow = new JFrame("Start Window GUI");
        sWindow.setSize(500,400);
        sWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sWindow.setLocationRelativeTo(null);
        sWindow.setLayout(null);

        JLabel passageLabel = new JLabel("Select a passage length");
        passageLabel.setBounds(50, 50, 150, 30);

        JComboBox<String> passageSelection = new JComboBox<String>();
        passageSelection.addItem("Short");
        passageSelection.addItem("Medium");
        passageSelection.addItem("Long");
        passageSelection.setBounds(200, 50, 200, 30);

        JLabel seatLabel = new JLabel("Number of typists (2-6)");
        seatLabel.setBounds(50, 100, 150, 30);

        JComboBox<String> seatCount = new JComboBox<String>();
        seatCount.addItem("2");
        seatCount.addItem("3");
        seatCount.addItem("4");
        seatCount.addItem("5");
        seatCount.addItem("6");
        seatCount.setBounds(200, 100, 200, 30);
        seatCount.setSelectedItem("2");

        JCheckBox autocorrect = new JCheckBox("Autocorrect Off/On");
        autocorrect.setBounds(50, 150, 150, 30);

        JCheckBox caffeine = new JCheckBox("Caffeine Mode");
        caffeine.setBounds(50, 190, 150, 30);

        JCheckBox nightShift = new JCheckBox("Night Shift");
        nightShift.setBounds(50, 230, 150, 30);

        JButton startButton = new JButton("Next");
        startButton.setBounds(125, 300, 220, 50);
        startButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String passageType = (String)passageSelection.getSelectedItem();
                int numTypists = Integer.parseInt((String)seatCount.getSelectedItem());
                boolean autocorrectOn = autocorrect.isSelected();
                boolean caffeineMode = caffeine.isSelected();
                boolean nightShiftMode = nightShift.isSelected();
                typistWindow(passageType, numTypists, autocorrectOn, caffeineMode, nightShiftMode);
                sWindow.setVisible(false);
            }
        });

        sWindow.add(passageLabel);
        sWindow.add(passageSelection);
        sWindow.add(seatLabel);
        sWindow.add(seatCount);
        sWindow.add(autocorrect);
        sWindow.add(caffeine);
        sWindow.add(nightShift);
        sWindow.add(startButton);

        sWindow.setVisible(true);
    }

    public static void typistWindow(String passLength, int numTypists, boolean autocorrectOn, boolean caffeineMode, boolean nightShiftMode){
        JFrame tWindow = new JFrame("Typist Setup GUI");
        tWindow.setSize(650,500);
        tWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tWindow.setLocationRelativeTo(null);
        tWindow.setLayout(null);

        Typist[] typists = new Typist[numTypists];
        for (int i = 0; i < numTypists; i++){
            typists[i] = new Typist((char)('1' + i), "Typist " + (i + 1), 0.75);
        }

        JLabel typistLabel = new JLabel("Select typist");
        typistLabel.setBounds(30, 30, 100, 30);

        JComboBox<String> typistSelect = new JComboBox<String>();
        for (int i = 0; i < numTypists; i++){
            typistSelect.addItem("Typist " + (i + 1));
        }
        typistSelect.setBounds(140, 30, 150, 30);

        JLabel styleLabel = new JLabel("Typing Style");
        styleLabel.setBounds(30, 70, 100, 30);

        JComboBox<String> styleSelect = new JComboBox<String>();
        styleSelect.addItem("Touch Typist");
        styleSelect.addItem("Hunt & Peck");
        styleSelect.addItem("Phone Thumbs");
        styleSelect.addItem("Voice-to-Text");
        styleSelect.setBounds(140, 70, 150, 30);

        JLabel keyboardLabel = new JLabel("Keyboard Type");
        keyboardLabel.setBounds(30, 110, 100, 30);

        JComboBox<String> keyboardSelect = new JComboBox<String>();
        keyboardSelect.addItem("Mechanical");
        keyboardSelect.addItem("Membrane");
        keyboardSelect.addItem("Touchscreen");
        keyboardSelect.addItem("Stenography");
        keyboardSelect.setBounds(140, 110, 150, 30);

        JLabel symbolLabel = new JLabel("Symbol / Emoji");
        symbolLabel.setBounds(30, 150, 100, 30);

        JTextField symbolInput = new JTextField();
        symbolInput.setBounds(140, 150, 150, 30);

        JLabel colourLabel = new JLabel("Colour");
        colourLabel.setBounds(30, 190, 100, 30);

        JComboBox<String> colourSelect = new JComboBox<String>();
        colourSelect.addItem("Blue");
        colourSelect.addItem("Red");
        colourSelect.addItem("Green");
        colourSelect.addItem("Orange");
        colourSelect.addItem("Black");
        colourSelect.setBounds(140, 190, 150, 30);

        JCheckBox wristSupport = new JCheckBox("Wrist Support");
        wristSupport.setBounds(30, 240, 140, 30);

        JCheckBox energyDrink = new JCheckBox("Energy Drink");
        energyDrink.setBounds(180, 240, 140, 30);

        JCheckBox headphones = new JCheckBox("Noise-Cancelling Headphones");
        headphones.setBounds(30, 280, 240, 30);

        JTextArea infoArea = new JTextArea("Typing Style: Each option changes your accuracy, speed, and burnout.\nKeyboard Type: Each type changes your speed and mistype rate.\n Symbol & Colour: You can customise a typist's symbol and colour.\nWrist Support: This reduces burnout duration.\nEnergy Drink: This gives better accuracy in the first half, but worse in the second half.\nHeadphones: This reduces mistype chance.");
        infoArea.setBounds(320, 30, 280, 260);
        infoArea.setEditable(false);
        infoArea.setLineWrap(true);
        infoArea.setWrapStyleWord(true);

        JButton startButton = new JButton("Start Race");
        startButton.setBounds(200, 380, 220, 50);
        startButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                raceWindow(passLength, numTypists, autocorrectOn, caffeineMode, nightShiftMode, typists);
                tWindow.setVisible(false);
            }
        });

        tWindow.add(typistLabel);
        tWindow.add(typistSelect);
        tWindow.add(styleLabel);
        tWindow.add(styleSelect);
        tWindow.add(keyboardLabel);
        tWindow.add(keyboardSelect);
        tWindow.add(symbolLabel);
        tWindow.add(symbolInput);
        tWindow.add(colourLabel);
        tWindow.add(colourSelect);
        tWindow.add(wristSupport);
        tWindow.add(energyDrink);
        tWindow.add(headphones);
        tWindow.add(infoArea);
        tWindow.add(startButton);

        tWindow.setVisible(true);
    }
    
    public static void raceWindow(String passLength, int numTypists, boolean autocorrectOn, boolean caffeineMode, boolean nightShiftMode, Typist[] typists){
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