package model;

import java.io.Serializable;

public class Review implements Serializable{
	private String review_id;
	private String video_id;
	private String user_id;
	private String review_contents;
	private String genre_id;
	private String feelcat_name1;
	private String feelcat_name2;
	private String star;
	private String review_date;

	//引数があるコンストラクタ
	public Review(String review_id, String video_id, String user_id, String review_contents, String genre_id,String feelcat_name1, String feelcat_name2, String star, String review_date) {
		super();
		this.review_id = review_id;
		this.video_id = video_id;
		this.user_id = user_id;
		this.review_contents = review_contents;
		this.genre_id = genre_id;
		this.feelcat_name1 = feelcat_name1;
		this.feelcat_name2 = feelcat_name2;
		this.star = star;
		this.review_date = review_date;
	}
	public Review( String video_id, String user_id, String review_contents, String genre_id,String feelcat_name1, String feelcat_name2, String star) {
		super();
		this.video_id = video_id;
		this.user_id = user_id;
		this.review_contents = review_contents;
		this.genre_id = genre_id;
		this.feelcat_name1 = feelcat_name1;
		this.feelcat_name2 = feelcat_name2;
		this.star = star;
	}

	//引数がないコンストラクタ
	public Review() {
		super();
		this.review_id = "";
		this.video_id = "";
		this.user_id = "";
		this.review_contents = "";
		this.genre_id = "";
		this.feelcat_name1 = "";
		this.feelcat_name2 = "";
		this.star = "";
		this.review_date = "";


	}

	public String getReview_id() {
		return review_id;
	}

	public void setReview_id(String review_id) {
		this.review_id = review_id;
	}

	public String getVideo_id() {
		return video_id;
	}

	public void setVideo_id(String video_id) {
		this.video_id = video_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getReview_contents() {
		return review_contents;
	}

	public void setReview_contents(String review_contents) {
		this.review_contents = review_contents;
	}

	public String getGenre_id() {
		return genre_id;
	}

	public void setGenre_id(String genre_id) {
		this.genre_id = genre_id;
	}

	public String getFeelcat_name1() {
		return feelcat_name1;
	}

	public void setFeelcat_name1(String feelcat_name1) {
		this.feelcat_name1 = feelcat_name1;
	}

	public String getFeelcat_name2() {
		return feelcat_name2;
	}

	public void setFeelcat_name2(String feelcat_name2) {
		this.feelcat_name2 = feelcat_name2;
	}

	public String getStar() {
		return star;
	}

	public void setStar(String star) {
		this.star = star;
	}

	public String getReview_date() {
		return review_date;
	}

	public void setReview_date(String review_date) {
		this.review_date = review_date;
	}
}
