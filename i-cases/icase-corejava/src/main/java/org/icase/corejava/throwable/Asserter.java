package org.icase.corejava.throwable;

public class Asserter {
	public  static void assertEqual(int a,int b){
		assert a==b:"不相等";
	}
	public static void main(String[] args) {
		Asserter.assertEqual(1, 2);
	}
}
