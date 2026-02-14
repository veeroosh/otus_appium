package org.example.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

import com.codeborne.selenide.SelenideElement;

public class BaseItemComponent<T> extends AbsComponent<BaseItemComponent<T>> {

  public BaseItemComponent(SelenideElement root) {
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
}
