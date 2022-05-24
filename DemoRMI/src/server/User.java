package server;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String username;
	private String password;
	private int moneys;
	private String CMND;
	private float interestRate;
	private List<Transaction> trans;


	public User(String username, String password, String cMND) {
		super();
		this.username = username;
		this.password = password;
		this.moneys=0;
		CMND = cMND;
		this.interestRate = (float) 0.14;
		this.trans = new ArrayList<Transaction>();
	}

	public int getMoneys() {
		return moneys;
	}

	public void setMoneys(int moneys) {
		this.moneys = moneys;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCMND() {
		return CMND;
	}
	public void setCMND(String cMND) {
		CMND = cMND;
	}
	public float getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}
	public List<Transaction> getTrans() {
		return trans;
	}
	public void setTrans(List<Transaction> trans) {
		this.trans = trans;
	}
	
	public void addtrans(Transaction tran) {
		trans.add(tran);
	}
}
