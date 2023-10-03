package comment;

import java.sql.Timestamp;

public class CommentDTO {
	
	private int commentID;
	private int postID;
	private String userID;
	private String text; 
	private Timestamp createdDate;
	
	public CommentDTO() {

	}
	
	public int getCommentID() {
		return commentID;
	}
	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}
	public int getPostID() {
		return postID;
	}
	public void setPostID(int postID) {
		this.postID = postID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
