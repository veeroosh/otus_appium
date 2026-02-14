package org.example.components;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

public class WishlistItem extends BaseItemComponent<WishlistItem> {

  public WishlistItem(SelenideElement root) {
    super(root);
    title = root.$(AppiumBy.id("ru.otus.wishlist:id/title"));
    subtitle = root.$(AppiumBy.id("ru.otus.wishlist:id/subtitle"));
    editButton = root.$(AppiumBy.id("ru.otus.wishlist:id/edit_button"));
  }
}
