package org.pfsw.julea.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LogRecordTest
{
  @Test
  public void test_toString()
  {
    assertEquals("LogRecord(ERROR, 'test-msg')", LogRecord.create(LogLevel.ERROR, "test-msg").toString());
  }
}
