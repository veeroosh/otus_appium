package org.example.components.content;

import static com.codeborne.selenide.appium.SelenideAppium.$;
import static io.appium.java_client.AppiumBy.id;

import org.example.components.items.UserItem;

public class UsersContent extends AbsContentComponent {

  public UsersContent() {
    super($(id("ru.otus.wishlist:id/users")));
    items = root.$$(id("ru.otus.wishlist:id/user_item"));
  }

  public UserItem get(int index) {
    return new UserItem(items.get(index - 1));
  }
}
