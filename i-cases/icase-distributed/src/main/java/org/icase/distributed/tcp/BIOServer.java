package org.icase.distributed.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 两个问题：
 * 频繁创建socke性能开销比较大，比较慢（使用连接池优化）
 * 一线程一连接（包括非真实请求），为了防止服务器资源耗尽，限制连接数
 * @author sunkk
 *
 */
public class BIOServer {
	public static void start() throws IOException{
		ServerSocket server = new ServerSocket(9000);
		System.out.println("等待连接....");
		while(true){
			Socket socket = server.accept();
			System.out.println("获取连接");
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			writer.println("Hello Client");
			writer.flush();
			
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(socket.getInputStream(), "UTF-8"));
			
			System.out.println("服务端:"+reader.readLine());
		}
	}
	public static void main(String[] args) throws IOException {
		BIOServer.start();
	}
}
