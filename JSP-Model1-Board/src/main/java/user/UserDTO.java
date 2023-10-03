package user;

public class UserDTO {
	
	private String userID;
	private String userPasswd;
	
	public UserDTO() {
		// beans 필수! 
	}
	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserPasswd() {
		return userPasswd;
	}

	public void setUserPasswd(String userPasswd) {
		this.userPasswd = userPasswd;
	}
}
