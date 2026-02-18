package org.example.components.items;

import static io.appium.java_client.AppiumBy.id;

import com.codeborne.selenide.SelenideElement;

public class UserItem extends AbsItemComponent<UserItem> {

  public UserItem(SelenideElement root) {
    super(root);
    title = root.$(id("ru.otus.wishlist:id/username"));
  }
}
