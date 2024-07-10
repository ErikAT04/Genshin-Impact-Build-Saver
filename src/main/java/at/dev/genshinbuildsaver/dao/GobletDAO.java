package at.dev.genshinbuildsaver.dao;

import at.dev.genshinbuildsaver.Objects.Crown;
import at.dev.genshinbuildsaver.Objects.Feather;
import at.dev.genshinbuildsaver.Objects.Goblet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GobletDAO {
    public static Goblet getGoblet(int idchar) {
        Goblet goblet = null;

        try(Connection con = DataBaseManager.getConnection()){
            String sql = "SELECT * FROM FEATHER WHERE G_CHARACTER = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, idchar);
            ResultSet rs = statement.executeQuery();
            if (rs.next()){
                goblet = new Goblet();
                goblet.setId(rs.getInt("ID"));
                goblet.setLvl(rs.getInt("LVL"));
                goblet.setMainStat(rs.getString("STATMAIN"));
                goblet.setLvlMainStat(rs.getDouble("LVLMAIN"));
                goblet.setSubStat1(rs.getString("STAT1"));
                goblet.setLvlSubStat1(rs.getDouble("LVL1"));
                goblet.setSubStat2(rs.getString("STAT2"));
                goblet.setLvlSubStat2(rs.getDouble("LVL2"));
                goblet.setSubStat3(rs.getString("STAT3"));
                goblet.setLvlSubStat3(rs.getDouble("LVL3"));
                goblet.setSubStat4(rs.getString("STAT4"));
                goblet.setLvlSubStat4(rs.getDouble("LVL4"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return goblet;
    }
    public static int createNewGoblet(int idChar){
        int rowsAffected = 0;

        try(Connection con = DataBaseManager.getConnection()){
            String sql = "INSERT INTO GOBLET(G_CHARACTER, NAME, LVL, STATMAIN, LVLMAIN, STAT1, LVL1, STAT2, LVL2, STAT3, LVL3, STAT4, LVL4) VALUES (?, '(NONE)', 0, '(NONE)', 0, '(NONE)', 0, '(NONE)', 0, '(NONE)', 0, '(NONE)', 0)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, idChar);
            rowsAffected = statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return rowsAffected;
    }
    public static int updateGoblet(Goblet goblet){
        int rowsAffected = 0;

        try(Connection con = DataBaseManager.getConnection()){
            String sql = "UPDATE GOBLET SET NAME = ?, LVL = ?, STATMAIN = ?, LVLMAIN = ?, STAT1 = ?, LVL1 = ?, STAT2 = ?, LVL2 = ?, STAT3 = ?, LVL3 = ?, STAT4 = ?, LVL4 = ? WHERE ID = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, goblet.getName());
            statement.setInt(2, goblet.getLvl());
            statement.setString(3, goblet.getMainStat());
            statement.setDouble(4, goblet.getLvlMainStat());
            statement.setString(5, goblet.getSubStat1());
            statement.setDouble(6, goblet.getLvlSubStat1());
            statement.setString(7, goblet.getSubStat2());
            statement.setDouble(8, goblet.getLvlSubStat2());
            statement.setString(9, goblet.getSubStat3());
            statement.setDouble(10, goblet.getLvlSubStat3());
            statement.setString(11, goblet.getSubStat4());
            statement.setDouble(12, goblet.getLvlSubStat4());
            statement.setInt(13, goblet.getId());
            rowsAffected = statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return rowsAffected;
    }
}
