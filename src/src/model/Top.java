package model;

import java.io.Serializable;

public class Top implements Serializable{
	private String user_name;
	private String user_img;
	private String video_name;
	private String review_contents;
	private String review_date;
	private String user_id;
	private String genre_name;


	//引数があるコンストラクタ
	public Top(String user_name, String user_img, String video_name, String review_contents, String review_date, String user_id, String genre_name) {
		super();
		this.user_name = user_name;
		this.user_img = user_img;
		this.video_name = video_name;
		this.review_contents = review_contents;
		this.review_date = review_date;
		this.user_id = user_id;
		this.genre_name = genre_name;
	}

	//引数がないコンストラクタ
	public Top() {
		super();
		this.user_name = "";
		this.user_img = "";
		this.video_name = "";
		this.review_contents = "";
		this.review_date = "";
		this.user_id = "";
		this.genre_name = "";
	}

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

	public String getVideo_name() {
		return video_name;
	}

	public void setVideo_name(String video_name) {
		this.video_name = video_name;
	}

	public String getReview_contents() {
		return review_contents;
	}

	public void setReview_contents(String review_contents) {
		this.review_contents = review_contents;
	}

	public String getReview_date() {
		return review_date;
	}

	public void setReview_date(String review_date) {
		this.review_date = review_date;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getGenre_name() {
		return genre_name;
	}

	public void setGenre_name(String genre_name) {
		this.genre_name = genre_name;
	}

}