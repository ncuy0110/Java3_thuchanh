package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserRepository {
	private Connection connection;
	public UserRepository() throws ClassNotFoundException {
		connection = DatabaseConnector.getConnection();
	}
	
	public boolean createUser(User user) {
		String query = "insert into user(username, password) values(?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public List<User> getAll(){
		List<User> users = new ArrayList<>();
		String sql = "select * from user";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getLong("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setCreateAt(rs.getDate("created_at"));
				
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public boolean deleteUser(Long id) {
		String sql = "delete from user where id=?;";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setLong(1, id);
			ps.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean login(User user) {
		String sql = "select * from user where username=? and password=?;";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public static void main(String[] args) throws ClassNotFoundException {
		UserRepository userRepository = new UserRepository();
//		userRepository.createUser(new User("ncuy", "abcd1234"));
//		userRepository.getAll().forEach(user -> {
//			System.out.println(user);
//		});
		System.out.println(userRepository.login(new User("ncuy1", "abcd1234")));;
	}
}
