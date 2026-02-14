package org.example.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

import com.codeborne.selenide.SelenideElement;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import io.appium.java_client.AppiumBy;
import org.example.components.UsersContent;

@Singleton
public class UsersPage extends AbsBasePage {

  @Inject
  private UsersContent usersContent;
  private final SelenideElement filter = $(AppiumBy.id("ru.otus.wishlist:id/filter"));
  private final SelenideElement usernameFilterInput =
      $(AppiumBy.id("ru.otus.wishlist:id/username_input"));
  private final SelenideElement searchButton = $(AppiumBy.id("ru.otus.wishlist:id/apply_button"));

  public UsersPage searchForUser(String username) {
    filter
        .shouldBe(visible)
        .click();
    usernameFilterInput
        .shouldBe(visible)
        .sendKeys(username);
    searchButton
        .shouldBe(visible)
        .click();
    return this;
  }

  public void clickUser(int index) {
    usersContent
        .get(index)
        .click();
  }
}
