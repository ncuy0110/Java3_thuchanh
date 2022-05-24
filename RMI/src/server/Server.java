package server;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import Interfaces.DemoIntf;
import impls.DemoImpl;

public class Server {
	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.createRegistry(2022);
			registry.rebind(DemoIntf.class.getSimpleName(), new DemoImpl());
			System.out.println("Server started");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
