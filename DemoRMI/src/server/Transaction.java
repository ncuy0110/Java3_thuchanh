package server;

import java.util.Date;

public class Transaction {
	private Date date;
	private int money;
	private boolean type;

	public Transaction(Date date, int money, boolean type) {
		super();
		this.date = date;
		this.money = money;
		this.type = type;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isType() {
		return type;
	}
	public void setType(boolean type) {
		this.type = type;
	}

}
