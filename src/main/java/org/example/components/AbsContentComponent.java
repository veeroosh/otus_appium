package org.example.components;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public class AbsContentComponent<T> extends AbsComponent<AbsContentComponent<T>> {

  protected ElementsCollection items;

  public AbsContentComponent(SelenideElement root) {
    super(root);
  }

  public void assertSizeEqualTo(int expected) {
    items.shouldHave(CollectionCondition.size(expected));
  }

  public void shouldNotExist() {
    items.should(CollectionCondition.size(0));
  }
}
