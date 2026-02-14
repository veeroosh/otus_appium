package org.example.components;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebElementCondition;
import lombok.AllArgsConstructor;
import org.example.pageobject.AbsPageObject;

@SuppressWarnings("unchecked")
@AllArgsConstructor
public class AbsComponent<T extends AbsComponent<T>> extends AbsPageObject {

  protected final SelenideElement root;

  public T shouldBe(WebElementCondition... condition) {
    root.shouldBe(condition);
    return (T) this;
  }
}
