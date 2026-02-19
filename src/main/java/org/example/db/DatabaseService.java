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

  private void executeUpdate(String sql) {
    try (Connection conn = getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
      ps.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void resetGiftReservation(String giftId) {
    executeUpdate(String.format("UPDATE gifts SET is_reserved = 'f' WHERE id = '%s'", giftId));
  }

  public void deleteGiftsByWishlistId(String wishlistId) {
    executeUpdate(String.format("DELETE FROM gifts WHERE wish_id = '%s'", wishlistId));
  }

  public void deleteWishlistsByUserId(String userId) {
    executeUpdate(String.format("DELETE FROM wishlists WHERE user_id = '%s'", userId));
  }

  private String executeQuery(String sql) {
    try (Connection conn = getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
      try (ResultSet rs = ps.executeQuery()) {
        if (rs.next()) {
          return rs.getString("id");
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return null;
  }

  public String getUserIdByName(String name) {
    return executeQuery(String.format("SELECT id FROM users WHERE username = '%s'", name));
  }

  public String getWishlistIdByUserId(String userId) {
    return executeQuery(String.format("SELECT id FROM wishlists WHERE user_id = '%s'", userId));
  }

  public String getGiftIdByWishlistId(String wishlistId) {
    return executeQuery(String.format("SELECT id FROM gifts WHERE wish_id = '%s'", wishlistId));
  }
}
