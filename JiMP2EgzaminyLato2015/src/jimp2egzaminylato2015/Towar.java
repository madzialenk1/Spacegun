/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jimp2egzaminylato2015;

import java.util.HashMap;

public class Towar implements Comparable<Towar> {

    private String name;
    private int cena;
    private double waga;

    private final static HashMap<String, Towar> towary = new HashMap<>();

    public Towar(String name, int cena, double waga) {
        if (towary.containsKey(name)) {
            throw new IllegalArgumentException("Nazwa towaru musi być unikalna!");
        }
        
        this.name = name;
        this.cena = cena;
        this.waga = waga;

        towary.put(name, this);
    }

    @Override
    public int compareTo(Towar o) {
        return name.compareTo(o.name);
    }

    public String getName() {
        return name;
    }

    public int getCena() {
        return cena;
    }

    public double getWaga() {
        return waga;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Towar && ((Towar) o).getName().equals(name);
    }

    @Override
    public int hashCode() {
        return 17 + name.hashCode();
    }

    public static void main(String[] args) {
        Towar t1 = new Towar("a", 10, 20);
        Towar t2 = new Towar("a", 5, 10);
    }
}
