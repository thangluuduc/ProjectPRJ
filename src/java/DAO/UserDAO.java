/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ThangLD
 */
public class UserDAO {

    public User getUser(String username, String password) {
        User user = new User();
        try {
            String sql = "SELECT [UserName],[Password],[Email] FROM [Account] where UserName = ? and Password = ?";
            PreparedStatement statement = ConnectSQL.getConnection().prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                user.setUserName(rs.getString("UserName"));
                user.setPassword(rs.getString("Password"));
                user.setEmail(rs.getString("Email"));
                return user;
            }
        } catch (SQLException ex) {
            return null;
        }
        return null;
    }

    public boolean createAccount(String username, String pass, String emaill) {
        try {
            String sql = "insert into Account values(?,?,?)";
            PreparedStatement statement = ConnectSQL.getConnection().prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, pass);
            statement.setString(3, emaill);
            return statement.execute();
        } catch (SQLException ex) {
        }
        return true;
    }

    public boolean changePassword(String username, String pass, String newPass) {
        try {
            String sql = "Update Account Set Password = ? where Username = ? and Password = ?";
            PreparedStatement statement = ConnectSQL.getConnection().prepareStatement(sql);
            statement.setString(1, newPass);
            statement.setString(2, username);
            statement.setString(3, pass);
            return statement.execute();
        } catch (Exception e) {
        }
        return true;
    }
    public User ForgetPassword(String username , String email){
        User user = new User();
        try {
            String sql = "SELECT Username, Password, email FROM Account where userName = ? and email = ?";
            PreparedStatement statement = ConnectSQL.getConnection().prepareStatement(sql);
            statement.setString(1,username);
            statement.setString(2,email);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                user.setUserName(rs.getString("UserName"));
                user.setPassword(rs.getString("Password"));
                user.setEmail(rs.getString("Email"));
                return user;
            }
            return null;
        } catch (SQLException ex) {
            return null;
        }
    }
}
