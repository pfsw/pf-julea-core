package org.pfsw.julea.core;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class InMemoryLogRecordsCollectorTest
{
  @Test
  public void test_size_clear_isEmpty()
  {
    InMemoryLogRecordsCollector collector = InMemoryLogRecordsCollector.create();
    
    collector.append(LogRecord.create(LogLevel.INFO, "test"));
    collector.append(null);
    
    assertFalse(collector.isEmpty());
    assertEquals(1, collector.size());
    collector.clear();
    assertTrue(collector.isEmpty());
    assertEquals(0, collector.size());
  }

  @Test
  public void test_toString()
  {
    InMemoryLogRecordsCollector collector = InMemoryLogRecordsCollector.create();
    
    collector.append(LogRecord.create(LogLevel.INFO, "test"));
    collector.append(LogRecord.create(LogLevel.ERROR, "error"));
    
    assertEquals("InMemoryLogRecordsCollector(size=2)", collector.toString());
  }
}
