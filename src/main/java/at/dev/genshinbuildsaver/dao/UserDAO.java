package at.dev.genshinbuildsaver.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public static boolean checkuname(String uname) {
        boolean isHere = false;
        try(Connection con = DataBaseManager.getConnection()){
            String sql = "SELECT * FROM USER WHERE UNAME = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, uname);
            ResultSet rs = statement.executeQuery();
            return rs.next(); //Returns false if it hasn't found anything
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return isHere;
    }
    public static boolean chechpasswd(String uname, String passwd){
        boolean isHere = false;
        try(Connection con = DataBaseManager.getConnection()){
            String sql = "SELECT * FROM USER WHERE UNAME = ? AND PASSWD = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, uname);
            statement.setString(2, passwd);
            ResultSet rs = statement.executeQuery();
            return rs.next(); //Returns false if it hasn't found anything
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return isHere;
    }
    public static int register(String uname, String passwd){
        int rows=0;
        try(Connection con = DataBaseManager.getConnection()){
            String sql = "INSERT INTO USER(UNAME, PASSWD) VALUES(?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, uname);
            statement.setString(2, passwd);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        };
        return rows;
    }
    public static int delete(String uname){
        int rows=0;
        try(Connection con = DataBaseManager.getConnection()){
            String sql = "DELETE FROM USER WHERE UNAME = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, uname);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        };
        return rows;
    }
}
