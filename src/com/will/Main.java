package com.will;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        Console console = new Console();
//
//        int value = console.getInt(1, 10, "die value (1 - 6)");
//        int count = console.getInt(1, 14, "How many" + value + " dice: (1 - 14)");
//
//        Boolean result = console.getYN("Y", "N", "Did the player ");
//
//        System.out.println("you claim " + count + " " + value + "s");

        Player player = new Player("player1");
        player.roll();
        player.peek();
        int[] claim = player.getClaim();
        System.out.println("Player claimed there are " + claim[1] + " " + claim[0] + "s");
        boolean decision = player.getDecision();
        System.out.println(decision ? "Lie called" : "Play on");
    }
}
