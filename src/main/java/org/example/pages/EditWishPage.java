package org.example.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

import com.codeborne.selenide.SelenideElement;
import com.google.inject.Singleton;
import io.appium.java_client.AppiumBy;

@Singleton
public class EditWishPage extends AbsBasePage {

  private final SelenideElement wishTitleInputField = $(AppiumBy.id("ru.otus.wishlist:id/name_input"));
  private final SelenideElement wishDescriptionInputField =
      $(AppiumBy.id("ru.otus.wishlist:id/description_input"));
  private final SelenideElement wishPriceInputField =
      $(AppiumBy.id("ru.otus.wishlist:id/price_input"));
  private final SelenideElement saveButton = $(AppiumBy.id("ru.otus.wishlist:id/save_button"));

  public void tapSave() {
    saveButton
        .shouldBe(visible)
        .click();
  }

  public EditWishPage editTitle(String title) {
    wishTitleInputField
        .shouldBe(visible)
        .clear();
    wishTitleInputField.sendKeys(title);
    return this;
  }

  public EditWishPage editDescription(String description) {
    wishDescriptionInputField
        .shouldBe(visible)
        .clear();
    wishDescriptionInputField.sendKeys(description);
    return this;
  }

  public EditWishPage editPrice(String price) {
    wishPriceInputField
        .shouldBe(visible)
        .clear();
    wishPriceInputField.sendKeys(price);
    return this;
  }
}
