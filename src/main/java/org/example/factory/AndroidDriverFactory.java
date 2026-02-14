package org.example.factory;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import io.appium.java_client.android.AndroidDriver;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.example.emulator.Emulator;
import org.example.emulator.EmulatorProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import java.net.URL;
import java.time.Duration;

@Singleton
@AllArgsConstructor(onConstructor_ = @Inject)
public class AndroidDriverFactory {

  private EmulatorProvider emulatorProvider;
  private Capabilities capabilities;

  @SneakyThrows
  public WebDriver create() {
    Emulator emulator = emulatorProvider.takeAndGet();
    AndroidDriver driver = new AndroidDriver(
        new URL("%s:%d/".formatted(System.getProperty("appium.server.url"), emulator.getPort())),
        capabilities);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    return driver;
  }

  public void quit(WebDriver driver) {
    emulatorProvider.putBack();
    driver.quit();
  }
}
