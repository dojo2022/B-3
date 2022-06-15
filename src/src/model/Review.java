package model;

import java.io.Serializable;
import java.sql.Date;

public class Review implements Serializable{
	private String review_id;
	private String video_id;
	private String user_id;
	private String review_contents;
	private String genre_id;
	private String feelcat_name1;
	private String feelcat_name2;
	private String star;
	private Date review_date;

	//引数があるコンストラクタ
	public Review(String review_id, String video_id, String user_id, String review_contents, String genre_id,
			String feelcat_name1, String feelcat_name2, String star, Date review_date) {
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
		this.review_date ;
	}
}
