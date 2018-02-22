package madlibs;

/*
 * Mad Libs is a phrasal template word game where the player
 * is prompted for a list of words to substitute for blanks
 * in a story, before reading the – often comical or nonsensical
 * – story aloud.
 */

public class Main {
    public static void main(String[] args) {
        MadLibs game = new MadLibs();
        game.play();
    }
}
