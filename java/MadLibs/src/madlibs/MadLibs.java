package madlibs;

import java.util.Random;
import java.util.Scanner;

public class MadLibs {

    //public MadLibs() {}

    private Scanner scanner = new Scanner(System.in);
    private String story;
    private String name;
    private String noun1;
    private String noun2;
    private String noun3;
    private String adj1;
    private String adj2;
    private String adv;
    private String randomNums;
    private Random rand = new Random();

    // Play the game
    public void play(){
        printInstructions();
        enterName();
        enterNoun1();
        enterNoun2();
        enterNoun3();
        enterAdj1();
        enterAdj2();
        enterAdv();
        setRandomNums();
        putTogetherTheStory();
        printStory();
    }

    // Print the instructions
    private void printInstructions(){
        System.out.println("Welcome to the Madlibs game. If you type in " +
                "words, we will give you a story. Start by typing in a name.");
    }

    // Get input from player
    private void enterName(){
        setName(scanner.nextLine());
    }

    private void enterNoun1(){
        System.out.println("Now give me a noun.");
        setNoun1(scanner.nextLine());
    }

    private void enterNoun2(){
        System.out.println("Now give me another noun.");
        setNoun2(scanner.nextLine());
    }

    private void enterNoun3(){
        System.out.println("Now give me another noun! I promise this is the last..");
        setNoun3(scanner.nextLine());
    }

    private void enterAdj1(){
        System.out.println("Noun finished! Then I need an adjective.");
        setAdj1(scanner.nextLine());
    }

    private void enterAdj2(){
        System.out.println("I need another and last adjective.");
        setAdj2(scanner.nextLine());
    }

    private void enterAdv(){
        System.out.println("Yeah! The final word I need is an adverb. Give me one:)");
        setAdv(scanner.nextLine());
    }

    // Output a story from the input of player
    private void putTogetherTheStory(){
        String story = "Jesse and her best friend "+getName()+" went to Disney World today! "
                + "They saw a "+getNoun1()+" in a show at the Magic Kingdom "
                + "and ate a "+getAdj1()+" feast for dinner. The next day I"
                + " ran "+getAdv()+" to meet Mickey Mouse in his "+getNoun2()+ ","
                + " and then that night I gazed at the "+getRandomNums()+ " "
                + getAdj2() + " fireworks shooting from the "+getNoun3()+".";
        setStory(story);
    }

    // Print put the story
    private void printStory(){
        System.out.println("So here is the story!");
        System.out.print(story);
    }


    // Getter and Setter

    public String getStory() {
        return story;
    }

    private void setStory(String story) {
        this.story = story;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getAdj1() {
        return adj1;
    }

    private void setAdj1(String adj1) {
        this.adj1 = adj1;
    }

    public String getAdj2() {
        return adj2;
    }

    private void setAdj2(String adj2) {
        this.adj2 = adj2;
    }

    public String getNoun1() {
        return noun1;
    }

    private void setNoun1(String noun1) {
        this.noun1 = noun1;
    }

    public String getNoun2() {
        return noun2;
    }

    private void setNoun2(String noun2) {
        this.noun2 = noun2;
    }

    public String getNoun3() {
        return noun3;
    }

    private void setNoun3(String noun3) {
        this.noun3 = noun3;
    }

    public String getAdv() {
        return adv;
    }

    private void setAdv(String adv) {
        this.adv = adv;
    }

    public String getRandomNums() {
        return randomNums;
    }

    private void setRandomNums() {
        int num = Math.abs(rand.nextInt())%100;
        int[] numberHolder = new int[3];
        for (int i=0; i < numberHolder.length; i++){
            numberHolder[i] = num + i;
        }
        this.randomNums = "not "+numberHolder[0]+", not "+numberHolder[1]+", but "+ numberHolder[2];
    }
}
