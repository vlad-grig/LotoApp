package com.company.service;

public class DelayService {

    public void introduceDelay() {
        try {
            Thread.sleep(500);
        }
        catch( InterruptedException e ) {
            e.printStackTrace();
        }
    }
}
