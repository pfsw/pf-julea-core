// ===========================================================================
// CONTENT  : CLASS SampleInMemoryLogAppender
// AUTHOR   : Manfred Duchrow
// VERSION  : 1.0 - 23/08/2024
// HISTORY  :
//  23/08/2024  mdu  CREATED
//
// Copyright (c) 2024, by MDCS. All rights reserved.
// ===========================================================================
package org.pfsw.julea.core.testhelper;

import java.util.List;

import org.pfsw.julea.core.InMemoryLogAppender;
import org.pfsw.julea.core.InMemoryLogRecordsCollector;
import org.pfsw.julea.core.LogLevel;
import org.pfsw.julea.core.LogRecord;

public class SampleInMemoryLogAppender implements InMemoryLogAppender
{
  private final InMemoryLogRecordsCollector logRecordsCollector = InMemoryLogRecordsCollector.create();

  public static SampleInMemoryLogAppender create()
  {
    return new SampleInMemoryLogAppender();
  }

  public SampleInMemoryLogAppender log(LogLevel loglevel, String message, Object... args)
  {
    return append(LogRecord.create(loglevel, String.format(message, args)));
  }

  public SampleInMemoryLogAppender append(LogRecord logRecord)
  {
    getLogRecordsCollector().append(logRecord);
    return this;
  }

  @Override
  public List<LogRecord> getLogRecords()
  {
    return getLogRecordsCollector().getLogRecords();
  }

  @Override
  public String toString()
  {
    return String.format("%s()", getClass().getSimpleName());
  }

  private InMemoryLogRecordsCollector getLogRecordsCollector()
  {
    return this.logRecordsCollector;
  }
}
