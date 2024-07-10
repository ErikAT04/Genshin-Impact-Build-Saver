package at.dev.genshinbuildsaver.dao;

import at.dev.genshinbuildsaver.Objects.Crown;
import at.dev.genshinbuildsaver.Objects.Feather;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FeatherDAO {
    public static Feather getFeather(int idchar) {
        Feather feather = null;

        try(Connection con = DataBaseManager.getConnection()){
            String sql = "SELECT * FROM FEATHER WHERE G_CHARACTER = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, idchar);
            ResultSet rs = statement.executeQuery();
            if (rs.next()){
                feather = new Feather();
                feather.setId(rs.getInt("ID"));
                feather.setLvl(rs.getInt("LVL"));
                feather.setMainStat(rs.getString("STATMAIN"));
                feather.setLvlMainStat(rs.getDouble("LVLMAIN"));
                feather.setSubStat1(rs.getString("STAT1"));
                feather.setLvlSubStat1(rs.getDouble("LVL1"));
                feather.setSubStat2(rs.getString("STAT2"));
                feather.setLvlSubStat2(rs.getDouble("LVL2"));
                feather.setSubStat3(rs.getString("STAT3"));
                feather.setLvlSubStat3(rs.getDouble("LVL3"));
                feather.setSubStat4(rs.getString("STAT4"));
                feather.setLvlSubStat4(rs.getDouble("LVL4"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return feather;
    }
    public static int createNewFeather(int idChar){
        int rowsAffected = 0;

        try(Connection con = DataBaseManager.getConnection()){
            String sql = "INSERT INTO FEATHER(G_CHARACTER, NAME, LVL, STATMAIN, LVLMAIN, STAT1, LVL1, STAT2, LVL2, STAT3, LVL3, STAT4, LVL4) VALUES (?, '(NONE)', 0, '(NONE)', 0, '(NONE)', 0, '(NONE)', 0, '(NONE)', 0, '(NONE)', 0)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, idChar);
            rowsAffected = statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return rowsAffected;
    }
    public static int updateFeather(Feather feather){
        int rowsAffected = 0;

        try(Connection con = DataBaseManager.getConnection()){
            String sql = "UPDATE FEATHER SET NAME = ?, LVL = ?, STATMAIN = ?, LVLMAIN = ?, STAT1 = ?, LVL1 = ?, STAT2 = ?, LVL2 = ?, STAT3 = ?, LVL3 = ?, STAT4 = ?, LVL4 = ? WHERE ID = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, feather.getName());
            statement.setInt(2, feather.getLvl());
            statement.setString(3, feather.getMainStat());
            statement.setDouble(4, feather.getLvlMainStat());
            statement.setString(5, feather.getSubStat1());
            statement.setDouble(6, feather.getLvlSubStat1());
            statement.setString(7, feather.getSubStat2());
            statement.setDouble(8, feather.getLvlSubStat2());
            statement.setString(9, feather.getSubStat3());
            statement.setDouble(10, feather.getLvlSubStat3());
            statement.setString(11, feather.getSubStat4());
            statement.setDouble(12, feather.getLvlSubStat4());
            statement.setInt(13, feather.getId());
            rowsAffected = statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return rowsAffected;
    }
}
