import com.google.inject.Inject;
import org.example.db.DatabaseService;
import org.example.extensions.AndroidExtension;
import org.example.pages.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(AndroidExtension.class)
public class UserGiftReservationTest {

  @Inject
  private LoginPage loginPage;
  @Inject
  private UsersPage usersPage;
  @Inject
  private UsersWishlistsPage usersWishlistsPage;
  @Inject
  private UsersWishesPage usersWishesPage;
  @Inject
  private FilterPage filterPage;
  @Inject
  private DatabaseService dbService;

  @BeforeEach
  void resetData() {
    String userId = dbService.getUserIdByName("Nika2");
    String wishlistId = dbService.getWishlistIdByUserId(userId);
    String giftId = dbService.getGiftIdByWishlistId(wishlistId);
    dbService.resetGiftReservation(giftId);
  }

  @Test
  void reserveUsersGift() {
    loginPage
        .login("Nika4", "0987654321")
        .tapUsersMenu()
        .openFilter();
    filterPage
        .searchForUser("Nika2");
    usersPage
        .clickUser(1);
    usersWishlistsPage
        .tapWishlist(1);
    usersWishesPage
        .reserveGift()
        .checkGiftIsReserved();
  }
}
