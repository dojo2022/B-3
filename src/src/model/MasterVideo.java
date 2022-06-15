package model;

import java.io.Serializable;

public class MasterVideo implements Serializable{
	private String video_id;
	private String video_name;
	private int video_year;
	private int video_time;
	private String genre_id;

	//引数があるコンストラクタ
	public MasterVideo(String video_id, String video_name, int video_year, int video_time, String genre_id) {
		super();
		this.video_id = video_id;
		this.video_name = video_name;
		this.video_year = video_year;
		this.video_time = video_time;
		this.genre_id = genre_id;
	}

	//引数がないコンストラクタ
	public MasterVideo() {
		super();
		this.video_id = "";
		this.video_name = "";
		this.video_year;
		this.video_time;
		this.genre_id = "";
	}

	//getter/setter
	public String getVideo_id() {
		return video_id;
	}

	public void setVideo_id(String video_id) {
		this.video_id = video_id;
	}

	public String getVideo_name() {
		return video_name;
	}

	public void setVideo_name(String video_name) {
		this.video_name = video_name;
	}

	public int getVideo_year() {
		return video_year;
	}

	public void setVideo_year(int video_year) {
		this.video_year = video_year;
	}

	public int getVideo_time() {
		return video_time;
	}

	public void setVideo_time(int video_time) {
		this.video_time = video_time;
	}

	public String getGenre_id() {
		return genre_id;
	}

	public void setGenre_id(String genre_id) {
		this.genre_id = genre_id;
	}

}
