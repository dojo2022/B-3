package model;

import java.io.Serializable;

public class Reaction implements Serializable{
	private String reaction_id;
	private String review_id;
	private String user_id;
	private String stamp_id;

	//引数があるコンストラクタ
	public Reaction(String reaction_id, String review_id, String user_id, String stamp_id) {
		super();
		this.reaction_id = reaction_id;
		this.review_id = review_id;
		this.user_id = user_id;
		this.stamp_id = stamp_id;
	}

	//引数がないコンストラクタ
	public Reaction() {
		super();
		this.reaction_id = "";
		this.review_id = "";
		this.user_id = "";
		this.stamp_id = "";
	}

	//getter/setter
	public String getReaction_id() {
		return reaction_id;
	}

	public void setReaction_id(String reaction_id) {
		this.reaction_id = reaction_id;
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

	public String getStamp_id() {
		return stamp_id;
	}

	public void setStamp_id(String stamp_id) {
		this.stamp_id = stamp_id;
	}

}
