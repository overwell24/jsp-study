package post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBConnect;

public class PostDAO {
	
    Connection conn;
    PreparedStatement pstmt;
    ResultSet rs;
    
    public PostDAO() {
    	conn = DBConnect.getConnection();
    }
    
    // Get PostList
    public ArrayList<PostDTO> getPostList(){
    	
    	ArrayList<PostDTO> postList = new ArrayList<PostDTO>(); 
    	
    	String sql = "SELECT * from post";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				PostDTO post = new PostDTO();
				
				// result 순서 == 스키마 생성 순서 
				post.setPostID(rs.getInt(1));
				post.setUserID(rs.getString(2));
				post.setTitle(rs.getString(3));
				post.setContent(rs.getString(4));
				post.setCreatedDate(rs.getTimestamp(5));
				
				postList.add(post);
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
    	return postList;
    }
    // Get Post
    public PostDTO getPost(String postID) {
        String sql = "SELECT * from post where post_id = ?";
        PostDTO post = null;
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, postID);
            rs = pstmt.executeQuery();
            
            // ResultSet의 커서를 이동시키고 데이터를 가져옴
            if (rs.next()) {
                post = new PostDTO();
                post.setPostID(rs.getInt("post_id"));
                post.setUserID(rs.getString("user_id"));
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                post.setCreatedDate(rs.getTimestamp("created_date"));
            }

        } catch (SQLException e) {
            // 예외 처리
            e.printStackTrace();
        } 
        return post;
    }

    
    // Create Post
    public boolean createPost(PostDTO post) {    	
        String sql = "INSERT INTO post (user_id, title, content) VALUES (?, ?, ?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, post.getUserID());
			pstmt.setString(2, post.getTitle());
			pstmt.setString(3, post.getContent());

			int result = pstmt.executeUpdate();
			
			return result > 0;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    	return false;
    }
    
    // delete Post
    public boolean deletePost(String postID) {
    	String deleteCommentSQL = "DELETE FROM comment WHERE post_id = ?";
    	String deletePostSQL = "DELETE FROM post WHERE post_id = ?";
    	
    	try {
    		boolean hasComments = checkIfCommentsExist(postID);
			
    		if (hasComments) {
        		pstmt = conn.prepareStatement(deleteCommentSQL);
        		pstmt.setString(1, postID);
        		int result1 = pstmt.executeUpdate();

        		pstmt = conn.prepareStatement(deletePostSQL);
        		pstmt.setString(1, postID);
        		int result2 = pstmt.executeUpdate();
    		
        		if (result1 > 0 && result2 > 0) {
        			return true;
    			}else {
    				return false;
    			}
    		}
    		else {
    			pstmt = conn.prepareStatement(deletePostSQL);
        		pstmt.setString(1, postID);
        		int result = pstmt.executeUpdate();
        		
        		if (result > 0) {
        			return true;
        		}else {
        			return false;
        		}
        		
    		}

    	} catch (Exception e) {
			// TODO: handle exception
		}
    	return false;
    }
    
    private boolean checkIfCommentsExist(String postID) {
    	String sql = "SELECT count(*) FROM comment WHERE post_id = ?";
    	try {
			pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, postID);
	        rs = pstmt.executeQuery();
	        
	        if(rs.next()) {		
				int cnt = rs.getInt(1);
				if(cnt > 0) {
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
    
    public boolean update(PostDTO post) {
    	String sql = "UPDATE post SET title = ?, content = ? WHERE post_id = ?";

    	try {
        	pstmt = conn.prepareStatement(sql);
        	
			pstmt.setString(1, post.getTitle());
			pstmt.setString(2, post.getContent());
			pstmt.setInt(3, post.getPostID());
			
    		int result = pstmt.executeUpdate();
    		if (result > 0) {
    			return true;
    		}else {
    			return false;
    		}
 
    		
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return false;
    }
}
