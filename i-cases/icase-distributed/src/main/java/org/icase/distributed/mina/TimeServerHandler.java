package org.icase.distributed.mina;

import java.util.Date;

import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

public class TimeServerHandler implements IoHandler {

	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		cause.printStackTrace();
	}

	@Override
	public void inputClosed(IoSession arg0) throws Exception {
		

	}

	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		String str = message.toString();
		if(str.trim().equalsIgnoreCase("quit")){
			session.closeNow();
			return;
		}
		Date date = new Date();
		session.write(date.toString());
		System.out.println("Message written....");
		
	}

	@Override
	public void messageSent(IoSession arg0, Object arg1) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void sessionClosed(IoSession arg0) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void sessionCreated(IoSession arg0) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus satus) throws Exception {
		System.out.println("IDLE"+session.getIdleCount(satus));
	}

	@Override
	public void sessionOpened(IoSession arg0) throws Exception {
		// TODO Auto-generated method stub

	}

}
