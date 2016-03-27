package org.icase.distributed.rmi.server.impl;

import java.rmi.RemoteException;

import org.icase.distributed.rmi.server.Business;

public class BusinessImpl implements Business {

	@Override
	public String echo(String message) throws RemoteException {
 		if("quit".equalsIgnoreCase(message)){
 			System.out.println("Server will be shutdown!");
 			System.exit(0);
 		}
		System.out.println("Message from client:"+message);
		return "Server response:"+message;
	}
}
