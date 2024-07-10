package at.dev.genshinbuildsaver.dao;

import at.dev.genshinbuildsaver.Objects.Crown;
import at.dev.genshinbuildsaver.Objects.Feather;
import at.dev.genshinbuildsaver.Objects.Flower;

import java.sql.*;

public class FlowerDAO {
    public static Flower getFlower(int idchar) {
        Flower flower = null;

        try(Connection con = DataBaseManager.getConnection()){
            String sql = "SELECT * FROM FLOWER WHERE G_CHARACTER = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, idchar);
            ResultSet rs = statement.executeQuery();
            if (rs.next()){
                flower = new Flower();
                flower.setId(rs.getInt("ID"));
                flower.setLvl(rs.getInt("LVL"));
                flower.setMainStat(rs.getString("STATMAIN"));
                flower.setLvlMainStat(rs.getDouble("LVLMAIN"));
                flower.setSubStat1(rs.getString("STAT1"));
                flower.setLvlSubStat1(rs.getDouble("LVL1"));
                flower.setSubStat2(rs.getString("STAT2"));
                flower.setLvlSubStat2(rs.getDouble("LVL2"));
                flower.setSubStat3(rs.getString("STAT3"));
                flower.setLvlSubStat3(rs.getDouble("LVL3"));
                flower.setSubStat4(rs.getString("STAT4"));
                flower.setLvlSubStat4(rs.getDouble("LVL4"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return flower;
    }
    public static int createNewFlower(int idChar){
        int rowsAffected = 0;

        try(Connection con = DataBaseManager.getConnection()){
            String sql = "INSERT INTO FLOWER(G_CHARACTER, NAME, LVL, STATMAIN, LVLMAIN, STAT1, LVL1, STAT2, LVL2, STAT3, LVL3, STAT4, LVL4) VALUES (?, '(NONE)', 0, '(NONE)', 0, '(NONE)', 0, '(NONE)', 0, '(NONE)', 0, '(NONE)', 0)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, idChar);
            rowsAffected = statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return rowsAffected;
    }
    public static int updateFlower(Flower flower){
        int rowsAffected = 0;

        try(Connection con = DataBaseManager.getConnection()){
            String sql = "UPDATE FLOWER SET NAME = ?, LVL = ?, STATMAIN = ?, LVLMAIN = ?, STAT1 = ?, LVL1 = ?, STAT2 = ?, LVL2 = ?, STAT3 = ?, LVL3 = ?, STAT4 = ?, LVL4 = ? WHERE ID = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, flower.getName());
            statement.setInt(2, flower.getLvl());
            statement.setString(3, flower.getMainStat());
            statement.setDouble(4, flower.getLvlMainStat());
            statement.setString(5, flower.getSubStat1());
            statement.setDouble(6, flower.getLvlSubStat1());
            statement.setString(7, flower.getSubStat2());
            statement.setDouble(8, flower.getLvlSubStat2());
            statement.setString(9, flower.getSubStat3());
            statement.setDouble(10, flower.getLvlSubStat3());
            statement.setString(11, flower.getSubStat4());
            statement.setDouble(12, flower.getLvlSubStat4());
            statement.setInt(13, flower.getId());
            rowsAffected = statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return rowsAffected;
    }
}
