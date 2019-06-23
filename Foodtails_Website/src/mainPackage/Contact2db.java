package mainPackage;


import java.sql.*;



public class Contact2db {
	public static boolean login_connection(String user, String pass) {
		 
		
		String user_found = null, pass_found = null;
		try {
		
			Connection con = ConnectionProvider.getCon();
			PreparedStatement stmt;
			stmt = con.prepareStatement("Select username,password FROM users WHERE username=? AND password=?");
			stmt.setString(1,user);
			stmt.setString(2,pass);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				user_found = rs.getString("username");
				pass_found = rs.getString("password");
			}
			
			if(user_found == null || pass_found == null) {
				return false;
			}
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static String gettype(String user) {
		// TODO Auto-generated method stub
		String type = null;
		try {
		
			Connection con = ConnectionProvider.getCon();
			PreparedStatement stmt;
			stmt = con.prepareStatement("Select type FROM users WHERE username=?");
			stmt.setString(1,user);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				type = rs.getString("type");
			
			}
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return type;
		
	}

	public static int insertdb(String user_register, String surname, String name, String pass_register, String email, String type_register) {
		// TODO Auto-generated method stub
		int user_registered = 0;
		try {
			
			Connection con = ConnectionProvider.getCon();
			PreparedStatement stmt;
			stmt = con.prepareStatement("INSERT INTO users VALUES (?,?,?,?,?,?)");
			stmt.setString(1,user_register);
			stmt.setString(2,pass_register);
			stmt.setString(3,surname);
			stmt.setString(4,name);
			stmt.setString(5,email);
			stmt.setString(6,type_register);
			user_registered = stmt.executeUpdate();
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return user_registered;
	}

	public static boolean email_exists(String recover_mail) {
		// TODO Auto-generated method stub
		boolean email_found = false;
		try {
		
			Connection con = ConnectionProvider.getCon();
			PreparedStatement stmt;
			stmt = con.prepareStatement("SELECT email FROM users WHERE email=?");
			stmt.setString(1,recover_mail);
			ResultSet rs = stmt.executeQuery();
			
			String email_exist = null;
			while(rs.next()) {
				email_exist = rs.getString("email");
			}
			if(email_exist != null) {
				email_found = true;	
			}
			con.close();
		
		}
		catch(SQLException e) {
			e.printStackTrace();
			
		}
		return email_found;
	}

	public static String get_pass_from_mail(String recover_mail) {
		String pass = null;
		try {
		
			Connection con = ConnectionProvider.getCon();
			PreparedStatement stmt;
			stmt = con.prepareStatement("Select password FROM users WHERE email=?");
			stmt.setString(1,recover_mail);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				pass = rs.getString("password");
			}
			con.close();
		
		}
		catch(SQLException e) {
			e.printStackTrace();
			
		}
		return pass;
	}

	public static void del_row_users(String username) {
		try {
			
			Connection con = ConnectionProvider.getCon();
			PreparedStatement stmt;
			stmt = con.prepareStatement("DELETE FROM users WHERE username=?");
			stmt.setString(1,username);
			stmt.executeUpdate();
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void del_row_restaurant(String name) {
		try {
			
			Connection con = ConnectionProvider.getCon();
			PreparedStatement stmt;
			stmt = con.prepareStatement("DELETE FROM restaurants WHERE name=?");
			stmt.setString(1,name);
			stmt.executeUpdate();
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void del_rowS_restaurants(String username) {
		try {
			
			Connection con = ConnectionProvider.getCon();
			PreparedStatement stmt;
			stmt = con.prepareStatement("DELETE FROM restaurants WHERE username=?");
			stmt.setString(1,username);
			stmt.executeUpdate();
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	public static Object get_pass_from_username(String username) {
		String pass = "no pass found";
		try {
			Connection con = ConnectionProvider.getCon();
			PreparedStatement stmt;
			stmt = con.prepareStatement("Select password FROM users WHERE username=?");
			stmt.setString(1,username);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				pass = rs.getString("password");
			}
			con.close();
		
		}
		catch(SQLException e) {
			e.printStackTrace();
			
		}
		return pass;
	}

	public static void change_pass(String username, String new_pass) {
		try {
			
			Connection con = ConnectionProvider.getCon();
			PreparedStatement stmt;
			stmt = con.prepareStatement("UPDATE users SET password=? WHERE username=?");
			stmt.setString(1,new_pass);
			stmt.setString(2,username);
			stmt.executeUpdate();
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	public static String get_mail(String username) {
		String email = "no mail";
		try {
			Connection con = ConnectionProvider.getCon();
			PreparedStatement stmt;
			stmt = con.prepareStatement("SELECT email FROM users WHERE username=?");
			stmt.setString(1,username);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				email = rs.getString("email");
			}
			con.close();
		
		}
		catch(SQLException e) {
			e.printStackTrace();
			
		}
		return email;
	}

	public static void insertdb_restaurant(String name, String address, String username, String email,String type_food, String information) {
		try {
			
			Connection con = ConnectionProvider.getCon();
			PreparedStatement stmt;
			stmt = con.prepareStatement("INSERT INTO restaurants VALUES (?,?,?,?,?,?,0,0,0)");
			stmt.setString(1,name);
			stmt.setString(2,address);
			stmt.setString(3,username);
			stmt.setString(4,email);
			stmt.setString(5,type_food);
			stmt.setString(6,information);
			stmt.executeUpdate();
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	public static boolean critic_exists(String username, String restaurant_name) {
		boolean exists = false;
		try {
		
			Connection con = ConnectionProvider.getCon();
			PreparedStatement stmt;
			stmt = con.prepareStatement("SELECT stars FROM critics WHERE username=? AND name=?");
			stmt.setString(1,username);
			stmt.setString(2,restaurant_name);
			ResultSet rs = stmt.executeQuery();
			
			String stars = null;
			while(rs.next()) {
				stars = rs.getString("stars");
			}
			if(stars != null) {
				exists = true;	
			}
			con.close();
		
		}
		catch(SQLException e) {
			e.printStackTrace();
			
		}
		return exists;
	}

	public static void update_critics(String username, String restaurant_name, int vote, String critic) {
		try {
			
			Connection con = ConnectionProvider.getCon();
			PreparedStatement stmt;
			stmt = con.prepareStatement("UPDATE critics SET stars=? , critic=? WHERE username=? AND name=?");
			stmt.setInt(1,vote);
			stmt.setString(2,critic);
			stmt.setString(3,username);
			stmt.setString(4,restaurant_name);
			stmt.executeUpdate();
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	public static void insertdb_critics(String username, String restaurant_name, int vote, String critic) {
		try {
			
			Connection con = ConnectionProvider.getCon();
			PreparedStatement stmt;
			stmt = con.prepareStatement("INSERT INTO critics VALUES (?,?,?,?)");
			stmt.setString(1,username);
			stmt.setString(2,restaurant_name);
			stmt.setInt(3,vote);
			stmt.setString(4,critic);
			stmt.executeUpdate();
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	

	public static int get_num_votes(String restaurant_name) {
		int weight = 0;
		try {
			Connection con = ConnectionProvider.getCon();
			PreparedStatement stmt;
			stmt = con.prepareStatement("SELECT COUNT(username) AS num_votes FROM critics WHERE name=?");
			stmt.setString(1,restaurant_name);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				weight = rs.getInt("num_votes");
			}
			con.close();
		
		}
		catch(SQLException e) {
			e.printStackTrace();
			
		}
		return weight;
	}

	public static int get_stars_avg(String restaurant_name) {
		int stars = 0;
		try {
			Connection con = ConnectionProvider.getCon();
			PreparedStatement stmt;
			stmt = con.prepareStatement("SELECT ROUND(AVG(stars),0) AS stars FROM critics WHERE name=?");
			stmt.setString(1,restaurant_name);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				stars = rs.getInt("stars");
			}
			con.close();
		
		}
		catch(SQLException e) {
			e.printStackTrace();
			
		}
		return stars;
	}

	public static void update_restaurant_stars(String restaurant_name, int num_votes, int stars, double weight) {
		try {
			
			Connection con = ConnectionProvider.getCon();
			PreparedStatement stmt;
			stmt = con.prepareStatement("UPDATE restaurants SET num_votes=? , stars=?, weight=? WHERE name=?");
			stmt.setInt(1,num_votes);
			stmt.setInt(2,stars);
			stmt.setDouble(3,weight);
			stmt.setString(4,restaurant_name);
			stmt.executeUpdate();
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	public static void del_user_critics(String choosen_user) {
		try {
			
			Connection con = ConnectionProvider.getCon();
			PreparedStatement stmt;
			stmt = con.prepareStatement("DELETE FROM critics WHERE username=?");
			stmt.setString(1,choosen_user);
			stmt.executeUpdate();
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	public static void del_restaurant_critics(String restaurant_name) {
		try {
			
			Connection con = ConnectionProvider.getCon();
			PreparedStatement stmt;
			stmt = con.prepareStatement("DELETE FROM critics WHERE name=?");
			stmt.setString(1,restaurant_name);
			stmt.executeUpdate();
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	public static void del_critic(String juror_name, String restaurant_name) {
try {
			
			Connection con = ConnectionProvider.getCon();
			PreparedStatement stmt;
			stmt = con.prepareStatement("DELETE FROM critics WHERE username=? AND name=?");
			stmt.setString(1,juror_name);
			stmt.setString(2,restaurant_name);
			stmt.executeUpdate();
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	

}
