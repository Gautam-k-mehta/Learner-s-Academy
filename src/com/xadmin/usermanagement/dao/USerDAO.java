package com.xadmin.usermanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xadmin.usermanagement.model.User;


/**
 * AbstractDAO.java This DAO class provides CRUD database operations for the
 * table users in the database.
 * 
 * @author Gautam Kumar
 *
 */
public class USerDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/simplilearn";
	private String jdbcUsername = "root";
	private String jdbcPassword = "Gautamehta023@";

	private static final String INSERT_STUDENTS = "INSERT INTO students" + "  (std_name, classname, subject, teacher) VALUES "
			+ " (?, ?, ?,?);";

	private static final String SELECT_STUDENT_BY_ID = "select std_id,std_name,classname,subject, teacher from students where std_id =?";
	private static final String SEARCH_STUDENT_BY_NAME = "select * from students where std_id like ? or std_name like ? or classname like ? or subject like ? or teacher like ?";
	private static final String SELECT_ALL_STUDENTS = "select * from students";
	private static final String DELETE_STUDENT = "delete from students where std_id = ?;";
	private static final String UPDATE_STUDENT = "update students set std_name = ?,classname= ?, subject =?, teacher =? where std_id = ?;";

	public USerDAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void insertUser(User user) throws SQLException {
		System.out.println(INSERT_STUDENTS);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENTS)) {
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getSclass());
			preparedStatement.setString(3, user.getSubject());
			preparedStatement.setString(4, user.getTeacher());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public User selectUser(int id) {
		User user = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("std_name");
				String sclass = rs.getString("classname");
				String subject = rs.getString("subject");
				String teacher = rs.getString("teacher");
				user = new User(id, name, sclass, subject, teacher);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	}

	public Object searchUser(String sname) {
		User user = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_STUDENT_BY_NAME);) {
			preparedStatement.setString(1, sname+"%");
			preparedStatement.setString(2, sname+"%");
			preparedStatement.setString(3, sname+"%");
			preparedStatement.setString(4, sname+"%");
			preparedStatement.setString(5, sname+"%");
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				Integer id = rs.getInt("std_id");
				String sclass = rs.getString("classname");
				String subject = rs.getString("subject");
				String teacher = rs.getString("teacher");
				user = new User(id, sname, sclass, subject, teacher);
				ArrayList list = new ArrayList();
				list.add(id);
				list.add(teacher);
				list.add(sclass);
				list.add(subject);
				System.out.println(list);
				
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	}
	
	public List<User> selectAllUsers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<User> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("std_id");
				String name = rs.getString("std_name");
				String sclass = rs.getString("classname");
				String subject = rs.getString("subject");
				String teacher = rs.getString("teacher");
				users.add(new User(id, name, sclass, subject, teacher));
			}
			
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}

	public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_STUDENT);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateUser(User user) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_STUDENT);) {
			System.out.println("updated User:"+statement);
			statement.setString(1, user.getName());
			statement.setString(2, user.getSclass());
			statement.setString(3, user.getSubject());
			statement.setString(4, user.getTeacher());
			statement.setInt(5, user.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}