package org.icase.distributed;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOClient {
	private Selector selector = null;
    private ByteBuffer receive = ByteBuffer.allocate(1024);  
    private ByteBuffer send = ByteBuffer.allocate(1024);  
	public  void init() throws IOException{
		SocketChannel sc = SocketChannel.open();
		selector = Selector.open();
		sc.configureBlocking(false);
		sc.register(selector,SelectionKey.OP_CONNECT|SelectionKey.OP_READ|SelectionKey.OP_WRITE);
		sc.connect(new InetSocketAddress("127.0.0.1",9000));
		System.out.println("=================启动完成尝试连接================");
	}
	
	public void listen() throws IOException{
		while(true){
			if(selector.select()==0){
				continue;
			}
			Set<SelectionKey> keys = selector.selectedKeys();
			for(SelectionKey key : keys){
				handle(key);
			}
			keys.clear();
		}
		
		
	}
	private void handle(SelectionKey key) throws IOException {
		SocketChannel sc = (SocketChannel) key.channel();
		if(key.isConnectable()){
			if(sc.isConnectionPending()){
				sc.finishConnect();
				System.out.println("connect completely!");
			}
			sc.write(ByteBuffer.wrap("data come from client".getBytes()));
			key.interestOps(SelectionKey.OP_READ);
		}else 
		if(key.isReadable() ){

			receive.clear();
			sc.read(receive);
			System.out.println(new String(receive.array()));
			key.interestOps(SelectionKey.OP_WRITE);
		}else 
		if(key.isWritable()){
			send.clear();
			send.put("Good Bye!".getBytes());
			send.flip();
			sc.write(send);
			key.interestOps(SelectionKey.OP_READ);
		}	
	}
	public  void start() throws IOException{
		this.init();
		this.listen();
		
	}
	public static void main(String[] args) throws IOException {
		new NIOClient().start();
	}
}
