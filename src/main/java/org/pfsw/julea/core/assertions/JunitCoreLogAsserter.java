// ===========================================================================
// CONTENT  : CLASS JunitCoreLogAsserter
// AUTHOR   : Manfred Duchrow
// VERSION  : 1.0 - 23/08/2024
// HISTORY  :
//  23/08/2024  mdu  CREATED
//
// Copyright (c) 2024, by MDCS. All rights reserved.
// ===========================================================================
package org.pfsw.julea.core.assertions;

import java.util.Arrays;

import org.pfsw.julea.core.LogEntriesTracker;

public interface JunitCoreLogAsserter<T extends LogEntriesTracker> extends JunitLogAsserter
{
  /**
   * Tracks all loggers with given names.
   * 
   * @param loggerNames the names of loggers to be tracked.
   * @return A new tracker instance listening on the specified loggers. 
   */
  T trackLogger(String... loggerNames);

  /**
   * Tracks all loggers with the full qualified names of the given classes.
   * 
   * @param classes The class for which loggers with the full qualified class names are to be tracked.
   * @return A new tracker instance listening on the specified loggers. 
   */
  default T trackLogger(Class<?>... classes)
  {
    String[] loggerNames = Arrays.asList(classes).stream().map(Class::getCanonicalName).toArray(c -> new String[c]);
    return trackLogger(loggerNames);
  }
}
