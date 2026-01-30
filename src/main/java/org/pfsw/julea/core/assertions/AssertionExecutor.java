// ===========================================================================
// CONTENT  : AssertionExecutor
// AUTHOR   : Manfred Duchrow
// VERSION  : 1.0 - 30/01/2026
// HISTORY  :
//  30/01/2026  mdu  CREATED
//
// Copyright (c) 2026, by MDCS. All rights reserved.
// ===========================================================================
package org.pfsw.julea.core.assertions;

@FunctionalInterface
interface AssertionExecutor
{
  void execute(boolean condition, String failureMessage);
}
