/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jimp2egzaminylato2015;

import java.util.Objects;

/**
 *
 * @author jstar
 */
public class JiMP2EgzaminyLato2015 {

    public static void demo4_Gambler() {
        System.out.println("----------------------\nDemo for Gambler class:");
        Gambler g = new Gambler("    Tester   ");
        System.out.println("Gambler g equals null : " + g.equals((Gambler) null));
        g.setCurrentPoints(500);
        g.setCurrentPoints(300);
        System.out.println(g);
        System.out.println(g.hashCode());
        System.out.println(Objects.hash(g));
        Gambler[] t = new Gambler[5];
        java.util.Random r = new java.util.Random();
        for (int i = 0; i < 5; i++) {
            t[i] = new Gambler("P00" + i);
            t[i].setCurrentPoints(r.nextInt(1000));
        }
        java.util.Arrays.sort(t);
        for (Gambler p : t) {
            System.out.println(p);
        }

    }

    public static void demo4_StubbornCounder() {
        System.out.println("----------------------\nDemo for StubbornCounter class:");
        StubbornCounter c = new StubbornCounter("sc", 500);
        c.start();
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.exit(1);
            }
            System.out.println(c.getName() + " : " + c.getValue());
            c.interrupt();
        }
        c.setStop();
        try {
            c.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.exit(2);
        }
        System.out.println("Finally " + c.getName() + " : " + c.getValue());
    }

    static void printPlayers(Player[] p) {
        for (Player pl : p) {
            if (pl != null) {
                System.out.println(pl);
            }
        }
    }

    static void demo4_Player() {
        System.out.println("----------------------\nDemo for Player class:");
        Player[] p = new Player[10];
        for (int i = 0; i < p.length; i++) {
            p[i] = null;
        }
        p[0] = Player.createPlayer("P00");  // this works
        System.out.println("Wrong construction:");
        try {
            p[1] = Player.createPlayer(null);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            p[1] = Player.createPlayer("   P1     ");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            p[1] = Player.createPlayer("P00");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Limit:");
        for (int i = 1; i < p.length; i++) {
            try {
                p[i] = Player.createPlayer("P0" + i);
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
        System.out.println("Methods:");
        printPlayers(p);
        for (Player pl : p) {
            if (pl != null) {
                pl.addToScore(100);
                pl.die();
            }
        }
        printPlayers(p);
        while (p[1].getLivesLeft() > 0) {
            p[1].die();
        }
        for (Player pl : p) {
            if (pl != null) {
                pl.addToScore(100);
                pl.die();
            }
        }
        printPlayers(p);
        Player.deletePlayer(p[2]);
        p[2] = Player.createPlayer("PXX");
        printPlayers(p);
    }

    static void demo4_ConcurrentStack() {
        System.out.println("----------------------\nDemo for ConcurrentStack class:");
        final ConcurentStack s = new ConcurentStack();
        Thread feed = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 31; i++) {
                    s.push(new String("String #" + i));
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            }

        });
        feed.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            feed.interrupt();
            return;
        }
        Thread eat = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    System.out.println(s.pop());
                }
            }

        });
        eat.start();
        try {
        feed.join();
        eat.join();
        } catch( InterruptedException e ) {
            
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        demo4_Gambler();
        demo4_StubbornCounder();
        demo4_Player();
        demo4_ConcurrentStack();
    }

}
