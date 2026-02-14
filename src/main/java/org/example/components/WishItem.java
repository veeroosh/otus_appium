package org.example.components;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

public class WishItem extends BaseItemComponent<WishItem> {

  private final SelenideElement price = root.$(AppiumBy.id("ru.otus.wishlist:id/price"));

  public WishItem(SelenideElement root) {
    super(root);
    title = root.$(AppiumBy.id("ru.otus.wishlist:id/title"));
    subtitle = root.$(AppiumBy.id("ru.otus.wishlist:id/subtitle"));
    editButton = root.$(AppiumBy.id("ru.otus.wishlist:id/edit_button"));
  }

  public void assertPriceEqualsTo(String value) {
    assertElementEqualsTo(price, value);
  }
}
