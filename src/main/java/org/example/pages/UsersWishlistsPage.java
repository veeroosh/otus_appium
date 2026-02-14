package org.example.pages;

import static com.codeborne.selenide.Condition.visible;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.components.WishlistsContent;

@Singleton
public class UsersWishlistsPage extends AbsBasePage {

  @Inject
  private WishlistsContent wishlistsContent;

  public void tapWishlist(int index) {
    wishlistsContent.get(index)
        .shouldBe(visible)
        .click();
  }
}
