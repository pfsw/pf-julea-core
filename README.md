# JUnit Log Event Assertion (JULEA) Core

This library is the common core implementation (built with Java **8**) for a simple way of tracking log events during the execution of JUnit tests
and asserting the existence or non-existence of specific log events during the test execution.  

For using these capabilities one of the following libraries must be included into the dependencies of a project.
They are doing the integration of the generic core functionality with specific logging frameworks.

- pf-julea-log4j2 (integration with the *Apache log4j* logging framework)
- pf-julea-logback (integration with the *logback* logging framework)
