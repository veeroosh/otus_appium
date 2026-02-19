package org.example.components;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static io.appium.java_client.AppiumBy.id;

import com.codeborne.selenide.SelenideElement;
import com.google.inject.Singleton;

@Singleton
public class TopAppBar extends AbsComponent<TopAppBar> {

  private final SelenideElement filter = $(id("ru.otus.wishlist:id/filter"));

  public TopAppBar() {
    super($(id("ru.otus.wishlist:id/top_app_bar")));
  }

  public void openFilter() {
    filter
        .shouldBe(visible)
        .click();
  }
}
