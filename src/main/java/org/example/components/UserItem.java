package org.example.components;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;

public class UserItem extends BaseItemComponent<UserItem> {

  public UserItem(SelenideElement root) {
    super(root);
    title = root.$(AppiumBy.id("ru.otus.wishlist:id/username"));
  }
}
