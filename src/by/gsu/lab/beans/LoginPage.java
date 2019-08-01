package by.gsu.lab.beans;

public class LoginPage {
    private int id;
    private String username;
    private String pass;
    private int root;

    public LoginPage(int id, String username, String pass, int root) {
        this.id = id;
        this.username = username;
        this.pass = pass;
        this.root = root;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getRoot() {
        return root;
    }

    public void setRoot(int root) {
        this.root = root;
    }
}
