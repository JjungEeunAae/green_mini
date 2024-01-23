package db.test;

public class MemberTest {
	private String id;
	private String pw;
	private String name;
	
	public void MamberTest() {};
	
	public void MamberTest(String id, String pw, String name, int state) {
		this.id = id;
		this.pw = pw;
		this.name = name;
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
}
