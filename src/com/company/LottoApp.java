package com.company;

import com.company.service.DelayService;
import com.company.service.IOService;
import com.company.service.ValidatorService;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class LottoApp {

    private final IOService ioService;
    private final DelayService delayService;
    private ValidatorService validatorService;

    public LottoApp() {
        this.ioService = new IOService(validatorService);
        this.delayService = new DelayService();
        this.validatorService = new ValidatorService(ioService);
    }

    public void start() {
        ioService.welcomeMessage();
//        loadNumber();
        int[] userOption = ioService.getUserOption();
        int[] processedUserOption = validatorService.processUserOption(userOption);
        ioService.displayInfo("Your numbers are: ");
        ioService.displayNumbers(processedUserOption, " ");
        extractLuckyNumber();
        ioService.displayInfo("\n");
    }

    private void extractLuckyNumber() {
        Random random = new Random();
        int[] luckyNumbers = new int[6];
        for(int index = 0; index < 6; index++) {
            int nextInt = ThreadLocalRandom.current().nextInt(1, 50);
            luckyNumbers[index] = nextInt;
        }
        if(!validatorService.foundDuplicateIntoArray(luckyNumbers)){
            ioService.displayInfo("\nAnd the lucky numbers are: ");
            ioService.displayNumbers(luckyNumbers, " ");
        }else {
            extractLuckyNumber();
        }
    }

    private void loadNumber() {
        ioService.displayInfo("This is a set of numbers form 1 to 49: ");
        int[] myNumbers = getInts(49, 1);
        ioService.displayNumbers(myNumbers, "  ");
    }

    private int[] getInts(int maxNumber, int minNumber) {
        int[] myNumbers = new int[maxNumber];
        for(int index = 0; index < myNumbers.length; index++) {
            myNumbers[index] = index + minNumber;
        }
        return myNumbers;
    }
}