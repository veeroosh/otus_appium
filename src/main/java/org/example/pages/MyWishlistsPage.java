package org.example.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static io.appium.java_client.AppiumBy.id;

import com.codeborne.selenide.SelenideElement;
import com.google.inject.Singleton;
import org.example.components.content.WishlistsContent;
import org.example.components.items.WishlistItem;

@Singleton
public class MyWishlistsPage extends AbsBasePage {

  private final WishlistsContent wishlistsContent = new WishlistsContent();
  private final SelenideElement addWishlistItemButton = $(id("ru.otus.wishlist:id/add_button"));

  public MyWishlistsPage assertNumberOfWishlists(int value) {
    if (value == 0) {
      wishlistsContent.shouldNotExist();
    } else {
      wishlistsContent
          .shouldBe(visible)
          .assertSizeEqualTo(value);
    }
    return this;
  }

  public MyWishlistsPage assertWishlistTitle(int index, String expected) {
    getWishlistItem(index).assertTitleEqualsTo(expected);
    return this;
  }

  public MyWishlistsPage assertWishlistSubtitle(int index, String expected) {
    getWishlistItem(index).assertSubtitleEqualsTo(expected);
    return this;
  }

  public void tapEditWishlist(int index) {
    getWishlistItem(index).tapEdit();
  }

  public void tapAddWishlist() {
    addWishlistItemButton
        .shouldBe(visible)
        .click();
  }

  private WishlistItem getWishlistItem(int index) {
    return (WishlistItem) wishlistsContent
        .get(index)
        .shouldBe(visible);
  }

  public void tapWishlist(int index) {
    getWishlistItem(index).click();
  }
}
