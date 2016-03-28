package org.icase.junit;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestMethodOrder {
	@Test
	public void testC(){
		System.out.println('C');
	}
	@Test
	public void testB(){
		System.out.println('B');
	}
	@Test
	public void testA(){
		System.out.println('A');
	}

}
