package com.will;

import java.util.ArrayList;
import java.util.List;

public class LiarsDice {
    public List<Player> players;
    private Console console = new Console();
    private int[] claim

    public LiarsDice(int numPlayers) {
        players = new ArrayList<>();
        for (int count = 0; count < numPlayers; count++) {
            players.add(new Player(console.getString("Player " + (count + 1) + "'s Name")));
        }
    }

    public void runRound() {
        shakeAllCups();
        System.out.println(players.get(0).getName() + "'s turn");
        players.get(0).peek();
        int[] claim = players.get(0).getClaim();
        while(true) {
            //runturn(players.get(activePlayer));
        }
    }

    public void runTurn(Player player){
        console.getString(player.get(0).getName() + "'s turn press enter to continue");
        boolean decision = player.getDecision();
        if (decision) {
            // called lie end turns
            return;
        }
        int[] newClaim = players.get(0).getClaim();
        // validate claim if invalid adk for new claim
    }

    private boolean isValidClaim(int[] newClaim) {
        return false;
    }

    private void shakeAllCups() {
        for (var player : players) {
            player.roll();
        }
    }
}
