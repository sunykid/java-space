package org.icase.rpc;

public class HelloServiceImpl implements HelloService {

	public String hello(String name) {
		return "hello "+name;
	}

}
 