/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jimp2egzaminylato2015;

import java.util.ArrayList;

/**
 *
 * @author jstar
 */
public class ConcurentStack {

    private final ArrayList s = new ArrayList();

    public synchronized void push(Object x) {
        s.add(x);
        notifyAll();
    }

    public synchronized Object pop() {
        while (s.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                return null;
            }
        }
        return s.remove(s.size()-1);
    }
}
