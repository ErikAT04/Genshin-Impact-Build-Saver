package at.dev.genshinbuildsaver.dao;

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
}
