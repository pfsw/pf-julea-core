// ===========================================================================
// CONTENT  : CLASS SampleInMemoryLogEntriesTracker
// AUTHOR   : Manfred Duchrow
// VERSION  : 1.0 - 23/08/2024
// HISTORY  :
//  23/08/2024  mdu  CREATED
//
// Copyright (c) 2024, by MDCS. All rights reserved.
// ===========================================================================
package org.pfsw.julea.core.testhelper;

import org.pfsw.julea.core.InMemoryLogAppender;
import org.pfsw.julea.core.InMemoryLogEntriesTracker;

public class SampleInMemoryLogEntriesTracker implements InMemoryLogEntriesTracker
{
  private final SampleInMemoryLogAppender sampleAppender = SampleInMemoryLogAppender.create();

  public static SampleInMemoryLogEntriesTracker create()
  {
    return new SampleInMemoryLogEntriesTracker();
  }

  protected SampleInMemoryLogEntriesTracker()
  {
    super();
  }

  @Override
  public InMemoryLogAppender getAppender()
  {
    return getSampleAppender();
  }

  public SampleInMemoryLogAppender getSampleAppender()
  {
    return this.sampleAppender;
  }

  @Override
  public String toString()
  {
    return String.format("%s()", getClass().getSimpleName());
  }
}
