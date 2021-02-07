package com.company.service;

public class ValidatorService {

    private IOService ioService;

    public ValidatorService(IOService ioService) {
        this.ioService = ioService;
    }

    public int[] processUserOption(int[] userOption) {
        boolean foundDuplicateIntoArray = foundDuplicateIntoArray(userOption);
        if (!foundDuplicateIntoArray) {
            ioService.displayInfo("good job, no duplicate!");
            for(int i = 0; i < userOption.length; i++) {
                int curentElement = userOption[i];
                if (!(curentElement >= 1 && curentElement <= 49)) {
                    ioService.displayInfo("Invalid number! Out of range 1 - 49!");
                    userOption = ioService.getUserOption();
                    return processUserOption(userOption);
                }
            }
        } else {
            System.out.println("you got here now!!!!");
            userOption = ioService.getUserOption();
            return processUserOption(userOption);
        }
        return userOption;
    }

    public boolean foundDuplicateIntoArray(int[] userOption) {
        for(int index0 = 0; index0 < userOption.length; index0++) {
            for(int index1 = index0 + 1; index1 < userOption.length; index1++) {
                int i0 = userOption[index0];
                int i1 = userOption[index1];
                if (i0 == i1) {
                    ioService.displayError("Duplicates were found!");
                    return true;
                }
            }
        }
        return false;
    }
}
