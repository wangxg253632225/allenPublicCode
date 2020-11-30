package com.dongnaoedu.proxy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Tests for {@link Wizard}
 */
public class WizardTest {

  @Test
  public void testToString() throws Exception {
    final String[] wizardNames = {"Gandalf", "Dumbledore", "Oz", "Merlin"};
    for (String name : wizardNames) {
      assertEquals(name, new Wizard(name).toString());
    }
  }
}