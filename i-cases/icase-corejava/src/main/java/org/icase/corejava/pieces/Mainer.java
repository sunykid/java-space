package org.icase.corejava.pieces;

import java.util.HashMap;

public class Mainer {
	static final int MAXIMUM_CAPACITY = 1 << 30;
	public static void main(String[] args) {
	/*	System.out.println(Integer.toBinaryString(2>>>4));
		int code = "hello".hashCode();
		System.out.println(Integer.toBinaryString(code).length());
		System.out.println(Integer.toBinaryString((code>>>16)));
		System.out.println(Integer.toBinaryString((1<<26)|(code>>>16)));
		System.out.println(Integer.toBinaryString(code^(code>>>16)));
		
		System.out.println(Float.isNaN(1f/3));*/
		System.out.println(Mainer.tableSizeFor(5));
	}
	   static final int tableSizeFor(int cap) {
	        int n = cap - 1;
	        n |= n >>> 1;
	        System.out.println(n);
	        n |= n >>> 2;
	        System.out.println(n);
	        n |= n >>> 4;
	        System.out.println(n);
	        n |= n >>> 8;
	        System.out.println(n);
	        n |= n >>> 16;
	        System.out.println(n);
	        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
	    }
}
