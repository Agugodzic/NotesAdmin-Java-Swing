package Data;

import java.sql.Connection;
import java.sql.DriverManager;

public class Data {
    public static Data instance;
    private static String user;
    private static String password;
    private static String dbname;
    private static String host;
    private static int port;
    public static Connection connection;

    public Data(String User, String Password, String Dbname ,String Host, int Port){
      user = User;
      password = Password;
      dbname = Dbname;
      host = Host;
      port = Port;
    }

    public static Data getInstance() {
        return instance;
    }

    public static Connection getConnection() {
        return connection;
    }

    public boolean DBconnect(){
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://" + host + ":" + port + "/" + dbname,user,password);
            System.out.println("Conexion exitosa.");
            return true;
        }catch(Exception e){
            System.out.println("Error: " + e);
            return false;
        }
    }

}
