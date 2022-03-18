package com.Allen;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int playerGuess;
        int tryCount = 1;

        int randomNumber = random.nextInt(100) + 1;
        System.out.println("Random number is: " + randomNumber);



        while(true){
            System.out.print("Enter your guess (1-100): ");
            playerGuess = scanner.nextInt();
            tryCount++;
            if (randomNumber == playerGuess) {
                System.out.println("CORRECT. YOU WIN.");
                System.out.println("It took you " + tryCount + " tries.");
                break;
            } else if (randomNumber > playerGuess){
                System.out.print("NOPE! The number is higher. Guess again: ");
            } else {
                System.out.println("NOPE! The number is lower. Guess again: ");
            }
        }
    }
}
