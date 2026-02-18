package org.example.components.content;

import static com.codeborne.selenide.appium.SelenideAppium.$;
import static io.appium.java_client.AppiumBy.id;

import org.example.components.items.WishlistItem;

public class WishlistsContent extends AbsContentComponent<WishlistsContent> {

  public WishlistsContent() {
    super($(id("ru.otus.wishlist:id/wishlists")));
    items = root.$$(id("ru.otus.wishlist:id/wishlist_item"));
  }

  public WishlistItem get(int index) {
    return new WishlistItem(items.get(index - 1));
  }
}
