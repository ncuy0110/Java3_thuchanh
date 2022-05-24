package impls;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import Interfaces.DemoIntf;

public class DemoImpl extends UnicastRemoteObject implements DemoIntf {

	public DemoImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;

	@Override
	public int sum(int a, int b) throws RemoteException {
		return a + b;
	}

}
