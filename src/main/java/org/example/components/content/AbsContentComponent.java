package org.example.components.content;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.example.components.AbsComponent;

public abstract class AbsContentComponent extends AbsComponent<AbsContentComponent> {

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
