package inheritance;

public class MainApp {
    public static void main(String[] args) {
        Wolf w = new Wolf();
        // wolf class
        w.makeNoise();
        // animal class
        w.roam();
        // wolf class
        w.eat();
        // animal class
        w.sleep();

        Animal animal = new Wolf();
        System.out.println(animal.boundaries = 2);

        Animal animal1 = new Hippo();
        animal1.makeNoise();
        Hippo hippo = new Hippo();
        hippo.makeNoise();
    }
}
