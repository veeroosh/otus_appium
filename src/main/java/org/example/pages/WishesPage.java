package org.example.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

import com.codeborne.selenide.SelenideElement;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import io.appium.java_client.AppiumBy;
import org.example.components.WishItem;
import org.example.components.WishesContent;

@Singleton
public class WishesPage extends AbsBasePage {

  @Inject
  private WishesContent wishesContent;
  private final SelenideElement addWishItemButton = $(AppiumBy.id("ru.otus.wishlist:id/add_button"));

  public WishesPage assertNumberOfWishes(int value) {
    if (value == 0)
      wishesContent.shouldNotExist();
    else
      wishesContent
          .shouldBe(visible)
          .assertSizeEqualTo(value);
    return this;
  }

  public WishesPage assertWishTitle(int index, String expected) {
    getWishlistItem(index).assertTitleEqualsTo(expected);
    return this;
  }

  public WishesPage assertWishSubtitle(int index, String expected) {
    getWishlistItem(index).assertSubtitleEqualsTo(expected);
    return this;
  }

  public WishesPage assertWishPrice(int index, String expected) {
    getWishlistItem(index).assertPriceEqualsTo(expected);
    return this;
  }

  public void tapEditWish(int index) {
    getWishlistItem(index).tapEdit();
  }

  public void tapAddWish() {
    addWishItemButton
        .shouldBe(visible)
        .click();
  }

  private WishItem getWishlistItem(int index) {
    return (WishItem) wishesContent.get(index)
        .shouldBe(visible);
  }
}
