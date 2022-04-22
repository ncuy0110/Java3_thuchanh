package model;

import java.sql.Date;

public class User {
	private Long id;
	private String username;
	private String password;
	private Date createdAt;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public User(Long id, String username, String password, Date createdAt) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.createdAt = createdAt;
	}

	public User() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getCreateAt() {
		return createdAt;
	}

	public void setCreateAt(Date createAt) {
		this.createdAt = createAt;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", createdAt=" + createdAt
				+ "]";
	}

}
