package org.icase.rpc.consumer;

import org.icase.rpc.consumer.HelloService;
import org.icase.rpc.RpcFrameWork;

public class RpcConsumer {
	public static void main(String[] args) {
		HelloService service = RpcFrameWork.refer(HelloService.class, "127.0.0.1", 1234);
		for(int i=0;i<Integer.MAX_VALUE;i++){
			String hello = service.hello("world"+i);
			System.out.println(hello);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
