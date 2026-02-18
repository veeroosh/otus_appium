package org.example.components.items;

import static io.appium.java_client.AppiumBy.id;

import com.codeborne.selenide.SelenideElement;

public class WishlistItem extends AbsItemComponent<WishlistItem> {

  public WishlistItem(SelenideElement root) {
    super(root);
    title = root.$(id("ru.otus.wishlist:id/title"));
    subtitle = root.$(id("ru.otus.wishlist:id/subtitle"));
    editButton = root.$(id("ru.otus.wishlist:id/edit_button"));
  }
}
