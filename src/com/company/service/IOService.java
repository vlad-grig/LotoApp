package com.company.service;

import java.util.Scanner;

public class IOService {
    private final Scanner scanner = new Scanner(System.in);

    public void displayNumbers(int[] myNumbers, String s) {
        for(int number : myNumbers) {
            System.out.print(number + s);
        }
    }

    public String getUserInput(){
        return scanner.nextLine();
    }

    public void welcomeMessage() {
        System.out.println("Welcome to our game 6/49!");
    }

    public void displayInfo(String s) {
        System.out.println(s);
    }

    public int getUserOption() {
        return scanner.nextInt();
    }
}
