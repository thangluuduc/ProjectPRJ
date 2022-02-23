/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ThangLD
 */
public class User {
    private String userName;
    private String password;
    private String Email;

    public User() {
    }

    public User(String userName, String password, String Email) {
        this.userName = userName;
        this.password = password;
        this.Email = Email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String toString() {
        return "User{ userName=" + userName + ", password=" + password + ", EmailPhone=" + Email + '}';
    }
}
