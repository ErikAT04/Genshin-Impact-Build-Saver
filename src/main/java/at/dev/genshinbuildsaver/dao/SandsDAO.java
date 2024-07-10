package at.dev.genshinbuildsaver.dao;

import at.dev.genshinbuildsaver.Objects.Crown;
import at.dev.genshinbuildsaver.Objects.Feather;
import at.dev.genshinbuildsaver.Objects.Sands;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SandsDAO {
    public static Sands getSands(int idchar) {
        Sands sands = null;

        try(Connection con = DataBaseManager.getConnection()){
            String sql = "SELECT * FROM FEATHER WHERE G_CHARACTER = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, idchar);
            ResultSet rs = statement.executeQuery();
            if (rs.next()){
                sands = new Sands();
                sands.setId(rs.getInt("ID"));
                sands.setLvl(rs.getInt("LVL"));
                sands.setMainStat(rs.getString("STATMAIN"));
                sands.setLvlMainStat(rs.getDouble("LVLMAIN"));
                sands.setSubStat1(rs.getString("STAT1"));
                sands.setLvlSubStat1(rs.getDouble("LVL1"));
                sands.setSubStat2(rs.getString("STAT2"));
                sands.setLvlSubStat2(rs.getDouble("LVL2"));
                sands.setSubStat3(rs.getString("STAT3"));
                sands.setLvlSubStat3(rs.getDouble("LVL3"));
                sands.setSubStat4(rs.getString("STAT4"));
                sands.setLvlSubStat4(rs.getDouble("LVL4"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return sands;
    }
    public static int createNewSands(int idChar){
        int rowsAffected = 0;

        try(Connection con = DataBaseManager.getConnection()){
            String sql = "INSERT INTO SANDS(G_CHARACTER, NAME, LVL, STATMAIN, LVLMAIN, STAT1, LVL1, STAT2, LVL2, STAT3, LVL3, STAT4, LVL4) VALUES (?, '(NONE)', 0, '(NONE)', 0, '(NONE)', 0, '(NONE)', 0, '(NONE)', 0, '(NONE)', 0)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, idChar);
            rowsAffected = statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return rowsAffected;
    }
    public static int updateSands(Sands sands){
        int rowsAffected = 0;

        try(Connection con = DataBaseManager.getConnection()){
            String sql = "UPDATE SANDS SET NAME = ?, LVL = ?, STATMAIN = ?, LVLMAIN = ?, STAT1 = ?, LVL1 = ?, STAT2 = ?, LVL2 = ?, STAT3 = ?, LVL3 = ?, STAT4 = ?, LVL4 = ? WHERE ID = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, sands.getName());
            statement.setInt(2, sands.getLvl());
            statement.setString(3, sands.getMainStat());
            statement.setDouble(4, sands.getLvlMainStat());
            statement.setString(5, sands.getSubStat1());
            statement.setDouble(6, sands.getLvlSubStat1());
            statement.setString(7, sands.getSubStat2());
            statement.setDouble(8, sands.getLvlSubStat2());
            statement.setString(9, sands.getSubStat3());
            statement.setDouble(10, sands.getLvlSubStat3());
            statement.setString(11, sands.getSubStat4());
            statement.setDouble(12, sands.getLvlSubStat4());
            statement.setInt(13, sands.getId());
            rowsAffected = statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return rowsAffected;
    }
}
