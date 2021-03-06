package model;

import java.io.Serializable;


public class Ranking implements Serializable {
	private String video_id;	    // 作品ID
	private String video_name;		// 作品名
	private int count;          // 投稿数
//	private String video_year;      // 年
//	private String video_time;  	// 再生時間
//	private String genre_id;		// ジャンルID

	//引数のあるコンストラクタ
		public Ranking(String video_id, String video_name, int count) {
			super();
			this. video_id= video_id;
			this.video_name = video_name;
			this.count = count;

		}
		//引数のないコンストラクタ
		public Ranking() {
			super();
			this.video_id = "";
			this.video_name = "";
			this.count = 0;

		}
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
		public  int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
}

