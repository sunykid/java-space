package org.icase.distributed.rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Business extends Remote {
	public String echo(String message) throws RemoteException;
}
