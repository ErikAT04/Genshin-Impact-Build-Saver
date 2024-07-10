package at.dev.genshinbuildsaver.dao;

import at.dev.genshinbuildsaver.Objects.Stats;

import java.sql.*;

public class StatsDAO {
    public static Stats getStats(int idchar) {
        Stats stats = null;

        try(Connection con = DataBaseManager.getConnection()){
            String sql = "SELECT * FROM STATS WHERE G_CHARACTER = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, idchar);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                stats = new Stats();
                stats.setId(rs.getInt("ID"));
                stats.setLvlNormal(rs.getInt("LVLNORMAL"));
                stats.setLvlElemental(rs.getInt("LVLELEMENTAL"));
                stats.setLvlUltimate(rs.getInt("LVLULTIMATE"));
                stats.setCons(rs.getInt("CONS"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return stats;
    }
    public static int createNewStats(int idChar){
        int rowsAffected = 0;
        try(Connection con = DataBaseManager.getConnection()){
            String sql = "INSERT INTO STATS(LVLNORMAL, LVLELEMENTAL, LVLULTIMATE, CONS, G_CHARACTER) VALUES (1, 1, 1, 0, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, idChar);
            rowsAffected = statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return rowsAffected;
    }
    public static int updateStats(Stats stats){
        int rowsAffected = 0;
        try(Connection con = DataBaseManager.getConnection()){
            String sql = "UPDATE STATS SET LVLNORMAL=?, LVLELEMENTAL=?, LVLULTIMATE=?, CONS=?, WHERE ID=?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, stats.getLvlNormal());
            statement.setInt(2, stats.getLvlElemental());
            statement.setInt(3, stats.getLvlUltimate());
            statement.setInt(4, stats.getCons());
            statement.setInt(5, stats.getId());
            rowsAffected = statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return rowsAffected;
    }
}
