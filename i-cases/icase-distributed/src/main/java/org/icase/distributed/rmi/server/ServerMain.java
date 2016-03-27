package org.icase.distributed.rmi.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import org.icase.distributed.rmi.server.impl.BusinessImpl;
/**
 * 缺点：
 * RMI平台有关，只能调用由java编写的远程服务。
 * @author KuKan
 *
 */
public class ServerMain {
	public static final int PORT = 9527;
	public static final String NAME = "BusinessDemo";
	public static void startServer() throws RemoteException{
		Business business = new BusinessImpl();
		UnicastRemoteObject.exportObject(business,PORT);
		Registry registry = LocateRegistry.createRegistry(1099);
		registry.rebind(NAME,business);
	}
	public static void main(String[] args) {
		try {
			startServer();
		} catch (RemoteException e) {
		}
	}
}
