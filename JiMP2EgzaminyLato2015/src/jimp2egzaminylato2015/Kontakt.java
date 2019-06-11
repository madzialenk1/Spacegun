/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jimp2egzaminylato2015;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Daniel
 */
public class Kontakt implements Comparable<Kontakt> {

    private String name;
    private String surname;
    Set<Integer> phoneNumber = new HashSet<Integer>();

    public Kontakt(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void addPhone(int no) {
        phoneNumber.add(no);
    }

    public void removePhone(int no) {
        phoneNumber.remove(no);
    }

    @Override
    public String toString() {
        return surname + " " + name + " " + "Numery: " + phoneNumber;
    }

    @Override
    public int hashCode() {
        return surname.hashCode() + name.hashCode() + phoneNumber.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Kontakt && ((Kontakt)o).getSurname().equals(surname) && ((Kontakt)o).getName().equals(name);
    }

    @Override
    public int compareTo(Kontakt o) {
        int e = surname.compareTo(o.surname);
        if (e == 0) {
            e = name.compareTo(o.name);
        }
        return e;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public static void main(String[] args) {
        Kontakt c = new Kontakt("Konrad", "Rucinski");
        c.addPhone(800700600);
        c.addPhone(800700600);
        c.addPhone(452125452);
        
        Kontakt d = new Kontakt("Konrad", "Rucinski");
        d.addPhone(800700600);
        d.addPhone(801700600);
        d.addPhone(452125452);
        
        System.out.println(d.hashCode() + "\n" + c.hashCode());
                
    }

}
