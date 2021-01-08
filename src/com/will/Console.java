package com.will;

import java.util.Scanner;

public class Console {
    Scanner scanner = new Scanner(System.in);
    public int getInt(int min, int max, String query){
        int value = 0;
        do {
            System.out.println(query);
            value = scanner.nextInt();
        }
        while(value < min || value > max);
        return value;
    }

    public boolean getYN(String yes, String no, String query) {
        String input = "";
        do {
            System.out.println(query);
            input = scanner.nextLine();
        } while (!input.equals(yes) && !input.equals(no));
        return  input.equals(yes);
    }

    public String getString() {

    }
}

// getInt(1, 4, "want a numnber"

//output
// i want numner
//0 reask
//5 reask
//3 reenter