package org.icase.distributed.tcp;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
/**
 * 相比BIO优势：
 * 可进行连接复用（没大理解）
 * 一请求一线程
 * 注意：容易耗尽cpu资源（暂未理解，例子中未处理）
 * select（）抛出异常的处理
 * select（）不阻塞直接返回
 * @author sunkk
 *
 */
public class NIOServer {
	Selector selector = null;
	private ByteBuffer receive = ByteBuffer.allocate(1024);  
	private ByteBuffer send = ByteBuffer.allocate(1024);  
	public void init() throws IOException{
		ServerSocketChannel ssc = ServerSocketChannel.open();
		ssc.configureBlocking(false);
		ServerSocket ss = ssc.socket();
		
		ss.bind(new InetSocketAddress(9000));
		selector = Selector.open(); 
		
		ssc.register(selector,SelectionKey.OP_ACCEPT);
		
		System.out.println("===================启动完成，等待连接===============");
	}
	
	public void listen() throws IOException{
		while(true){
			selector.select();
			Set<SelectionKey> keys = selector.selectedKeys();
			for(SelectionKey key : keys){
				handle(key);
			}
			keys.clear();
		}
	}
	
	private void handle(SelectionKey key) throws IOException {
		
		ServerSocketChannel ssc = null;
		SocketChannel sc = null;
		if(key.isAcceptable()){
			ssc = (ServerSocketChannel)key.channel();
			sc = ssc.accept();
			sc.configureBlocking(false);
			
			sc.register(selector,SelectionKey.OP_READ|SelectionKey.OP_WRITE);
		}else
		if(key.isReadable()){
			sc = (SocketChannel)key.channel();
			receive.clear();
			sc.read(receive);
			System.out.println(new String(receive.array()));
//			key.interestOps(SelectionKey.OP_WRITE);
		}else
		if(key.isWritable()){
			send.clear();
			send.put("datas come from server!".getBytes());
			send.flip();
			sc = (SocketChannel)key.channel();	
			sc.write(send);
			key.interestOps(SelectionKey.OP_READ);
		}
		
	}
	public  void start() throws IOException{
		this.init();
		this.listen();
		
	}
	public static void main(String[] args) throws IOException {
		new NIOServer().start();
	}
}
