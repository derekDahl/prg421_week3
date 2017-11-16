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
 */
package week3individual;

import java.util.ArrayList;
import java.util.Iterator;
import java.io.*;

/**
 *
 * @author Derek Dahl
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

        System.out.println("***** Displays the contents of Animal objects from an array list *****\n"
                + " *** then from an array list populated from an external file ***\n");

        //**prompts user for enter to press enter
        userCont();

        ArrayList<Animal> zoo = new ArrayList<>(); //create new arraylist zoo

        /**
         * Manually creates 3 animal objects
         */
        Animal animal1 = new Animal("zebra", "black/white", "vertibrate");
        Animal animal2 = new Animal("seal", "gray", "swims", "vertibrate");
        Animal animal3 = new Animal("lion", "yellow", "eats people");

        /**
         * Manually adds animal objects to the zoo ArrayList
         */
        zoo.add(animal1);
        zoo.add(animal2);
        zoo.add(animal3);

        Iterator<Animal> animalIterator = zoo.iterator(); //creates creates animalIterator variable and calls iterator method

        /**
         * Iterates through the animalIterator
         */
        System.out.println("These are the animal object contents BEFORE being written to a file");
        System.out.println("------------------------------------------------------------------");
        while (animalIterator.hasNext()) {
            Animal animal = animalIterator.next();
            System.out.println(animal.toString());
        }

        System.out.println();

        /**
         * Creates file named animalfile.bin, and writes Animal objects to file
         */
        FileOutputStream fileStream = new FileOutputStream("animalfile.bin");
        try (ObjectOutputStream objOutStream = new ObjectOutputStream(fileStream)) {
            objOutStream.writeObject(zoo);
            objOutStream.close();
            fileStream.close();
        }

        /**
         * Reads the animalfile.bin into a new ArrayList called zooFromFile
         */
        ArrayList<Animal> zooFromFile;
        try (
                FileInputStream fileInStream = new FileInputStream("animalfile.bin")) {
            try (ObjectInputStream objInStream = new ObjectInputStream(fileInStream)) {
                zooFromFile = (ArrayList<Animal>) objInStream.readObject();
                objInStream.close();
            }
            fileInStream.close();

        }

        userCont();

        animalIterator = zooFromFile.iterator();//uses iterator on zooFromFile arraylist

        System.out.println("These are the animal object contents AFTER being read from a file");
        System.out.println("-----------------------------------------------------------------");
        while (animalIterator.hasNext()) {
            Animal animal = animalIterator.next();
            System.out.println(animal.toString());
        }

    }

    /**
     * 
     */
    public static void userCont() {
        System.out.println("Press 'Enter' to continue\n");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }
}
