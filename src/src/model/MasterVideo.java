package model;
import java.io.Serializable;

public class MasterVideo implements Serializable{
	private String video_id;	    // 作品ID
	private String video_name;		// 作品名
	private String video_year;      // 年
	private String video_time;  	// 再生時間
	private String genre_id;		// ジャンルID

	// 引数があるコンストラクタ
	public MasterVideo(String video_id, String video_name, String video_year, String video_time, String genre_id) {
		super();
		this.video_id = video_id;
		this.video_name = video_name;
		this.video_year = video_year;
		this.video_time = video_time;
		this.genre_id = genre_id;
	}

	// 引数がないコンストラクタ(デフォルトコンストラクタ)
	public MasterVideo() {
		super();
		this.video_id = "";
		this.video_name = "";
		this.video_year = "";
		this.video_time = "";
		this.genre_id = "";
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
		this.video_time = video_time;
	}

	public String getGenre_id() {
		return genre_id;
	}

	public void setGenre_id(String genre_id) {
		this.genre_id = genre_id;
	}
}
