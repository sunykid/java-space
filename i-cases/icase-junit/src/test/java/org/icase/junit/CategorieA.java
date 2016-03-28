package org.icase.junit;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CategorieA {
	@Test
	public void a(){
		System.out.println("fail");
	}
	@Category(SlowTests.class)
	@Test
	public void b(){
		System.out.println("A.b");
	}
}
