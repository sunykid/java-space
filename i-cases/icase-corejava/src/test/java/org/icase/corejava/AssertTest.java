package org.icase.corejava;

import org.icase.corejava.throwable.Asserter;
import org.junit.Assert;
import org.junit.Test;


public class AssertTest {
	@Test
	public void tetsAssertEqual(){
		
		Asserter.assertEqual(1, 1);
//		Asserter.assertEqual(1, 2);
		Assert.assertEquals("不相等", 12.0, 12, 0.5);
	}
}
