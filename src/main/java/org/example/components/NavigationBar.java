package org.example.components;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

import com.codeborne.selenide.SelenideElement;
import com.google.inject.Singleton;
import io.appium.java_client.AppiumBy;

@Singleton
public class NavigationBar extends AbsComponent<NavigationBar> {

  private final SelenideElement usersTab = $(AppiumBy.id("ru.otus.wishlist:id/users_menu"));

  public NavigationBar() {
    super($(AppiumBy.id("ru.otus.wishlist:id/bottom_navigation")));
  }

  public void tapUsersMenu() {
    usersTab
        .shouldBe(visible)
        .click();
  }
}
