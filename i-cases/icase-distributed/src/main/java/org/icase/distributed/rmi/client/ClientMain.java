package org.icase.distributed.rmi.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import org.icase.distributed.rmi.server.Business;

public class ClientMain {
	public static final String NAME = "BusinessDemo";
	public static void touchServer() throws RemoteException, NotBoundException{
		Registry registry = LocateRegistry.getRegistry("localhost");
		Business business = (Business)registry.lookup(NAME);
		business.echo("From Client");
	}
	public static void main(String[] args) throws RemoteException, NotBoundException {
		touchServer();
	}
}
