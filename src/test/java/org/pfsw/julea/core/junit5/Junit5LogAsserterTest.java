package org.pfsw.julea.core.junit5;

import static org.pfsw.julea.core.LogLevel.FATAL;
import static org.pfsw.julea.core.testhelper.LogId.ID001;
import static org.pfsw.julea.core.testhelper.LogId.ID002;
import static org.pfsw.julea.core.testhelper.LogId.ID003;
import static org.pfsw.julea.core.testhelper.UnitTestHelper.produceSomeLogEvents;

import org.junit.jupiter.api.Test;
import org.pfsw.julea.core.testhelper.SampleJunit5LogAsserter;

public class Junit5LogAsserterTest
{
  @Test
  public void test_all()
  {
    SampleJunit5LogAsserter asserter = SampleJunit5LogAsserter.create();

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
}
