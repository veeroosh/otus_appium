package org.example.extensions;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.example.factory.AndroidDriverFactory;
import org.example.factory.AndroidDriverModule;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;
import org.openqa.selenium.WebDriver;

public class AndroidExtension implements TestInstancePostProcessor, BeforeEachCallback, AfterEachCallback {

  private final Injector injector = Guice.createInjector(new AndroidDriverModule());

  @Override
  public void afterEach(ExtensionContext context) {
    WebDriver driver = WebDriverRunner.getWebDriver();
    injector.getInstance(AndroidDriverFactory.class).quit(driver);
  }

  @Override
  public void beforeEach(ExtensionContext context) {
    WebDriver driver = injector.getInstance(WebDriver.class);
    WebDriverRunner.setWebDriver(driver);
    Selenide.open();
  }

  @Override
  public void postProcessTestInstance(Object testInstance, ExtensionContext context) {
    injector.injectMembers(testInstance);
  }
}
