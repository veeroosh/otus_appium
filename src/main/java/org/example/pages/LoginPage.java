package org.example.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

import com.codeborne.selenide.SelenideElement;
import com.google.inject.Singleton;
import io.appium.java_client.AppiumBy;

@Singleton
public class LoginPage extends AbsBasePage {

  private final SelenideElement usernameInputField =
      $(AppiumBy.id("ru.otus.wishlist:id/username_text_input"))
          .as("Поле ввода имени пользователя");
  private final SelenideElement passwordInputField =
      $(AppiumBy.id("ru.otus.wishlist:id/password_text_input"))
          .as("Поле ввода пароля");
  private final SelenideElement logInButton =
      $(AppiumBy.id("ru.otus.wishlist:id/log_in_button"))
          .as("Кнопка входа");

  public void login(String username, String password) {
    usernameInputField
        .shouldBe(visible)
        .sendKeys(username);
    passwordInputField
        .shouldBe(visible)
        .sendKeys(password);
    logInButton
        .shouldBe(visible)
        .click();
  }
}
