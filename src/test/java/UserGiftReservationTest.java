import com.google.inject.Inject;
import org.example.components.NavigationBar;
import org.example.extensions.AndroidExtension;
import org.example.pages.LoginPage;
import org.example.pages.UsersPage;
import org.example.pages.UsersWishesPage;
import org.example.pages.UsersWishlistsPage;
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

  @Test
  void reserveUsersGift() {
    loginPage
        .login("Nika", "0987654321");
    navigationBar
        .tapUsersMenu();
    usersPage
        .searchForUser("Nika2")
        .clickUser(1);
    usersWishlistsPage
        .tapWishlist(1);
    usersWishesPage
        .reserveGift()
        .checkGiftIsReserved();
  }
}
