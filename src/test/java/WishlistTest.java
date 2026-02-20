import com.google.inject.Inject;
import org.example.db.DatabaseService;
import org.example.extensions.AndroidExtension;
import org.example.pages.EditWishlistPage;
import org.example.pages.LoginPage;
import org.example.pages.MyWishlistsPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@SuppressWarnings("unused")
@ExtendWith(AndroidExtension.class)
public class WishlistTest {

  @Inject
  private LoginPage loginPage;
  @Inject
  private EditWishlistPage editWishlistPage;
  @Inject
  private MyWishlistsPage myWishlistsPage;
  @Inject
  private DatabaseService dbService;

  @Test
  void createAndEditWishlist() {
    dbService.deleteWishlistsForUser("Nika");
    loginPage
        .login("Nika", "0987654321");
    String wishlistTitle = "День рождения";
    String wishlistDescription = "18 октября";
    String newWishlistTitle = "8 марта";
    String newWishlistDescription = "Международный женский день";
    myWishlistsPage
        .assertNumberOfWishlists(0)
        .tapAddWishlist();
    editWishlistPage
        .assertEditWishlistTitle("Новый список желаний")
        .editTitle(wishlistTitle)
        .editDescription(wishlistDescription)
        .tapSave();
    myWishlistsPage
        .assertNumberOfWishlists(1)
        .assertWishlistTitle(1, wishlistTitle)
        .assertWishlistSubtitle(1, wishlistDescription)
        .tapEditWishlist(1);
    editWishlistPage
        .assertEditWishlistTitle("Изменить список желаний")
        .editTitle(newWishlistTitle)
        .editDescription(newWishlistDescription)
        .tapSave();
    myWishlistsPage
        .assertNumberOfWishlists(1)
        .assertWishlistTitle(1, newWishlistTitle)
        .assertWishlistSubtitle(1, newWishlistDescription);
  }
}
