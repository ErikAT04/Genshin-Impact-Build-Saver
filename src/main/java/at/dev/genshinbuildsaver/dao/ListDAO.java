package at.dev.genshinbuildsaver.dao;

import at.dev.genshinbuildsaver.Objects.List;
import at.dev.genshinbuildsaver.Objects.UserStatic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListDAO {
    public static ArrayList<List> getLists(String uname){
        ArrayList<List> lists = new ArrayList<>();
        List list;
        try(Connection con = DataBaseManager.getConnection()){
            String sql = "SELECT * FROM MODEL WHERE USER = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, uname);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                list = new List();
                list.setId(rs.getInt(rs.getInt("ID")));
                list.setCharactersInList(CharacterDAO.getCharacters(rs.getInt("ID")));
                lists.add(list);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return lists;
    }
    public static int removeModel(int id){
        int rowsAffected = 0;
        try(Connection con = DataBaseManager.getConnection()){
            String sql = "DELETE FROM MODEL WHERE ID = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            rowsAffected = statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rowsAffected;
    }
    public static int setNewModel(String name){
        int rowsAffected = 0;
        try(Connection con = DataBaseManager.getConnection()){
            String sql = "INSERT INTO MODEL(NAME, USER) VALUES(?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, UserStatic.uname);
            rowsAffected = statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return rowsAffected;
    }
    public static int updateModelName(List model){
        int rowsAffected = 0;
        try(Connection con = DataBaseManager.getConnection()){
            String sql = "UPDATE MODEL SET NAME = ? WHERE ID = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, model.getName());
            statement.setInt(1, model.getId());
            rowsAffected = statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return rowsAffected;
    }
}
