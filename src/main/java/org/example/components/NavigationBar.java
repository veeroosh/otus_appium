package org.example.components;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static io.appium.java_client.AppiumBy.id;

import com.codeborne.selenide.SelenideElement;
import com.google.inject.Singleton;

@Singleton
public class NavigationBar extends AbsComponent<NavigationBar> {

  private final SelenideElement usersTab = $(id("ru.otus.wishlist:id/users_menu"));

  public NavigationBar() {
    super($(id("ru.otus.wishlist:id/bottom_navigation")));
  }

  public void tapUsersMenu() {
    usersTab
        .shouldBe(visible)
        .click();
  }
}
