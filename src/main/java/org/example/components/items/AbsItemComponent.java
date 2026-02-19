package org.example.components.items;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebElementCondition;
import org.example.components.AbsComponent;

@SuppressWarnings("unchecked")
public abstract class AbsItemComponent<T extends AbsItemComponent<T>> extends AbsComponent<AbsItemComponent<T>> {

  public AbsItemComponent(SelenideElement root) {
    super(root);
  }

  protected SelenideElement title;
  protected SelenideElement subtitle;
  protected SelenideElement editButton;

  protected void assertElementEqualsTo(SelenideElement element, String value) {
    element.shouldHave(text(value));
  }

  public void assertTitleEqualsTo(String value) {
    assertElementEqualsTo(title, value);
  }

  public void assertSubtitleEqualsTo(String value) {
    assertElementEqualsTo(subtitle, value);
  }

  public void tapEdit() {
    editButton
        .shouldBe(visible)
        .click();
  }

  public void click() {
    title
        .shouldBe(visible)
        .click();
  }

  public T shouldBe(WebElementCondition... condition) {
    root.shouldBe(condition);
    return (T) this;
  }
}
