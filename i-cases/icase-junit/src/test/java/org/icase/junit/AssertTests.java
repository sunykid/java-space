package org.icase.junit;

import static org.hamcrest.CoreMatchers.both;
import static org.junit.Assert.*;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
public class AssertTests {
	@Test
	public void testAssertArrayEquals(){
		String str = "trial";
		String str1 = "trial";
		assertArrayEquals("failure - byte arrays not same",str.getBytes(), str1.getBytes());
	}
	@Test
	public void testAssertThatBothContainsString(){
		assertThat("albumen",both(containsString("a")).and(containsString("b")));
	}
	@Test
	public void testAssertThatHasItems(){
		assertThat(Arrays.asList("a","b","c"),hasItems("a"));
	}
	@Test
	public void testAssertThatEveryItemContainsString(){
		assertThat(Arrays.asList(new String[]{"fun","ban","net"}),everyItem(containsString("n")));
	}
	@Test
	public void testAssertThatHamcrestCoreMatchers(){
		assertThat("good",allOf(equalTo("good"),startsWith("good")));
		assertThat("good",not(allOf(equalTo("bad"),equalTo("good"))));
		assertThat("good", anyOf(equalTo("bad"), equalTo("good")));
		assertThat(new Object(),not(sameInstance(new Object())));
	}
	@Test
	public void testAssertTrue(){
		assertTrue("failure-should be true",true);
	}
	
}
