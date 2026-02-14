package org.example.components;

import static com.codeborne.selenide.appium.SelenideAppium.$;

import com.google.inject.Singleton;
import io.appium.java_client.AppiumBy;

@Singleton
public class UsersContent extends AbsContentComponent<UsersContent> {

  public UsersContent() {
    super($(AppiumBy.id("ru.otus.wishlist:id/users")));
    items = root.$$(AppiumBy.id("ru.otus.wishlist:id/user_item"));
  }

  public UserItem get(int index) {
    return new UserItem(items.get(index - 1));
  }
}
