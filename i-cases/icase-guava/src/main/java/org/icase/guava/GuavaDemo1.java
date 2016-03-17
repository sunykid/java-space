package org.icase.guava;

import com.google.common.base.Optional;

public class GuavaDemo1 {
	
	public static void main(String[] args) {
		Optional<String> o = Optional.absent();
		if(o.isPresent())
			System.out.println("111");
		else
			System.out.println("222");
	}
}
