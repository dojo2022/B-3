package model;

import java.io.Serializable;

public class TopReply implements Serializable {
	private String user_name;
	private String reply_contents;

	//コンストラクタあり
		public TopReply(String user_name, String reply_contents) {
			super();
			this.user_name = user_name;
			this.reply_contents = reply_contents;
		}

		//コンストラクタなし
		public TopReply() {
			super();
			this.user_name = "";
			this.reply_contents = "";
		}

	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getReply_contents() {
		return reply_contents;
	}
	public void setReply_contents(String reply_contents) {
		this.reply_contents = reply_contents;
	}
}