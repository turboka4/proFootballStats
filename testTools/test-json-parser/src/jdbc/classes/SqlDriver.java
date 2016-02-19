package jdbc.classes;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqlDriver {

    private static Connection connection;

    public static Connection getConnection(){
        try{
            if (connection == null){
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/FootballStatsDev", "postgres", "admin");
                return connection;
            } else
                return connection;
        }
        catch (Exception ex){
            System.out.println("Can't establish connection: " + ex.getMessage());
        }
        return null;
    }

    public static void closeConnection() {
        try{
            if (connection != null)
                connection.close();
        }
        catch (Exception ex){
            System.out.println("Connection can't be closed: " + ex.getMessage());
        }
    }
}
