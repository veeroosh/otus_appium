package org.example.components.content;

import static com.codeborne.selenide.appium.SelenideAppium.$;
import static io.appium.java_client.AppiumBy.id;

import org.example.components.items.WishItem;

public class WishesContent extends AbsContentComponent<WishesContent> {

  public WishesContent() {
    super($(id("ru.otus.wishlist:id/gifts")));
    items = root.$$(id("ru.otus.wishlist:id/gift_item"));
  }

  public WishItem get(int index) {
    return new WishItem(items.get(index - 1));
  }
}
