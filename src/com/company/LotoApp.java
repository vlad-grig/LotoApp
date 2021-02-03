package com.company;

import com.company.service.DelayService;
import com.company.service.IOService;


public class LotoApp {

    private final IOService ioService;
    private final DelayService delayService;

    public LotoApp() {
        this.ioService = new IOService();
        this.delayService = new DelayService();
    }

    public void start() {
        ioService.welcomeMessage();
        loadNumber();
        int[] userOption = getUserOption();
        int[] processUserOption = processUserOption(userOption);
        ioService.displayInfo("Your numbers are: ");
        ioService.displayNumbers(processUserOption, " ");

    }

    private int[] processUserOption(int[] userOption) {
        int element = 0;
        for(int number : userOption) {
            element = number;
            if (element <1 || element > 49){
                ioService.displayInfo("Invalid number! Out of range 1 - 49!");
                return getUserOption();
            }
        }return userOption;
    }

    private int[] getUserOption() {
        ioService.displayInfo("\nChoose 6 numbers from the set above: ");
        int[] userNumbers = new int[6];
        for(int index = 0; index < 6; index++) {
            int userOption = ioService.getUserOption();
            userNumbers[index] = userOption;
        }
        return userNumbers;
    }

    private void loadNumber() {
        ioService.displayInfo("This is a set of numbers: ");
        int[] myNumbers = getInts(49, 1);
        ioService.displayNumbers(myNumbers, "  ");
    }

    private int[] getInts(int i, int i2) {
        int[] myNumbers = new int[i];
        for(int index = 0; index < myNumbers.length; index++) {
            myNumbers[index] = index + i2;
        }
        return myNumbers;
    }
}