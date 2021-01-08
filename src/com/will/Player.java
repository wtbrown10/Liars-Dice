package com.will;

public class Player {
    static int DICE_NUMBER = 7;
    private Cup cup;
    private String name;
    Console console = new Console();

    public Player(String name) {
        this.name = name;
        cup = new Cup(DICE_NUMBER);
    }

    // shake cup
    public void roll() {cup.roll();}
    // peek
    public void peek() {cup.peek();}

    public void getName() {
        this.name = name;
    }
    // make claim

    public int[] getClaim() {
        int dieValue, dieCount;
        Console console = new Console();
        dieValue = console.getInt(1, 6, "what die value: 1-6");
        dieCount = console.getInt(1, 14, "How many" + dieValue + " dice: (1 - 14)");

        return new int[] {dieValue, dieCount};
    }


    // decide if call play
    public boolean getDecision() {
        return console.getYN("liar", "play", "Do you call the previous claim? liar or play");
    }

    public boolean isOut(){
        return cup.size() <= 0;
    }
}
