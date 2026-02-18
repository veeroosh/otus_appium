package org.example.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static io.appium.java_client.AppiumBy.id;

import com.codeborne.selenide.SelenideElement;
import com.google.inject.Singleton;
import org.example.components.content.WishesContent;
import org.example.components.items.WishItem;

@Singleton
public class WishesPage extends AbsBasePage {

  private final WishesContent wishesContent = new WishesContent();
  private final SelenideElement addWishItemButton = $(id("ru.otus.wishlist:id/add_button"));

  public WishesPage assertNumberOfWishes(int value) {
    if (value == 0) {
      wishesContent.shouldNotExist();
    } else {
      wishesContent
          .shouldBe(visible)
          .assertSizeEqualTo(value);
    }
    return this;
  }

  public WishesPage assertWishTitle(int index, String expected) {
    getWishItem(index).assertTitleEqualsTo(expected);
    return this;
  }

  public WishesPage assertWishSubtitle(int index, String expected) {
    getWishItem(index).assertSubtitleEqualsTo(expected);
    return this;
  }

  public WishesPage assertWishPrice(int index, String expected) {
    getWishItem(index).assertPriceEqualsTo(expected);
    return this;
  }

  public void tapEditWish(int index) {
    getWishItem(index).tapEdit();
  }

  public void tapAddWish() {
    addWishItemButton
        .shouldBe(visible)
        .click();
  }

  private WishItem getWishItem(int index) {
    return (WishItem) wishesContent.get(index)
        .shouldBe(visible);
  }
}
