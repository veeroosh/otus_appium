package org.example.components;

import static com.codeborne.selenide.appium.SelenideAppium.$;

import com.google.inject.Singleton;
import io.appium.java_client.AppiumBy;

@Singleton
public class WishesContent extends AbsContentComponent<WishesContent> {

  public WishesContent() {
    super($(AppiumBy.id("ru.otus.wishlist:id/gifts")));
    items = root.$$(AppiumBy.id("ru.otus.wishlist:id/gift_item"));
  }

  public WishItem get(int index) {
    return new WishItem(items.get(index - 1));
  }
}
