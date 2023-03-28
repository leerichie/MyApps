package headfirst;

import inheritance.Dog;

public class MyDogList {
    private Dog [] dogs = new Dog[5];
    private int nextIndex = 0;

    public void add(Dog d){
        if (nextIndex < dogs.length){
            dogs[nextIndex] = d;
            System.out.println("Dog added at index " + nextIndex);
            nextIndex++;
        }
    }

    public static void main(String[] args) {
        MyDogList m = new MyDogList();
        System.out.println(m.dogs);
    }
}
