package model;

public class UserInfo {
    private String username;
    private String passweord;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassweord() {
        return passweord;
    }

    public void setPassweord(String passweord) {
        this.passweord = passweord;
    }

    public UserInfo(String username, String passweord) {
        this.username = username;
        this.passweord = passweord;
    }
}
