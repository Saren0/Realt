package by.gsu.lab.beans;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String username;
    private String pass;
    private int root;

    public User(int id, String username, String pass, int root) {
        this.id = id;
        this.username = username;
        this.pass = pass;
        this.root = root;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPass() {
        return pass;
    }

    public int getRoot() {
        return root;
    }

    @Override
    public String toString() {
        return id + ";" + username + ";" + pass + ";" + root;
    }

    public List<String> getUsersList(){
        List<String> user = new ArrayList<>();
        user.add(String.valueOf(getId()));
        user.add(getUsername());
        user.add(getPass());
        user.add(String.valueOf(getRoot()));
        return user;
    }
}
