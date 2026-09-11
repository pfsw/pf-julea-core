// ===========================================================================
// AUTHOR   : Manfred Duchrow
// VERSION  : 2.0 - 30/01/2026
// HISTORY  :
//  27/08/2022  mdu  created
//  30/01/2026  mdu  changed -> support failure message in assertions
//
// Copyright (c) 2022-2026, by MDCS. All rights reserved.
// ===========================================================================
package org.pfsw.julea.core.assertions;

import org.pfsw.julea.core.LogEntriesTracker;
import org.pfsw.julea.core.LogLevel;

class LogAssertions
{
  private final AssertionExecutor assertTrue;
  private final AssertionExecutor assertFalse;

  protected LogAssertions(AssertionExecutor assertTrue, AssertionExecutor assertFalse)
  {
    this.assertTrue = assertTrue;
    this.assertFalse = assertFalse;
  }

  /**
   * Asserts that a log entry containing (all) the given text elements was captured by the given log entry tracker.
   * 
   * @param tracker The tracker that captured log entries for specific loggers.
   * @param textElements The expected log message text parts.
   */
  protected void assertLogEntry(LogEntriesTracker tracker, String... textElements)
  {
    assertTrue.execute(tracker.hasLogEntryWith(textElements), createMessage("No log entry with message containing %s found", asString(textElements)));
  }

  /**
   * Asserts that no log entry containing (all) the given text elements was captured by the given log entry tracker.
   * 
   * @param tracker The tracker that captured log entries for specific loggers.
   * @param textElements The log message text parts to checked.
   */
  protected void assertNoLogEntry(LogEntriesTracker tracker, String... textElements)
  {
    assertFalse.execute(tracker.hasLogEntryWith(textElements), createMessage("Found unexpected log entry with message containing %s", asString(textElements)));
  }

  /**
   * Asserts that a log entry with the specified log level and all the given text elements in the log message was captured by the given log entry tracker.
   * 
   * @param tracker The tracker that captured log entries for specific loggers.
   * @param logLevel The log level to be matched.
   * @param textElements The expected log message text parts.
   */
  protected void assertLogEntry(LogEntriesTracker tracker, LogLevel logLevel, String... textElements)
  {
    assertTrue.execute(tracker.hasLogEntryWith(logLevel, textElements),
        createMessage("No log entry with log level '%s' and message containing %s found", logLevel.asString(), asString(textElements)));
  }

  /**
   * Asserts that no log entry with the given log level and all the given text elements in the log message was captured by the given log entry tracker.
   * 
   * @param tracker The tracker that captured log entries for specific loggers.
   * @param logLevel The log level to be matched.
   * @param textElements The log message text parts to checked.
   */
  protected void assertNoLogEntry(LogEntriesTracker tracker, LogLevel logLevel, String... textElements)
  {
    assertFalse.execute(tracker.hasLogEntryWith(logLevel, textElements),
        createMessage("Found unexpected log entry with log level '%s' and message containing %s", logLevel.asString(), asString(textElements)));
  }

  /**
   * Asserts that a log entry with a message matching the given regular expression was captured by the given log entry tracker.
   * 
   * @param tracker The tracker that captured log entries for specific loggers.
   * @param regex The regular expression the log messages should match.
   */
  protected void assertLogEntryMessage(LogEntriesTracker tracker, String regex)
  {
    assertTrue.execute(tracker.hasLogEntryMatching(regex), createMessage("No log entry found with message matching regular expression: %s", regex));
  }

  /**
   * Asserts that no log entry with a message matching the given regular expression was captured by the given log entry tracker.
   * 
   * @param tracker The tracker that captured log entries for specific loggers.
   * @param regex The regular expression the log messages are matched against.
   */
  protected void assertNoLogEntryMessage(LogEntriesTracker tracker, String regex)
  {
    assertFalse.execute(tracker.hasLogEntryMatching(regex), createMessage("Found unexpected log entry with message matching reqular expression: %s", regex));
  }

  protected String createMessage(String text, Object... args)
  {
    return String.format(text, args);
  }

  protected String asString(String... strings)
  {
    StringBuilder builder = new StringBuilder();

    for (String string : strings)
    {
      if (builder.length() > 0)
      {
        builder.append(" and ");
      }
      builder.append("'");
      builder.append(string);
      builder.append("'");
    }

    return builder.toString();
  }

  String[] concatenate(String value1, String[] otherValues)
  {
    String[] result = new String[otherValues.length + 1];

    result[0] = value1;
    System.arraycopy(otherValues, 0, result, 1, otherValues.length);
    return result;
  }
}
