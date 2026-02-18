package org.example.pages;

import static com.codeborne.selenide.Condition.visible;

import com.google.inject.Singleton;
import org.example.components.content.WishlistsContent;

@Singleton
public class UsersWishlistsPage extends AbsBasePage {

  private final WishlistsContent wishlistsContent = new WishlistsContent();

  public void tapWishlist(int index) {
    wishlistsContent
        .get(index)
        .shouldBe(visible)
        .click();
  }
}
