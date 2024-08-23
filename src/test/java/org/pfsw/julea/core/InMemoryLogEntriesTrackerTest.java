package org.pfsw.julea.core;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.pfsw.julea.core.LogLevel.ALL;
import static org.pfsw.julea.core.LogLevel.DEBUG;
import static org.pfsw.julea.core.LogLevel.INFO;
import static org.pfsw.julea.core.testhelper.LogId.ID001;
import static org.pfsw.julea.core.testhelper.LogId.ID002;
import static org.pfsw.julea.core.testhelper.LogId.ID003;
import static org.pfsw.julea.core.testhelper.LogId.ID004;
import static org.pfsw.julea.core.testhelper.UnitTestHelper.produceSomeLogEvents;

import org.junit.jupiter.api.Test;
import org.pfsw.julea.core.testhelper.SampleInMemoryLogEntriesTracker;

public class InMemoryLogEntriesTrackerTest
{
  @Test
  public void test_hasLogEntryWith()
  {
    SampleInMemoryLogEntriesTracker tracker = SampleInMemoryLogEntriesTracker.create();

    produceSomeLogEvents(tracker);

    assertTrue(tracker.hasLogEntryWith(ID001.name()));
    assertFalse(tracker.hasLogEntryWith(ID004.name()));
  }

  @Test
  public void test_hasLogEntryWith__log_level()
  {
    SampleInMemoryLogEntriesTracker tracker = SampleInMemoryLogEntriesTracker.create();

    produceSomeLogEvents(tracker);

    assertTrue(tracker.hasLogEntryWith(INFO, ID001.name()));
    assertTrue(tracker.hasLogEntryWith(ALL, ID002.name()));
    assertFalse(tracker.hasLogEntryWith(DEBUG, ID002.name()));
  }

  @Test
  public void test_hasLogEntryMaching()
  {
    SampleInMemoryLogEntriesTracker tracker = SampleInMemoryLogEntriesTracker.create();

    produceSomeLogEvents(tracker);

    assertTrue(tracker.hasLogEntryMatching(".*quick.*"));
    assertFalse(tracker.hasLogEntryMatching("Test 2"));
  }

  @Test
  public void test_clear()
  {
    SampleInMemoryLogEntriesTracker tracker = SampleInMemoryLogEntriesTracker.create();

    produceSomeLogEvents(tracker);

    assertTrue(tracker.hasLogEntryWith(ID001.name()));
    assertTrue(tracker.hasLogEntryWith(ID002.name()));
    assertTrue(tracker.hasLogEntryWith(ID003.name()));
    assertTrue(tracker.hasLogEntryMatching(".*quick.*"));
    tracker.clear();
    assertFalse(tracker.hasLogEntryWith(ID001.name()));
    assertFalse(tracker.hasLogEntryWith(ID002.name()));
    assertFalse(tracker.hasLogEntryWith(ID003.name()));
    assertFalse(tracker.hasLogEntryMatching(".*quick.*"));
  }
}
