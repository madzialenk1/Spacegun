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
public class Gambler implements Comparable<Gambler> {

    private String nick;
    private int maxPoints;
    private int currentPoints;
    
    public Gambler(String n) {
        if( n == null || n.trim().length() < 3 )
            throw new IllegalArgumentException("Gambler's nick must be longet than 3 non-white characters");
        nick= n.trim();
        maxPoints = currentPoints = 0;
    }

    @Override
    public int compareTo(Gambler o) {
        return getMaxPoints() - o.getMaxPoints();
    }

    /**
     * @return the nick
     */
    public String getNick() {
        return nick;
    }

    /**
     * @return the maxPoints
     */
    public int getMaxPoints() {
        return maxPoints;
    }

    /**
     * @param maxPoints the maxPoints to set
     */
    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    /**
     * @return the currentPoints
     */
    public int getCurrentPoints() {
        return currentPoints;
    }

    /**
     * @param currentPoints the currentPoints to set
     */
    public void setCurrentPoints(int currentPoints) {
        this.currentPoints = currentPoints;
        if( currentPoints > maxPoints )
            maxPoints = currentPoints;
    }
    
    @Override
    public boolean equals( Object o ) {
        return o instanceof Gambler && ((Gambler)o).nick.equals(nick);
    }

    @Override
    public int hashCode() {
        return nick.hashCode();
    }
    
    @Override
    public String toString() {
        return nick + ": max score: " + maxPoints + ", current score: " + currentPoints;
    }

}
