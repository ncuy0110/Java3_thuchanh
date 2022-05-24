package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import rmi.Interf;

public class Main {
	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.createRegistry(2021);
			registry.rebind(Interf.class.getSimpleName(), new Impl());
			System.out.println("Server da san sang:");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
