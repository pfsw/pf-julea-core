package org.pfsw.julea.core.junit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.pfsw.julea.core.LogLevel.FATAL;
import static org.pfsw.julea.core.testhelper.LogId.ID001;
import static org.pfsw.julea.core.testhelper.LogId.ID002;
import static org.pfsw.julea.core.testhelper.LogId.ID003;
import static org.pfsw.julea.core.testhelper.UnitTestHelper.produceSomeLogEvents;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.pfsw.julea.core.testhelper.SampleInMemoryLogEntriesTracker;
import org.pfsw.julea.core.testhelper.SampleJunit4LogAsserter;
import org.pfsw.julea.core.testhelper.UnitTestHelper;

public class Junit4LogAsserterTest
{
  @Test
  public void test_all()
  {
    SampleJunit4LogAsserter asserter = SampleJunit4LogAsserter.create();

    produceSomeLogEvents(asserter.getSampleLogTracker());

    asserter.assertLogEntry(ID001);
    asserter.assertLogEntry(ID002, "always");
    asserter.assertLogEntry("wrong", "Something");
    asserter.assertLogEntryMessage(".*brown fox.*");

    asserter.assertNoLogEntry(ID003, "always");
    asserter.assertNoLogEntry(FATAL);
    asserter.assertNoLogEntry("fox", "always");
    asserter.assertNoLogEntryMessage(".*green.*");
  }

  @Test
  public void test_track()
  {
    SampleJunit4LogAsserter asserter = SampleJunit4LogAsserter.create();

    asserter.trackLogger(UnitTestHelper.class, SampleInMemoryLogEntriesTracker.class);

    List<String> loggerNames = asserter.getLoggerNames();

    assertEquals(2, loggerNames.size());
    assertTrue(loggerNames.contains("org.pfsw.julea.core.testhelper.UnitTestHelper"));
    assertTrue(loggerNames.contains("org.pfsw.julea.core.testhelper.SampleInMemoryLogEntriesTracker"));
  }
}
