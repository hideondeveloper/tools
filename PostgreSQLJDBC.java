package utils.pg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PostgreSQLJDBC {

    public static void main(String args[]) {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://192.168.50.17:5432/postgres", "postgres", "123456");
            Statement statement = c.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users order by id asc");
            while (resultSet.next()) {
                System.out.print(resultSet.getInt("id") + "----");
                System.out.println(resultSet.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
}
