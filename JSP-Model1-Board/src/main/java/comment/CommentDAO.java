package comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBConnect;

public class CommentDAO {
    
	Connection conn;
    PreparedStatement pstmt;
    ResultSet rs;
	
    public CommentDAO() {
    	conn = DBConnect.getConnection();
	}
    
    public ArrayList<CommentDTO> getCommentList(String postID) {
    	ArrayList<CommentDTO> commentList = new ArrayList<CommentDTO>();
    	String sql = "SELECT user_id, text, created_date from comment where post_id = ?";
    	
    	CommentDTO comment = null;
    	
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, postID);
            rs = pstmt.executeQuery();
            
			while(rs.next()) {
				comment = new CommentDTO();
				
				comment.setUserID(rs.getString(1));
				comment.setText(rs.getString(2));
				comment.setCreatedDate(rs.getTimestamp(3));
				
				commentList.add(comment);
			}

        } catch (SQLException e) {
            // 예외 처리
            e.printStackTrace();
        } 
        return commentList;
    }

    	
    	

    
    public boolean createComment(CommentDTO comment) {
    	String sql = "INSERT INTO comment (user_id, post_id, text)\n"
    			+ "VALUES (?, ?, ?)";
    	
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, comment.getUserID());
			pstmt.setInt(2, comment.getPostID());
			pstmt.setString(3, comment.getText());

			int result = pstmt.executeUpdate();
			
			return result > 0;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    	return false;
    }
}
