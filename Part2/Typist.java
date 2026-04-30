/**
 * Write a description of class Typist here.
 *
 * Starter code generously abandoned by Ty Posaurus, your predecessor,
 * who typed with two fingers and considered that "good enough".
 * He left a sticky note: "the slide-back thing is optional probably".
 * It is not optional. Good luck.
 *
 * @author Abdullah Ashraf
 * @version 1
 */
public class Typist
{
    // Fields of class Typist
    // Hint: you will need six fields. Think carefully about their types.
    // One of them tracks how far along the passage the typist has reached.
    // Another tracks whether the typist is currently burnt out.
    // A third tracks HOW MANY turns of burnout remain (not just whether they are burnt out).
    // The remaining three should be fairly obvious.

    private char typistSymbol;
    private String typistName;
    private double typistAccuracy;
    private double typistSpeed;
    private double burnoutModifier;
    private int typistProgress;
    private int burnoutRemaining;
    private boolean burntOut;
    private String typingStyle;
    private String keyboardType;
    private String typistColour;
    private boolean wristSupport;
    private boolean energyDrink;
    private boolean noiseCancellingHeadphones;

    // Constructor of class Typist
    /**
     * Constructor for objects of class Typist.
     * Creates a new typist with a given symbol, name, and accuracy rating.
     *
     * @param typistSymbol  a single Unicode character representing this typist (e.g. '①', '②', '③')
     * @param typistName    the name of the typist (e.g. "TURBOFINGERS")
     * @param typistAccuracy the typist's accuracy rating, between 0.0 and 1.0
     */
    public Typist(char typistSymbol, String typistName, double typistAccuracy)
    {
        this.typistSymbol = typistSymbol;
        this.typistName = typistName;
        this.typistAccuracy = typistAccuracy;
        this.typistSpeed = 1.0;
        this.burnoutModifier = 0.0;
        this.typistProgress = 0;
        this.burntOut = false;
        this.burnoutRemaining = 0;
        this.typingStyle = "Touch Typist";
        this.keyboardType = "Mechanical";
        this.typistColour = "Blue";
        this.wristSupport = false;
        this.energyDrink = false;
        this.noiseCancellingHeadphones = false;
    }


    // Methods of class Typist

    /**
     * Sets this typist into a burnout state for a given number of turns.
     * A burnt-out typist cannot type until their burnout has worn off.
     *
     * @param turns the number of turns the burnout will last
     */
    public void burnOut(int turns)
    {
        this.burntOut = true;
        this.burnoutRemaining = turns;
    }

    /**
     * Reduces the remaining burnout counter by one turn.
     * When the counter reaches zero, the typist recovers automatically.
     * Has no effect if the typist is not currently burnt out.
     */
    public void recoverFromBurnout()
    {
        int BurnoutTurns = this.getBurnoutTurnsRemaining();
        boolean isBurnt = this.isBurntOut();

        if (isBurnt){
            if (BurnoutTurns > 0){
                BurnoutTurns = BurnoutTurns -1;
            }
            
            if (BurnoutTurns == 0){
                isBurnt = false;
            }
            this.burntOut = isBurnt;
            this.burnoutRemaining = BurnoutTurns;
        }
    }

    /**
     * Returns the typist's accuracy rating.
     *
     * @return accuracy as a double between 0.0 and 1.0
     */
    public double getAccuracy()
    {
        return this.typistAccuracy;
    }

    /**
     * Returns the typist's current progress through the passage.
     * Progress is measured in characters typed correctly so far.
     * Note: this value can decrease if the typist mistypes.
     *
     * @return progress as a non-negative integer
     */
    public int getProgress()
    {
        return this.typistProgress;
    }

    /**
     * Returns the name of the typist.
     *
     * @return the typist's name as a String
     */
    public String getName()
    {
        return this.typistName;
    }

    /**
     * Returns the typist's typing style.
     */
    public String getTypingStyle()
    {
        return this.typingStyle;
    }

    /**
     * Returns the typist's keyboard type.
     */
    public String getKeyboardType()
    {
        return this.keyboardType;
    }

    /**
     * Returns the typist's colour.
     */
    public String getColour()
    {
        return this.typistColour;
    }

    /**
     * Returns the typist's speed rating.
     */
    public double getSpeed()
    {
        return this.typistSpeed;
    }

