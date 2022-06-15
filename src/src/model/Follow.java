package model;

import java.io.Serializable;

public class Follow implements Serializable{
	private String id;				//ID
	private String user_id;			//ユーザーID
	private String follow_id;		//フォローID

	//引数があるコンストラクタ
	public Follow(String id, String user_id, String follow_id) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.follow_id = follow_id;
	}

	//引数がないコンストラクタ
	public Follow() {
		super();
		this.id = "";
		this.user_id = "";
		this.follow_id = "";
	}

	//getter/setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getFollow_id() {
		return follow_id;
	}

	public void setFollow_id(String follow_id) {
		this.follow_id = follow_id;
	}
}




