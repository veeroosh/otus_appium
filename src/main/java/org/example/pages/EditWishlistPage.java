package org.example.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

import com.codeborne.selenide.SelenideElement;
import com.google.inject.Singleton;
import io.appium.java_client.AppiumBy;

@Singleton
public class EditWishlistPage extends AbsBasePage {

  private final SelenideElement title = $(AppiumBy.id("ru.otus.wishlist:id/wishlist_edit_title"));
  private final SelenideElement wishlistTitleInputField = $(AppiumBy.id("ru.otus.wishlist:id/title_input"));
  private final SelenideElement wishlistDescriptionInputField =
      $(AppiumBy.id("ru.otus.wishlist:id/description_input"));
  private final SelenideElement saveButton = $(AppiumBy.id("ru.otus.wishlist:id/save_button"));

  public EditWishlistPage assertEditWishlistTitle(String expected) {
    title
        .shouldBe(visible)
        .shouldHave(text(expected));
    return this;
  }

  public EditWishlistPage editTitle(String title) {
    wishlistTitleInputField
        .shouldBe(visible)
        .clear();
    wishlistTitleInputField.sendKeys(title);
    return this;
  }

  public EditWishlistPage editDescription(String description) {
    wishlistDescriptionInputField
        .shouldBe(visible)
        .clear();
    wishlistDescriptionInputField.sendKeys(description);
    return this;
  }

  public void tapSave() {
    saveButton
            .shouldBe(visible)
            .click();
  }
}
