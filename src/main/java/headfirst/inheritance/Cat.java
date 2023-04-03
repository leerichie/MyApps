package headfirst.inheritance;

public class Cat extends Feline implements Pet {

    public void makeNoise(){
        System.out.println("A cat likes to catch small prey, bring it home but they rarely eat it");
    }
    public void eat(){
        System.out.println("A cat eats tinned food and dry food at home");
    }

    @Override
    public void beFriendly() {
        System.out.println("I am a friendly Pet Cat");
        System.out.println("As a Cat I can implement Pet not like some other Animals");
    }

    @Override
    public void play() {
        System.out.println("I can play with you as your Pet Dog");
    }
}
