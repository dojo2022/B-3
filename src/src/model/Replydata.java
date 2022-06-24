package model;

import java.io.Serializable;

public class Replydata implements Serializable{
	private String user_name;
	private String user_img;
	private String reply_date;
	private String reply_contents;

	//引数があるコンストラクタ
	public Replydata(String user_name, String user_img, String reply_date, String reply_contents) {
		super();
		this.user_name = user_name;
		this.user_img = user_img;
		this.reply_date = reply_date;
		this.reply_contents = reply_contents;
	}

	//引数がないコンストラクタ
	public Replydata() {
		super();
		this.user_name = "";
		this.user_img = "";
		this.reply_date = "";
		this.reply_contents = "";
	}

	//getter/setter
	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_img() {
		return user_img;
	}

	public void setUser_img(String user_img) {
		this.user_img = user_img;
	}

	public String getReply_date() {
		return reply_date;
	}

	public void setReply_date(String reply_date) {
		this.reply_date = reply_date;
	}

	public String getReply_contents() {
		return reply_contents;
	}

	public void setReply_contents(String reply_contents) {
		this.reply_contents = reply_contents;
	}

}
