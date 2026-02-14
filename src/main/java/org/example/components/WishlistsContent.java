package org.example.components;

import static com.codeborne.selenide.appium.SelenideAppium.$;

import com.google.inject.Singleton;
import io.appium.java_client.AppiumBy;

@Singleton
public class WishlistsContent extends AbsContentComponent<WishlistsContent> {

  public WishlistsContent() {
    super($(AppiumBy.id("ru.otus.wishlist:id/wishlists")));
    items = root.$$(AppiumBy.id("ru.otus.wishlist:id/wishlist_item"));
  }

  public WishlistItem get(int index) {
    return new WishlistItem(items.get(index - 1));
  }
}
