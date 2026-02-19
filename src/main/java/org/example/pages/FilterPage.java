package org.example.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static io.appium.java_client.AppiumBy.id;

import com.codeborne.selenide.SelenideElement;
import com.google.inject.Singleton;

@Singleton
public class FilterPage extends AbsBasePage {

  private final SelenideElement usernameFilterInput =
      $(id("ru.otus.wishlist:id/username_input"));
  private final SelenideElement searchButton = $(id("ru.otus.wishlist:id/apply_button"));

  public void searchForUser(String username) {
    usernameFilterInput
        .shouldBe(visible)
        .sendKeys(username);
    searchButton
        .shouldBe(visible)
        .click();
  }
}
