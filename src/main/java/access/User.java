package access;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    private String userName;
    private String password;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public static List<User> userList = new ArrayList<>(Arrays.asList(
            new User("Leeski", "leeski123"),
            new User("Honeybum", "honeybum123"),
            new User("Serwi", "serwi123")
    ));
}
