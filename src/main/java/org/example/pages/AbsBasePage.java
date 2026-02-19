package org.example.pages;

import com.google.inject.Inject;
import org.example.components.NavigationBar;
import org.example.components.TopAppBar;
import org.example.pageobject.AbsPageObject;

public abstract class AbsBasePage extends AbsPageObject {

  @Inject
  private NavigationBar navigationBar;
  @Inject
  private TopAppBar topAppBar;

  public AbsBasePage tapUsersMenu() {
    navigationBar.tapUsersMenu();
    return this;
  }

  public void openFilter() {
    topAppBar.openFilter();
  }
}
