import com.google.inject.Inject;
import org.example.components.NavigationBar;
import org.example.extensions.AndroidExtension;
import org.example.pages.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(AndroidExtension.class)
public class UserGiftReservationTest {

  @Inject
  private LoginPage loginPage;
  @Inject
  private NavigationBar navigationBar;
  @Inject
  private UsersPage usersPage;
  @Inject
  private UsersWishlistsPage usersWishlistsPage;
  @Inject
  private UsersWishesPage usersWishesPage;
  @Inject
  private FilterPage filterPage;

  @Test
  void reserveUsersGift() {
    loginPage
        .login("Nika4", "0987654321");
    navigationBar
        .tapUsersMenu();
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
