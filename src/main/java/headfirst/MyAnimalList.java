package headfirst;

import headfirst.inheritance.*;

import java.awt.*;
import java.util.ArrayList;

public class MyAnimalList {
    private Animal[] animals = new Animal[5];
    private int nextIndex = 0;

    public void add(Animal a){
        if (nextIndex < animals.length){
            animals[nextIndex] = a;
            System.out.println("Animal added at index " + nextIndex);
            nextIndex++;
        }
    }

    public static void main(String[] args) {

        ArrayList<Dog> myDogArrayList = new ArrayList<>();
        Dog aDog = new Dog();
        myDogArrayList.add(aDog);
        Dog d = myDogArrayList.get(0);
        System.out.println(d.toString());

        System.out.println(" ");

        MyAnimalList animalList = new MyAnimalList();
        Dog dog = new Dog();
        Cat cat = new Cat();
        Hippo hippo = new Hippo();
        animalList.add(dog);
        animalList.add(cat);
        animalList.add(hippo);
        // Object super-superclass above Animal
        if(cat.equals(dog)){
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        System.out.println(dog.getClass());

            // implemented Pet
        dog.beFriendly();
        dog.makeNoise();
        cat.play();
        // not implemented - No access to interface Pet
        hippo.makeNoise();

        Duck myDuck = new Duck();
        String test = myDuck.makeSound("Squeak");
        System.out.println(test);

        Duck duckSize = new Duck(4);
        Duck duckNoSize = new Duck(0);
        Duck duckColor = new Duck("Hello", Color.cyan);
    }
}
