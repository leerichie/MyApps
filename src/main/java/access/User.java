package access;

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

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static List<User> userList = Arrays.asList(
            new User("Leeski", "leeski123"),
            new User("Ashbash", "ashbash123"),
            new User("Leeboy", "leeboy1234"),
            new User("Honeybum", "honeybum123"),
            new User("Serwi", "serwi123")
    );

}
