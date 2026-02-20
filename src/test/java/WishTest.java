import com.google.inject.Inject;
import org.example.db.DatabaseService;
import org.example.extensions.AndroidExtension;
import org.example.pages.EditWishPage;
import org.example.pages.LoginPage;
import org.example.pages.MyWishlistsPage;
import org.example.pages.WishesPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@SuppressWarnings("unused")
@ExtendWith(AndroidExtension.class)
public class WishTest {

  @Inject
  private LoginPage loginPage;
  @Inject
  private MyWishlistsPage myWishlistsPage;
  @Inject
  private WishesPage wishesPage;
  @Inject
  private EditWishPage editWishPage;
  @Inject
  private DatabaseService dbService;

  @Test
  void createAndEditWish() {
    dbService.deleteGiftsForUser("Nika3");
    loginPage
        .login("Nika3", "0987654321");
    String wishTitle = "Конфеты";
    String wishDescription = "Рот фронт";
    String wishPrice = "100";
    String newWishTitle = "Фрукты";
    String newWishDescription = "Яблоки";
    String newWishPrice = "200";
    myWishlistsPage
        .tapWishlist(1);
    wishesPage
        .assertNumberOfWishes(0)
        .tapAddWish();
    editWishPage
        .editTitle(wishTitle)
        .editDescription(wishDescription)
        .editPrice(wishPrice)
        .tapSave();
    wishesPage
        .assertNumberOfWishes(1)
        .assertWishTitle(1, wishTitle)
        .assertWishSubtitle(1, wishDescription)
        .assertWishPrice(1, wishPrice)
        .tapEditWish(1);
    editWishPage
        .editTitle(newWishTitle)
        .editDescription(newWishDescription)
        .editPrice(newWishPrice)
        .tapSave();
    wishesPage
        .assertNumberOfWishes(1)
        .assertWishTitle(1, newWishTitle)
        .assertWishSubtitle(1, newWishDescription)
        .assertWishPrice(1, newWishPrice);
  }
}
