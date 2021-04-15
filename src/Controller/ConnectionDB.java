package Controller;
import java.sql.*;

/**
 *
 * @author luuhuy
 */
public class ConnectionDB {
    public static Connection conn = null;

    public ConnectionDB() {
        try{
            String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=ManageCafe";
            String user = "sa";
            String pass = "123";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url,user,pass);
        }catch(Exception ex){
            System.out.println("Disconected ");
        }
    }
    
    public Connection getConnectDB(){
        try{
            String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=ManageCafe";
            String user = "sa";
            String pass = "123";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url,user,pass);
            System.out.println("Connected");
        }catch(Exception ex){
            System.out.println("Disconected ");
        }
        return conn;
    }
}
