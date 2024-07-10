package at.dev.genshinbuildsaver.dao;

import at.dev.genshinbuildsaver.Objects.Crown;
import at.dev.genshinbuildsaver.Objects.Feather;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrownDAO {
    public static Crown getCrown(int idchar) {
        Crown crown = null;

        try(Connection con = DataBaseManager.getConnection()){
            String sql = "SELECT * FROM FEATHER WHERE G_CHARACTER = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, idchar);
            ResultSet rs = statement.executeQuery();
            if (rs.next()){
                crown = new Crown();
                crown.setId(rs.getInt("ID"));
                crown.setLvl(rs.getInt("LVL"));
                crown.setMainStat(rs.getString("STATMAIN"));
                crown.setLvlMainStat(rs.getDouble("LVLMAIN"));
                crown.setSubStat1(rs.getString("STAT1"));
                crown.setLvlSubStat1(rs.getDouble("LVL1"));
                crown.setSubStat2(rs.getString("STAT2"));
                crown.setLvlSubStat2(rs.getDouble("LVL2"));
                crown.setSubStat3(rs.getString("STAT3"));
                crown.setLvlSubStat3(rs.getDouble("LVL3"));
                crown.setSubStat4(rs.getString("STAT4"));
                crown.setLvlSubStat4(rs.getDouble("LVL4"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return crown;
    }
    public static int createNewCrown(int idChar){
        int rowsAffected = 0;

        try(Connection con = DataBaseManager.getConnection()){
            String sql = "INSERT INTO CROWN(G_CHARACTER, NAME, LVL, STATMAIN, LVLMAIN, STAT1, LVL1, STAT2, LVL2, STAT3, LVL3, STAT4, LVL4) VALUES (?, '(NONE)', 0, '(NONE)', 0, '(NONE)', 0, '(NONE)', 0, '(NONE)', 0, '(NONE)', 0)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, idChar);
            rowsAffected = statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        return rowsAffected;
    }
}
