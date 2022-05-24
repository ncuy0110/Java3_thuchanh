package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Interf extends Remote{
	public boolean createAccount(String username, String password, String cmnd) throws RemoteException;
	public boolean login(String username, String password) throws RemoteException;
	public boolean enter(String username, String password, int moneys) throws RemoteException;
	public boolean withdraw(String username, String password, int moneys) throws RemoteException;
	public int getMoney(String username, String password) throws RemoteException;
}
