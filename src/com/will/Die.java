package com.will;

import java.util.Random;

public class Die {
    private int sides;
    private int value;

    public Die() {
        sides = 6;
        value = 1;
    }

    public void roll(Random rand) {
        // value = rand.nextInt(sides); 0 - 5
        value = rand.nextInt(sides) + 1; // 1 - 6
    }

    public int getValue() {return value;}

}