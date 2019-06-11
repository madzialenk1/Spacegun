/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jimp2egzaminylato2015;

import java.util.HashMap;
import java.util.Objects;

/**
 *
 * @author jstar
 */
public class Player {

    private final static HashMap<String, Player> players = new HashMap<>();
    
    private final static int MAX_PLAYERS = 4;
    
    private final String nick;
    private int livesLeft = 5;
    private int score = 0;
    
    public static Player createPlayer( String nick ) {
        if( nick == null || nick.trim().length() < 3 )
            throw new IllegalArgumentException("Player's nick must be at least 3-chars long! (\"" + nick + "\" is not)");
        nick = nick.trim();
        if( players.containsKey(nick))
            throw new IllegalArgumentException("Player's nick must be unique! (" + nick + "\" already exists)" );
        if( players.size() == MAX_PLAYERS )
            throw new IllegalStateException("Only " + MAX_PLAYERS + " Players allowed!");
        Player n = new Player(nick);
        players.put(nick, n);
        return n;
    }
    
    public static void deletePlayer( Player p ) {
        if( players.containsKey(p.getNick())) {
            while(p.getLivesLeft() > 0 )  // deactivate
                p.die();
            players.remove(p.getNick());
        }
    }
    
    private Player( String p ) {
        nick = p;
    }

    public String getNick() {
        return nick;
    }
    
    public int getLivesLeft() {
        return livesLeft;
    }
    
    public void die() {
        if( livesLeft > 0 )
            livesLeft--;
    }


    public int getScore() {
        return score;
    }

    /**
     * @param points is added to the score (points can be negative)
     */
    public void addToScore(int points) {
        if( livesLeft > 0 )
            score += points;
    }
    
    @Override
    public boolean equals(Object o) {
        return o instanceof Player && ((Player)o).getNick().equals(nick);
    }

    @Override
    public int hashCode() {
        return 17 + nick.hashCode();
    }
    
    @Override
    public String toString() {
        return nick + " : " + score + " points, " + livesLeft + " lives left";
    }
}
