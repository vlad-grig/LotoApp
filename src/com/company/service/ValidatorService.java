package com.company.service;

public class ValidatorService {

    private final IOService ioService;

    public ValidatorService(IOService ioService) {
        this.ioService = ioService;
    }

    public int[] processUserOption(int[] userOption) {
        boolean foundDuplicateIntoArray = foundDuplicateIntoArray(userOption);
        boolean outOfRange = checkOutOfRange(userOption);
        if (!foundDuplicateIntoArray && !outOfRange) {
            return userOption;
        } else {
            userOption = ioService.getUserOption();
            return processUserOption(userOption);
        }
    }

    public boolean checkOutOfRange(int[] userOption) {
        for(int currentElement : userOption) {
            if (!(currentElement >= 1 && currentElement <= 49)) {
                return true;
            }
        }
        return false;
    }

    public boolean foundDuplicateIntoArray(int[] userOption) {
        for(int index0 = 0; index0 < userOption.length; index0++) {
            for(int index1 = index0 + 1; index1 < userOption.length; index1++) {
                int i0 = userOption[index0];
                int i1 = userOption[index1];
                if (i0 == i1) {
                    return true;
                }
            }
        }
        return false;
    }
}
