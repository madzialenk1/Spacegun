/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jimp2egzaminylato2015;

/**
 *
 * @author jstar
 */
public class StubbornCounter extends Thread {

    private String name;
    private final long interval;
    private long value;
    private boolean canRun;

    public StubbornCounter(String n, long interval) {
        super(n);
        this.interval = interval; // it would be nice to check the given value
        value = 0; // redundant but clear
        canRun = true;
    }

    public long getValue() {
        return value;
    }

    @Override
    public void run() {
        while (canRun) {
            value++;
            try {
                sleep(interval);
            } catch (InterruptedException e) {
                value = 0;
            }

        }
    }
    
    public void setStop() {
        canRun = false;
    }

}
