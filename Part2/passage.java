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
