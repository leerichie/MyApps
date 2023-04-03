package headfirst.inheritance;

public class Dog extends Animal implements Pet {

    public void makeNoise(){
//        super.makeNoise();
        System.out.println("A Dog barks");
    }
    public void eat(){
        System.out.println("A Dog eats tinned food, dry food and basically any crap laying around");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "picture=" + picture +
                ", food=" + food +
                ", hunger=" + hunger +
                ", boundaries=" + boundaries +
                ", location=" + location +
                '}';
    }

    @Override
    public void beFriendly() {
        System.out.println("I am a friendly Pet Dog");
        System.out.println("As a Dog I can implement Pet not like some other Animals");
    }

    @Override
    public void play() {
        System.out.println("I can play with you as your Pet Dog");
    }
}
