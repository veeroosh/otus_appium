package org.example.emulator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Emulator {
  ANDROID_12(Integer.parseInt(System.getProperty("emulator.port.one"))),
  ANDROID_14(Integer.parseInt(System.getProperty("emulator.port.two")));

  private final int port;
}
