// ===========================================================================
// CONTENT  : CLASS InMemoryLogRecordsCollector
// AUTHOR   : Manfred Duchrow
// VERSION  : 1.0 - 23/08/2024
// HISTORY  :
//  23/08/2024  mdu  CREATED
//
// Copyright (c) 2024, by MDCS. All rights reserved.
// ===========================================================================
package org.pfsw.julea.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InMemoryLogRecordsCollector
{
  private final List<LogRecord> logRecords = Collections.synchronizedList(new ArrayList<>());

  /**
   * Returns a newly created instance of this class. 
   */
  public static InMemoryLogRecordsCollector create()
  {
    return new InMemoryLogRecordsCollector();
  }

  /**
   * Returns a newly created instance of this class. 
   */
  public InMemoryLogRecordsCollector()
  {
    super();
  }

  /**
   * Appends the given log record to the in-memory held list of log records.
   */
  public InMemoryLogRecordsCollector append(LogRecord logRecord)
  {
    if (logRecord != null)
    {
      getLogRecords().add(logRecord);
    }
    return this;
  }

  public List<LogRecord> getLogRecords()
  {
    return this.logRecords;
  }

  public void clear()
  {
    getLogRecords().clear();
  }

  public int size()
  {
    return getLogRecords().size();
  }

  public boolean isEmpty()
  {
    return getLogRecords().isEmpty();
  }

  @Override
  public String toString()
  {
    return String.format("%s(size=%d)", getClass().getSimpleName(), size());
  }
}
