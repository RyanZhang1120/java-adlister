package dao;

import models.Ads;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {

    private Connection connection;

    public MySQLAdsDao(Config config) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = config.getUrl();
            String username = config.getUsername();
            String password = config.getPassword();
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }
    }

    @Override
    public List<Ad> all() {
        List<Ad> ads = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM ads")) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Ad ad = new Ad(
                        resultSet.getLong("id"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getDouble("price"),
                        resultSet.getLong("user_id")
                );
                ads.add(ad);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads", e);
        }
        return ads;
    }

    @Override
    public Long insert(Ad ad) {
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO ads (title, description, price, user_id) VALUES (?, ?, ?, ?)")) {
            statement.setString(1, ad.getTitle());
            statement.setString(2, ad.getDescription());
            statement.setDouble(3, ad.getPrice());
            statement.setLong(4, ad.getUserId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting new ad", e);
        }
        return null;
    }
}
