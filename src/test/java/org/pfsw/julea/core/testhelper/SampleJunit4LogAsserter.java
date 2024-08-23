package org.pfsw.julea.core.testhelper;

import java.util.ArrayList;
import java.util.List;

import org.pfsw.julea.core.LogEntriesTracker;
import org.pfsw.julea.core.junit4.Junit4LogAsserter;
import org.pfsw.julea.core.junit4.Junit4LogEntriesTracker;

public class SampleJunit4LogAsserter implements Junit4LogAsserter<Junit4LogEntriesTracker>
{
  private final SampleInMemoryLogEntriesTracker sampleLogTracker = SampleInMemoryLogEntriesTracker.create();
  private final List<String> loggerNames = new ArrayList<>();
  
  public static SampleJunit4LogAsserter create()
  {
    return new SampleJunit4LogAsserter();
  }

  protected SampleJunit4LogAsserter()
  {
    super();
  }
  
  @Override
  public Junit4LogEntriesTracker trackLogger(String... names)
  {
    for (String loggerName : names)
    {
      getLoggerNames().add(loggerName);
    }
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
  
  public List<String> getLoggerNames()
  {
    return this.loggerNames;
  }

  @Override
  public String toString()
  {
    return String.format("%s()", getClass().getSimpleName());
  }
}
