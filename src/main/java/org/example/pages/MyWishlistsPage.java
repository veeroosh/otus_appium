package org.example.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

import com.codeborne.selenide.SelenideElement;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import io.appium.java_client.AppiumBy;
import org.example.components.WishlistItem;
import org.example.components.WishlistsContent;

@Singleton
public class MyWishlistsPage extends AbsBasePage {

  @Inject
  private WishlistsContent wishlistsContent;
  private final SelenideElement addWishlistItemButton = $(AppiumBy.id("ru.otus.wishlist:id/add_button"));

  public MyWishlistsPage assertNumberOfWishlists(int value) {
    if (value == 0)
      wishlistsContent.shouldNotExist();
    else
      wishlistsContent
          .shouldBe(visible)
          .assertSizeEqualTo(value);
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
    WishlistItem item = (WishlistItem) wishlistsContent.get(index);
    item.shouldBe(visible);
    return item;
  }

  public void tapWishlist(int index) {
    getWishlistItem(index).click();
  }
}
