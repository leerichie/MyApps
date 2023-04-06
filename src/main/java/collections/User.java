//package collections;
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class User {
//    private String name;
//    private String password;
//    private String email;
//
//    public User() {
//    }
//
//    public User(String name) {
//        this.name = name;
//    }
//
//    public User(String name, String password, String email) {
//        this.name = name;
//        this.password = password;
//        this.email = email;
//    }
//
//    public User(String john, String password123) {
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//    private static boolean isNotSam(String name){
//        return !name.equals("Ash");
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "name='" + name + '\'' +
//                ", password='" + password + '\'' +
//                ", email='" + email + '\'' +
//                '}';
//    }
//
//    public static void main(String[] args) {
////        User user = new User();
////        user.setName("lee");
////        user.setEmail("leer@mail.com");
////        user.setPassword("pass123");
//
//        List<String> names = Arrays.asList("Ash", "Lee", "Basher");
//        Map<String, String> userL = new HashMap<>();
//        userL.put("login", "Ash");
//        userL.put("login1", "Lee");
//        userL.put("login2", "Basher");
//
//        System.out.println("Imperative Style");
//
//        for (String name : names){
//            if(!name.equals("Ash")){
//                User user1 = new User(name);
//                System.out.println(user1);
//            }
//        }
//
//        System.out.println("Functional Style");
//
//        names.stream()
//                .filter(User::isNotSam)
//                .map(User::new)
//                .forEach(System.out::println);
//
//        List<User> userList =
//        names.stream()
//                .filter(User::isNotSam)
//                .map(User::new)
//                .toList();
//        System.out.println(userList);
//    }
//
//}
