package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBConnect;

public class UserDAO {
	

    Connection conn;
    PreparedStatement pstmt;
    ResultSet rs;
    
    // Database connect
    public UserDAO() {
    	conn = DBConnect.getConnection(); 
    }
    
    // login
    public boolean login(UserDTO user) {
    	String sql = "SELECT user_id FROM USER WHERE user_passwd = ?";
    	
    	try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserID());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				if (rs.getString(1).equals(user.getUserPasswd())) {
					return true;
				}else {
					return false;
				}
			}
    	} catch (SQLException e) {
			e.printStackTrace();
		}
    	return false;
    }
    
    
    // register
    public boolean register(UserDTO user) {
    	
    	String sql = "INSERT INTO user values(?, ?)";
    	try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserID());
			pstmt.setString(2, user.getUserPasswd());
			
			int result = pstmt.executeUpdate();
		
			return result > 0;
    	} catch (SQLException e) {
			e.printStackTrace();
		}
    	return false;
    }

}
