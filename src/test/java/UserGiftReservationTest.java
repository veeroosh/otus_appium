import com.google.inject.Inject;
import org.example.db.DatabaseService;
import org.example.extensions.AndroidExtension;
import org.example.pages.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@SuppressWarnings("unused")
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

  @Test
  void reserveUsersGift() {
    dbService.resetGiftReservation("Nika2");
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
