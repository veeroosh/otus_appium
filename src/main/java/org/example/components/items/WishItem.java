package org.example.components.items;

import static io.appium.java_client.AppiumBy.id;

import com.codeborne.selenide.SelenideElement;

public class WishItem extends AbsItemComponent<WishItem> {

  private final SelenideElement price = root.$(id("ru.otus.wishlist:id/price"));

  public WishItem(SelenideElement root) {
    super(root);
    title = root.$(id("ru.otus.wishlist:id/title"));
    subtitle = root.$(id("ru.otus.wishlist:id/subtitle"));
    editButton = root.$(id("ru.otus.wishlist:id/edit_button"));
  }

  public void assertPriceEqualsTo(String value) {
    assertElementEqualsTo(price, value);
  }
}
