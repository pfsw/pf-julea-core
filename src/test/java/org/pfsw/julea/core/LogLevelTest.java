package org.pfsw.julea.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LogLevelTest
{
  @Test
  public void test_toString()
  {
    assertEquals("LogLevel(FATAL)", LogLevel.FATAL.toString());
    assertEquals("LogLevel(ERROR)", LogLevel.ERROR.toString());
    assertEquals("LogLevel(WARN)", LogLevel.WARN.toString());
    assertEquals("LogLevel(INFO)", LogLevel.INFO.toString());
    assertEquals("LogLevel(DEBUG)", LogLevel.DEBUG.toString());
    assertEquals("LogLevel(TRACE)", LogLevel.TRACE.toString());
  }
}
