package org.example.db;

import com.google.inject.Singleton;
import lombok.SneakyThrows;
import java.sql.*;

@SuppressWarnings("CallToPrintStackTrace")
@Singleton
public class DatabaseService {

  private final String url = System.getProperty("jdbc.url");
  private final String username = System.getProperty("databaseUsername");
  private final String password = System.getProperty("databasePassword");

  @SneakyThrows
  public Connection getConnection() {
    return DriverManager.getConnection(url, username, password);
  }

  public void resetGiftReservation(String username) {
    String sql = "UPDATE gifts SET is_reserved = 'f' WHERE wish_id IN (SELECT id FROM wishlists WHERE user_id IN (SELECT id FROM users WHERE username = ?))";
    try (Connection conn = getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
      ps.setString(1, username);
      ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void deleteWishlistsForUser(String username) {
    String sql = "DELETE FROM wishlists WHERE user_id IN (SELECT id FROM users WHERE username = ?)";
    try (Connection conn = getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
      ps.setString(1, username);
      ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void deleteGiftsForUser(String username) {
    String sql = "DELETE FROM gifts WHERE wish_id IN (SELECT id FROM wishlists WHERE user_id IN (SELECT id FROM users WHERE username = ?))";
    try (Connection conn = getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
      ps.setString(1, username);
      ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
