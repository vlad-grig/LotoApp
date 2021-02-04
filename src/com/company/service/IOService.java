package com.company.service;

import java.util.Scanner;

public class IOService {
    private final Scanner scanner = new Scanner(System.in);

    public void displayNumbers(int[] myNumbers, String s) {
        for(int number : myNumbers) {
            System.out.print(number + s);
        }
    }

    public void welcomeMessage() {
        System.out.println("Welcome to our game 6/49!");
    }

    public void displayInfo(String s) {
        System.out.println(s);
    }


    public int[] getUserOption() {
        displayInfo("\nPlease choose 6 unique numbers in the range 1 - 49: ");
        return getNumbersFromUser();
    }

    private int[] getNumbersFromUser() {
        int[] userNumbers = new int[6];
        for(int index = 0; index < 6; index++) {
            int userOption = scanner.nextInt();
            userNumbers[index] = userOption;
        }
        return userNumbers;
    }
}