    /**
     * Returns the typist's burnout modifier.
     */
    public double getBurnoutModifier()
    {
        return this.burnoutModifier;
    }

    /**
     * Returns true if wrist support is enabled.
     */
    public boolean hasWristSupport()
    {
        return this.wristSupport;
    }

    /**
     * Returns true if energy drink is enabled.
     */
    public boolean hasEnergyDrink()
    {
        return this.energyDrink;
    }

    /**
     * Returns true if noise-cancelling headphones are enabled.
     */
    public boolean hasNoiseCancellingHeadphones()
    {
        return this.noiseCancellingHeadphones;
    }

    /**
     * Returns the character symbol used to represent this typist.
     *
     * @return the typist's symbol as a char
     */
    public char getSymbol()
    {
        return this.typistSymbol;
    }

    /**
     * Returns the number of turns of burnout remaining.
     * Returns 0 if the typist is not currently burnt out.
     *
     * @return burnout turns remaining as a non-negative integer
     */
    public int getBurnoutTurnsRemaining()
    {
        return this.burnoutRemaining;
    }

    /**
     * Resets the typist to their initial state, ready for a new race.
     * Progress returns to zero, burnout is cleared entirely.
     */
    public void resetToStart()
    {
        this.burntOut = false;
        this.burnoutRemaining = 0;
        this.typistProgress = 0;
    }

    /**
     * Returns true if this typist is currently burnt out, false otherwise.
     *
     * @return true if burnt out
     */
    public boolean isBurntOut()
    {
        return this.burntOut;
    }

    /**
     * Advances the typist forward by one character along the passage.
     * Should only be called when the typist is not burnt out.
     */
    public void typeCharacter()
    {
        boolean burntout = this.isBurntOut();
        int progress = this.getProgress();

        if (!burntout){
            progress += 1;
        }

        this.typistProgress = progress;
    }

    /**
     * Moves the typist backwards by a given number of characters (a mistype).
     * Progress cannot go below zero — the typist cannot slide off the start.
     *
     * @param amount the number of characters to slide back (must be positive)
     */
    public void slideBack(int amount)
    {
        int progress = this.getProgress();
        if (amount > 0){
            if (progress - amount < 0){
                progress = 0;
            }
            else{
                progress = progress-amount;
            }
        }

        this.typistProgress = progress;
    }

    /**
     * Sets the accuracy rating of the typist.
     * Values below 0.0 should be set to 0.0; values above 1.0 should be set to 1.0.
     *
     * @param newAccuracy the new accuracy rating
     */
    public void setAccuracy(double newAccuracy)
    {
        if (newAccuracy < 0){
            newAccuracy = 0.0;
        }
        else if (newAccuracy > 1){
            newAccuracy = 1.0;
        }

        this.typistAccuracy = newAccuracy;
    }

    /**
     * Sets the typist's speed rating.
     */
    public void setSpeed(double newSpeed)
    {
        this.typistSpeed = newSpeed;
    }

    /**
     * Sets the typist's burnout modifier.
     */
    public void setBurnoutModifier(double newBurnoutModifier)
    {
        this.burnoutModifier = newBurnoutModifier;
    }

    /**
     * Sets the typist's typing style.
     */
    public void setTypingStyle(String newStyle)
    {
        this.typingStyle = newStyle;
    }

    /**
     * Sets the typist's keyboard type.
     */
    public void setKeyboardType(String newKeyboard)
    {
        this.keyboardType = newKeyboard;
    }

    /**
     * Sets the typist's colour.
     */
    public void setColour(String newColour)
    {
        this.typistColour = newColour;
    }

    /**
     * Sets whether wrist support is enabled.
     */
    public void setWristSupport(boolean newWristSupport)
    {
        this.wristSupport = newWristSupport;
    }

    /**
     * Sets whether energy drink is enabled.
     */
    public void setEnergyDrink(boolean newEnergyDrink)
    {
        this.energyDrink = newEnergyDrink;
    }

    /**
     * Sets whether noise-cancelling headphones are enabled.
     */
    public void setNoiseCancellingHeadphones(boolean newHeadphones)
    {
        this.noiseCancellingHeadphones = newHeadphones;
    }

    /**
     * Sets the symbol used to represent this typist.
     *
     * @param newSymbol the new symbol character
     */
    public void setSymbol(char newSymbol)
    {
        this.typistSymbol = newSymbol;
    }

}
