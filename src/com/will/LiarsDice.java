package com.will;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LiarsDice {
    private List<Player> players;
    private Console console = new Console();
    final int CLAIM_VALUE = 0, CLAIM_COUNT = 1;
    private int[] claim;

    public LiarsDice(int numPlayers) {
        players = new ArrayList<>();
        for (int count = 0; count < numPlayers; count++) {
            players.add(new Player(console.getString("Player " + (count + 1) + "'s Name")));
        }
        while (true) {
            boolean continueGame = runRound();
            if (!continueGame) break;
        }
    }

    public boolean runRound() {
        shakeAllCups();
        System.out.println(players.get(0).getName() + "'s turn");
        players.get(0).peek();
        claim = players.get(0).getClaim();
        int activePlayer = 1;
        while (true) {
            boolean continueRound = runTurn(players.get(activePlayer % players.size()));
            if (!continueRound) break;
            activePlayer++;
        }
        if (isLie()) {
            activePlayer -= 1;
        }
        int affectedPlayer = activePlayer % players.size();
        players.get(affectedPlayer).removeDie();
        if (players.get(affectedPlayer).isOut()) {
            players.remove(affectedPlayer);
        }
        // determine if there are enough players to continue.
        if (players.size() == 1) {
            System.out.println("Game over " + players.get(0).getName() + " Wins!");
            return false;
        }
        return true;
    }

    public boolean runTurn(Player player) {
        console.getString(player.getName() + "'s turn press enter to continue");
        player.peek();
        System.out.println("The current claim is: " + claim[CLAIM_COUNT] + " " + claim[CLAIM_VALUE] + "s" );
        boolean decision = player.getDecision();
        if (decision) {
            // called lie end turns.
            return false;
        }
        int [] newClaim;
        while (true) {
            newClaim = player.getClaim();
            if (isValidClaim(newClaim)) break;
        }
//        do {
//            newClaim = player.getClaim();
//        } while (!isValidClaim(newClaim));

        claim = newClaim;
        return true;
    };

    private boolean isValidClaim(int[] newClaim) {

        //claim: value 3, count 3
        //newClaim: value 4, count 1
        if (newClaim[CLAIM_COUNT] == claim[CLAIM_COUNT] && newClaim[CLAIM_VALUE] == claim[CLAIM_VALUE]) {
            System.out.println("Error: must be a new claim");
            return false;
        }
        if (newClaim[CLAIM_VALUE] < claim[CLAIM_VALUE]) {
            System.out.println("Error: Die value must be same or increased");
            return false;
        }
        if (newClaim[CLAIM_VALUE] == claim[CLAIM_VALUE] && claim[CLAIM_COUNT] > newClaim[CLAIM_COUNT]) {
            System.out.println("Error: Must increment at least one item");
            return false;
        }

        return true;
    }

    private void shakeAllCups() {
        for (var player : players) {
            player.roll();
        }
    }

    private boolean isLie() {
        int count = 0;
        for (var player : players) {
            count += player.countValue(claim[CLAIM_VALUE]);
        }
        return count < claim[CLAIM_COUNT];
    }
}