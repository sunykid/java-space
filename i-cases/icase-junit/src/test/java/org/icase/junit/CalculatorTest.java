package org.icase.junit;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class CalculatorTest 
{
	@org.junit.Test
	public void evaluatesExpression(){
		Calculator cal = new Calculator();
		int sum = cal.evaluate("1+2+3");
		assertEquals(6,sum);
	}
	
}
