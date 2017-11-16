/*
 *  Derek Dahl
 *  PRG/421 - Java II
 *  Week 3 Individual Assignment
 *  November 13, 2017
 *  
 *  Program Description:
 *  Allow the reading of a collection of animal objects from an external file.
 *  Output on screen the content of a collection of animal objects.
 *  Use Iterator to achieve these goals.   
 *
 */
package week3individual;

import java.io.Serializable;
import java.util.Arrays;

/**
 *
 * @author Derek Dahl
 */
public class Animal implements Serializable { //implements serializable interface too allow streaming to a binary file

    String name;
    String attributes[]; //attributes are left as a simple string array or simplicity sake

    /**
     *
     * @param n
     * @param a
     */
    public Animal(String n, String...a) {//overloaded constructor in case there are no attributes
        this.name = n;
        this.attributes = a;
    }

    /**
     *
     * @param n
     */
    public Animal(String n) {//default constructor
        this.name = n;
        this.attributes = null;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     *
     * @param a
     */
    public void setAttributes(String...a) { //not currently needed, but included to intergrate into week 2
        this.attributes = a;
    }

    /**
     *
     * @return
     */
    public String[] getAttributes() {
        return attributes;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {//overrides toString() with desired content String
        String content = "Animal: " + this.getName()
                + "\n\t" + "Attributes: " + Arrays.toString(this.getAttributes())
                + "\n";
        return content;
    }

}
