package org.pfsw.julea.core.assertions;

import static org.pfsw.julea.core.LogLevel.*;
import static org.pfsw.julea.core.testhelper.LogId.ID001;
import static org.pfsw.julea.core.testhelper.LogId.ID002;
import static org.pfsw.julea.core.testhelper.LogId.ID003;
import static org.pfsw.julea.core.testhelper.UnitTestHelper.produceSomeLogEvents;

import org.junit.jupiter.api.Test;
import org.pfsw.julea.core.testhelper.SampleInMemoryLogEntriesTracker;

public class AssertionsTest
{
  @Test
  public void test_assertions_junit4()
  {
    SampleInMemoryLogEntriesTracker tracker = SampleInMemoryLogEntriesTracker.create();

    produceSomeLogEvents(tracker);

    Junit4LogAssertions.assertLogEntry(tracker, INFO, ID001.name());
    Junit4LogAssertions.assertLogEntry(tracker, ID002, "always");
    Junit4LogAssertions.assertLogEntry(tracker, "wrong", "Something");
    Junit4LogAssertions.assertLogEntryMessage(tracker, ".*brown fox.*");

    Junit4LogAssertions.assertNoLogEntry(tracker, ID003, "always");
    Junit4LogAssertions.assertNoLogEntry(tracker, FATAL);
    Junit4LogAssertions.assertNoLogEntry(tracker, "fox", "always");
    Junit4LogAssertions.assertNoLogEntryMessage(tracker, ".*green.*");
  }

  @Test
  public void test_test_assertions_junit4()
  {
    SampleInMemoryLogEntriesTracker tracker = SampleInMemoryLogEntriesTracker.create();

    produceSomeLogEvents(tracker);

    Junit5LogAssertions.assertLogEntry(tracker, INFO, ID001.name());
    Junit5LogAssertions.assertLogEntry(tracker, ID002, "always");
    Junit5LogAssertions.assertLogEntry(tracker, "wrong", "Something");
    Junit5LogAssertions.assertLogEntryMessage(tracker, ".*brown fox.*");
    
    Junit5LogAssertions.assertNoLogEntry(tracker, ID003, "always");
    Junit5LogAssertions.assertNoLogEntry(tracker, FATAL);
    Junit5LogAssertions.assertNoLogEntry(tracker, "fox", "always");
    Junit5LogAssertions.assertNoLogEntryMessage(tracker, ".*green.*");
  }
}
