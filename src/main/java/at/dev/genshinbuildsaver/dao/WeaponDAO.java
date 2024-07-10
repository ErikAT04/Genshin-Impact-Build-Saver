package at.dev.genshinbuildsaver.dao;

import at.dev.genshinbuildsaver.Objects.Weapon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WeaponDAO {
    public static Weapon getWeapon(int idchar) {
        Weapon weapon = null;

        try(Connection con = DataBaseManager.getConnection()){
            String sql = "SELECT * FROM WEAPON WHERE G_CHARACTER = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, idchar);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                weapon = new Weapon();
                weapon.setId(rs.getInt("ID"));
                weapon.setLvl(rs.getInt("LVL"));
                weapon.setName(rs.getString("NAME"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return weapon;
    }
    public static int createWeaponForCharacter(int idchar){
        int rowsAffected = 0;
        try(Connection con = DataBaseManager.getConnection()){
            String sql = "INSERT INTO WEAPON(G_CHARACTER, NAME, LVL) VALUES(?, '(NONE)', 0)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, idchar);
            rowsAffected = statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return rowsAffected;
    }
    public static int updateWeapon(Weapon weapon){
        int rowsAffected = 0;

        try(Connection con = DataBaseManager.getConnection()){
            String sql = "UPDATE WEAPON SET NAME=?, LVL=? WHERE ID=?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, weapon.getName());
            statement.setInt(2, weapon.getLvl());
            statement.setInt(3, weapon.getId());
            rowsAffected = statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return rowsAffected;
    }
}
