package org.icase.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  AssertTests.class,
  CalculatorTest.class,
})
public class FeatureTestSuite {

}
