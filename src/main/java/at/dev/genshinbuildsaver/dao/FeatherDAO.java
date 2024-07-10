package at.dev.genshinbuildsaver.dao;

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
}
