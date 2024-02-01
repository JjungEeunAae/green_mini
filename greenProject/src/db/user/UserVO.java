package db.user;

public class UserVO {
	private String id;
	private String pw;
	private String name;
	
	public UserVO() {};

	public UserVO(String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	
	public UserVO(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", pw=" + pw + ", name=" + name + "]";
	}
	
	
}
