package org.example.pages;

import com.google.inject.Singleton;
import org.example.components.content.UsersContent;

@Singleton
public class UsersPage extends AbsBasePage {

  private final UsersContent usersContent = new UsersContent();

  public void clickUser(int index) {
    usersContent
        .get(index)
        .click();
  }
}
