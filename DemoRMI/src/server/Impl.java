package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import rmi.Interf;

public class Impl extends UnicastRemoteObject implements Interf{
	protected Impl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	private List<User> users = new ArrayList<User>();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean createAccount(String username, String password, String cmnd) throws RemoteException {
		for(User user : users) {
			if(user.getUsername()==username) return false;
		}
		users.add(new User(username, password, cmnd));
		return true;
	}

	@Override
	public boolean login(String username, String password) throws RemoteException {
		System.out.println(users.size());
		for(User user : users) {
			if(user.getUsername().equals(username) && user.getPassword().equals(password)) return true;
		}
		return false;
	}

	@Override
	public boolean enter(String username, String password, int moneys) throws RemoteException {
		for(User user : users) {
			if(user.getUsername().equals(username) && user.getPassword().equals(password)){
				user.setMoneys(user.getMoneys()+moneys);
				user.addtrans(new Transaction(new Date(), moneys, true));
				return true;
			}
			return false;
		}
		return false;
	}

	@Override
	public boolean withdraw(String username, String password, int moneys) throws RemoteException {
		for(User user : users) {
			if(user.getUsername().equals(username) && user.getPassword().equals(password)){
				if(user.getMoneys()-moneys>=0) {
					user.setMoneys(user.getMoneys()-moneys);
					user.addtrans(new Transaction(new Date(), moneys, false));
					return true;
				}
				return false;
			}
		}
		return false;
	}

	@Override
	public int getMoney(String username, String password) throws RemoteException {
		for(User user : users) {
			if(user.getUsername().equals(username) && user.getPassword().equals(password)){
				return user.getMoneys();
			}
		}
		return 0;
	}
	


}
