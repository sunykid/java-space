package org.icase.junit;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({SlowTests.class,FastTests.class})
public class CategoryB {
	@Test
	public void c(){
		
		System.out.println("B.c");
	}
	
}

