package Client;

public class User {
    private String username;
    private String password;
    private int yearOfBirth;
    public User(String username,String password, int yearOfBirth){
        this.yearOfBirth=yearOfBirth;
        this.username=username;
        this.password=password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }
}
