package at.dev.genshinbuildsaver.dao;

import at.dev.genshinbuildsaver.Objects.Character;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CharacterDAO {
    public static ArrayList<Character> getCharacters(int id) {
        Character character;
        ArrayList<Character> characters = new ArrayList<>();
        try(Connection con = DataBaseManager.getConnection()){
            String sql = "SELECT * FROM G_CHARACTER WHERE MODEL = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                character = new Character();
                int idchar = rs.getInt("ID");
                character.setId(idchar);
                character.setName(rs.getString("NAME"));
                character.setFlower(FlowerDAO.getFlower(idchar));
                character.setFeather(FeatherDAO.getFeather(idchar));
                character.setSands(SandsDAO.getSands(idchar));
                character.setGoblet(GobletDAO.getGoblet(idchar));
                character.setCrown(CrownDAO.getCrown(idchar));
                character.setWeapon(WeaponDAO.getWeapon(idchar));
                character.setStats(StatsDAO.getStats(idchar));
                characters.add(character);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return characters;
    }
    public static int deleteCharacter(int idchar){
        int rowsAffected = 0;
        try(Connection con = DataBaseManager.getConnection()){
            String sql = "DELETE FROM G_CHARACTER WHERE ID = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, idchar);
            rowsAffected = statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return rowsAffected;
    }
}
