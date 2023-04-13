import java.util.*;
import java.util.stream.Collectors;

public class PracticeApp {

    public static void main(String[] args) {

        // Create an ArrayList of integers and fill it with 10 random numbers.
        // Then, sort the ArrayList in ascending order.
        ArrayList<Integer> tenNums = new ArrayList<>();
        Random ranList = new Random();
        for (int i = 0; i < 10; i++) {
            tenNums.add(ranList.nextInt(100));
        }
        String listRandomGeneratedNums = tenNums.stream().toList().toString();
        System.out.println(listRandomGeneratedNums);

        ArrayList<Integer> sortedNums = tenNums.stream()
                .sorted().collect(Collectors.toCollection(ArrayList::new));
        System.out.println(sortedNums);

        // Create a HashMap that maps names to ages.
        // Add at least 5 entries to the HashMap.
        // Then, loop through the HashMap and print out each name and age
        // in the format "Name: [name], Age: [age]".
        HashMap<String, Integer> hash = new HashMap<>();
        hash.put("Ash", 39);
        hash.put("Tom", 50);
        hash.put("Aga", 42);
        hash.put("Serwi", 26);
        hash.put("Kozi",34);

        System.out.printf("%-10s %-20s\n", "Name", "Age");
        System.out.println("--------------");
        for (Map.Entry<String, Integer> m : hash.entrySet()){
            System.out.printf("%-10s %-20d\n", m.getKey(), m.getValue());
        }

        // Create a TreeSet of Strings and add at least 5 strings to it. Then,
        // loop through the TreeSet and print out each string in alphabetical order.

        TreeSet<String> toOrder = new TreeSet<>();
        toOrder.add("Dick");
        toOrder.add("Derek");
        toOrder.add("Sandra");
        toOrder.add("Velicity");
        toOrder.add("Valentine");
        toOrder.add("Fiona");
        toOrder.add("Noel");
        toOrder.add("Nick");

        System.out.println(" ");

        System.out.printf("%-5s\n", "TreeSet");
        System.out.println("--------");
        int b = 1;
        for (String i : toOrder){
            System.out.println(b++ + " " + i);
        }

        // Create a LinkedList of integers and fill it with 10 random numbers.
        // Then, remove all even numbers from the LinkedList.

        LinkedList<Integer> linkedList = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            linkedList.add(random.nextInt(100)); // add random numbers to the list
        }

        System.out.println("Original List:");
        System.out.println(linkedList);

        // Remove all EVEN numbers from the list
        linkedList.removeIf(num -> num % 2 == 0);

        System.out.println("List after removing even numbers:");
        System.out.println(linkedList);


//        Create a HashSet of strings and add at least 5 strings to it.
//        Then, create a new ArrayList of strings and add all of the strings
//        from the HashSet to the ArrayList. Finally, sort the ArrayList
//        in descending order.

        LinkedHashSet<String> fiveStr = new LinkedHashSet<>();
        fiveStr.add("String one");
        fiveStr.add("String two");
        fiveStr.add("String three");
        fiveStr.add("String four");
        fiveStr.add("String five");

        // fiveStr added as constructor to ArrayList
        ArrayList<String> hashsetStringsToArraylist = new ArrayList<>(fiveStr);
        System.out.println(hashsetStringsToArraylist);

        // reverse order
        hashsetStringsToArraylist.sort(Collections.reverseOrder());
        System.out.println(hashsetStringsToArraylist);
    }
}