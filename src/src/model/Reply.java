package model;

import java.io.Serializable;

public class Reply implements Serializable {
	private String reply_id;
	private String review_id;
	private String user_id;
	private String reply_contents;
	private String reply_date;
	private String user_name;

	//引数があるコンストラクタ
	public Reply(String reply_id, String review_id, String user_id, String reply_contents, String reply_date) {
		super();
		this.reply_id = reply_id;
		this.review_id = review_id;
		this.user_id = user_id;
		this.reply_contents = reply_contents;
		this.reply_date = reply_date;
	}
	public Reply(String reply_id, String review_id, String user_id, String reply_contents, String reply_date,String user_name) {
		super();
		this.reply_id = reply_id;
		this.review_id = review_id;
		this.user_id = user_id;
		this.reply_contents = reply_contents;
		this.reply_date = reply_date;
		this.user_name = user_name;
	}

	//引数がないコンストラクタ
	public Reply() {
		super();
		this.reply_id = "";
		this.review_id = "";
		this.user_id = "";
		this.reply_contents = "";
		this.reply_date = "" ;
		this.user_name = "";
	}

	//getter/setter
	public String getReply_id() {
		return reply_id;
	}

	public void setReply_id(String reply_id) {
		this.reply_id = reply_id;
	}

	public String getReview_id() {
		return review_id;
	}

	public void setReview_id(String review_id) {
		this.review_id = review_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getReply_contents() {
		return reply_contents;
	}

	public void setReply_contents(String reply_contents) {
		this.reply_contents = reply_contents;
	}

	public String getReply_date() {
		return reply_date;
	}

	public void setReply_date(String reply_date) {
		this.reply_date = reply_date;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

}
