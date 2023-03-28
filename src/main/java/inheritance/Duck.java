package inheritance;

import java.awt.*;

public class Duck {
    private String whatSound;
    private int numOfSounds;
    private int size;
    private Color c;

    // constructor 1
    public Duck(String text, Color color){
        color.getBlue();

    }
    // constructor 2
    public Duck(int newSize){
        size = newSize;
        System.out.println("Size is " + size);
    }
    // constructor 3
    public Duck() {
        System.out.println("Quack");
    }
    // method
    public String makeSound(String sound){
        setWhatSound("What's the sound?");
        return getWhatSound() + " " + sound;
    }
    // method
    public String getWhatSound() {
        return whatSound;
    }

    public void setWhatSound(String whatSound) {
        this.whatSound = whatSound;
    }

    public int getNumOfSounds() {
        return numOfSounds;
    }

    public void setNumOfSounds(int numOfSounds) {
        this.numOfSounds = numOfSounds;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Color getC() {
        return c;
    }
}
