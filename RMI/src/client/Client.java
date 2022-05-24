package client;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import Interfaces.DemoIntf;

public class Client {
	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.getRegistry("localhost", 2022);
			DemoIntf demoIntf = (DemoIntf) registry.lookup(DemoIntf.class.getSimpleName());
			System.out.println(demoIntf.sum(1, 2));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
