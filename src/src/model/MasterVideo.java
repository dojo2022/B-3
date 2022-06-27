package model;
import java.io.Serializable;

public class MasterVideo implements Serializable{
	private String video_id;	    // 作品ID
	private String video_name;		// 作品名
	private int    video_year;      // 年
	private int    video_time;  	// 再生時間
	private String genre_id;		// ジャンルID
	private String genre_name;		// ジャンルID


	// 引数があるコンストラクタ
	public MasterVideo(String video_id, String video_name, int video_year, int video_time, String genre_id, String genre_name) {
		super();
		this.video_id = video_id;
		this.video_name = video_name;
		this.video_year = video_year;
		this.video_time = video_time;
		this.genre_id = genre_id;
		this.genre_name = genre_name;

	}

	// 引数がないコンストラクタ(デフォルトコンストラクタ)
	public MasterVideo() {
		super();
		this.video_id = "";
		this.video_name = "";
		this.video_year = -1;
		this.video_time = -1;
		this.genre_id = "";
		this.genre_name = "";
	}

	// ゲッタとセッタ
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

	public String getGenre_name() {
		return genre_name;
	}

	public void setGenre_name(String genre_name) {
		this.genre_name = genre_name;
	}


}
