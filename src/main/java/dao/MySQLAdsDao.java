package dao;

import java.sql.*;

import com.mysql.cj.jdbc.Driver;
import models.Ad;
import models.Ads;
import util.Config;

import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {

    private static Connection connection;

    public MySQLAdsDao(Config config) throws SQLException {
        DriverManager.registerDriver(new Driver());
        connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPassword()
        );

    }



    public List<Ad> all() {
        List<Ad> products = new ArrayList<>();
        String selectQuery = "SELECT * FROM ads";

        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(selectQuery);

            while (rs.next()) {
                products.add(new Ad(rs.getLong("user_id"), rs.getString("Title"), rs.getString("Description")));
                System.out.println("  id: " + rs.getLong("user_id"));
                System.out.println("  Title: " + rs.getString("title"));
                System.out.println("  Description: " + rs.getString("description"));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();;
        }

        return products;
    }

    @Override
    public Long insert(Ad ad) {



        try {


            long userId = ad.getUserId();

            String title = ad.getTitle();

            System.out.println(title);

            String description = ad.getDescription();

            String insertStmt = String.format("INSERT INTO ads (user_id, title, description) VALUES ('%d', '%s', '%s');", userId, title, description);

            System.out.println(insertStmt);

            Statement stmt = connection.createStatement();
            stmt.executeUpdate(insertStmt, stmt.RETURN_GENERATED_KEYS);

            ResultSet rs = stmt.getGeneratedKeys();
            long blank = 0;
            if (rs.next()) {
                System.out.println("Inserted a new record! New id: " + rs.getLong(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return 0L;
    }



}
