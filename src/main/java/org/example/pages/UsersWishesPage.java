package org.example.pages;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static io.appium.java_client.AppiumBy.id;

import com.codeborne.selenide.SelenideElement;
import com.google.inject.Singleton;

@Singleton
public class UsersWishesPage extends AbsBasePage {

  private final SelenideElement actionButton = $(id("ru.otus.wishlist:id/reserved"));

  public UsersWishesPage reserveGift() {
    actionButton
        .shouldBe(visible)
        .click();
    return this;
  }

  public void checkGiftIsReserved() {
    actionButton
        .shouldHave(attribute("checked", "true"));
  }
}
