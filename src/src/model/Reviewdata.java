package model;

import java.io.Serializable;

public class Reviewdata implements Serializable{
	private String user_name;
	private String user_img;
	private String video_name;
	private String star;
	private String review_date;
	private String genre_name;
	private String feelcat_name1;
	private String feelcat_name2;
	private String review_contents;

	//引数があるコンストラクタ
	public Reviewdata(String user_name, String user_img, String video_name, String star, String review_date, String genre_name, String feelcat_name1, String feelcat_name2, String review_contents) {
		super();
		this.user_name = user_name;
		this.user_img = user_img;
		this.video_name = video_name;
		this.star = star;
		this.review_date = review_date;
		this.genre_name = genre_name;
		this.feelcat_name1 = feelcat_name1;
		this.feelcat_name2 = feelcat_name2;
		this.review_contents = review_contents;
	}

	//引数がないコンストラクタ
	public Reviewdata() {
		super();
		this.user_name = "";
		this.user_img = "";
		this.video_name = "";
		this.star = "";
		this.review_date = "";
		this.genre_name = "";
		this.feelcat_name1 = "";
		this.feelcat_name2 = "";
		this.review_contents = "";
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

	public void seUser_imgt(String user_img) {
		this.user_img = user_img;
	}

	public String getVideo_name() {
		return video_name;
	}

	public void setVideo_name(String video_name) {
		this.video_name = video_name;
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

	public String getGenre_name() {
		return genre_name;
	}

	public void setGenre_name(String genre_name) {
		this.genre_name = genre_name;
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

	public String getReview_contents() {
		return review_contents;
	}

	public void setReview_contents(String review_contents) {
		this.review_contents = review_contents;
	}

}
