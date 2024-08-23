package org.pfsw.julea.core.testhelper;

import org.pfsw.julea.core.LogEntriesTracker;
import org.pfsw.julea.core.junit5.Junit5LogAsserter;
import org.pfsw.julea.core.junit5.Junit5LogEntriesTracker;

public class SampleJunit5LogAsserter implements Junit5LogAsserter<Junit5LogEntriesTracker>
{
  private final SampleInMemoryLogEntriesTracker sampleLogTracker = SampleInMemoryLogEntriesTracker.create();
  
  public static SampleJunit5LogAsserter create()
  {
    return new SampleJunit5LogAsserter();
  }

  protected SampleJunit5LogAsserter()
  {
    super();
  }
  
  @Override
  public Junit5LogEntriesTracker trackLogger(String... loggerNames)
  {
    return null;
  }
  
  @Override
  public LogEntriesTracker getLogTracker()
  {
    return getSampleLogTracker();
  }
  
  public SampleInMemoryLogEntriesTracker getSampleLogTracker()
  {
    return this.sampleLogTracker;
  }

  @Override
  public String toString()
  {
    return String.format("%s()", getClass().getSimpleName());
  }
}
