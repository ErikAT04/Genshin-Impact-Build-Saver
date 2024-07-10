package at.dev.genshinbuildsaver.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseManager{
    public static Connection getConnection(){
        Connection con = null;
        try {
            String path = "jdbc:mysql://localhost:3306/gimpact";
            String uname = "root";
            String passwd = "IESRibera23";

            con = DriverManager.getConnection(path, uname, passwd);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return con;
    }
}
