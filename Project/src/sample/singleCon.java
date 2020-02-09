
package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class singleCon {
    private static singleCon Instanct = new singleCon();
    private singleCon(){ }
    public static Connection getConnection()throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return  DriverManager.getConnection("jdbc:mysql://mysql5021.site4now.net/db_a54c32_moltaxi", "a54c32_moltaxi", "12345678");
    }
}
