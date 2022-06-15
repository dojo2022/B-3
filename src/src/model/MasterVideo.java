package model;

import java.io.Serializable;

<<<<<<< Updated upstream
public class MasterVideo implements Serializable{
	private String video_id;
	private String video_name;
	private int video_year;
	private int video_time;
	private String genre_id;

	//引数があるコンストラクタ
	public MasterVideo(String video_id, String video_name, int video_year, int video_time, String genre_id) {
=======
public class MasterVideo implements Serializable {
	private String video_id;	    // 作品ID
	private String video_name;		// 作品名
	private String video_year;      // 年
	private String video_time;  	// 再生時間
	private String genre_id;		// ジャンルID

	// 引数があるコンストラクタ
	public MasterVideo(String video_id, String video_name, String video_year, String video_timee, String genre_idt) {
>>>>>>> Stashed changes
		super();
		this.video_id = video_id;
		this.video_name = video_name;
		this.video_year = video_year;
		this.video_time = video_time;
		this.genre_id = genre_id;
	}

<<<<<<< Updated upstream
	//引数がないコンストラクタ
=======
	// 引数がないコンストラクタ(デフォルトコンストラクタ)
>>>>>>> Stashed changes
	public MasterVideo() {
		super();
		this.video_id = "";
		this.video_name = "";
<<<<<<< Updated upstream
		this.video_year;
		this.video_time;
		this.genre_id = "";
	}

	//getter/setter
=======
		this.video_year = "";
		this.video_time = "";
		this.genre_id = "";
	}

>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
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
=======
	public String getVideo_year() {
		return video_year;
	}

	public void setVideo_year(String video_year) {
		this.video_year = video_year;
	}

	public String getVideo_time() {
		return video_time;
	}

	public void setVideo_time(String video_time) {
>>>>>>> Stashed changes
		this.video_time = video_time;
	}

	public String getGenre_id() {
		return genre_id;
	}

	public void setGenre_id(String genre_id) {
		this.genre_id = genre_id;
	}
<<<<<<< Updated upstream
=======


>>>>>>> Stashed changes

}
