package model;

import java.io.Serializable;

public class Follow implements Serializable{
	private String user_id;			//ユーザーID
	private String user_name;
	private String user_pf;			//プロフィール文
	private String user_img;		//アイコン画像
	private boolean follow_exchange;

	//引数があるコンストラクタ
	public Follow(String user_id, String user_name, String user_pf, String user_img, boolean follow_exchange) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_pf = user_pf;
		this.user_img = user_img;
		this.follow_exchange = follow_exchange;
	}

	//引数がないコンストラクタ
	public Follow() {
		super();
		this.user_id = "";
		this.user_name = "";
		this.user_pf = "";
		this.user_img = "";
		this.follow_exchange = false;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_pf() {
		return user_pf;
	}

	public void setUser_pf(String user_pf) {
		this.user_pf = user_pf;
	}

	public String getUser_img() {
		return user_img;
	}

	public void setUser_img(String user_img) {
		this.user_img = user_img;
	}

	public boolean isFollow_exchange() {
		return follow_exchange;
	}

	public void setFollow_exchange(boolean follow_exchange) {
		this.follow_exchange = follow_exchange;
	}

}




