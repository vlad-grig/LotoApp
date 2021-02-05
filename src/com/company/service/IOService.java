package com.company.service;

import java.util.Scanner;

public class IOService {

    private ValidatorService validatorService;
    public final Scanner scanner = new Scanner(System.in);

    public IOService(ValidatorService validatorService) {
        this.validatorService = validatorService;
    }

    public void displayNumbers(int[] myNumbers, String s) {
        for(int number : myNumbers) {
            System.out.print(number + s);
        }
    }

    public void welcomeMessage() {
        System.out.println("Welcome to Loto 6/49!");
    }

    public void displayInfo(String info) {
        System.out.println(info);
    }


    public int[] getUserOption() {
        displayInfo("Get User Option in: Please type 6 unique numbers in the range 1 - 49 inclusive: ");
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

    public void displayError(String error) {
        System.out.println(error);
    }
}
