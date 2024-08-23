package org.pfsw.julea.core.testhelper;

import static org.pfsw.julea.core.LogLevel.DEBUG;
import static org.pfsw.julea.core.LogLevel.INFO;
import static org.pfsw.julea.core.LogLevel.WARN;

public class UnitTestHelper
{
  public static final String STATS_LOGGER_NAME = "test.Statistics";
  public static final String MESSAGE_1 =  String.format("[%s] The quick brown fox jumps over the lazy dog", LogId.ID001);
  public static final String MESSAGE_2 = String.format("[%s} You can't always get what you want", LogId.ID002);
  public static final String MESSAGE_3 = String.format("[%s] Something went wrong", LogId.ID003);
  
  public static void produceSomeLogEvents(SampleInMemoryLogEntriesTracker tracker)
  {
    tracker.getSampleAppender().log(DEBUG, "starting log events");
    tracker.getSampleAppender().log(INFO, MESSAGE_1);
    tracker.getSampleAppender().log(INFO, MESSAGE_2);
    tracker.getSampleAppender().log(WARN, MESSAGE_3);
  }
}
