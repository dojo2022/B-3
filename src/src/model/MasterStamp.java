package model;

import java.io.Serializable;

public class MasterStamp implements Serializable{
	private String stamp_id;
	private String stamp_name;

	//引数があるコンストラクタ
	public MasterStamp(String stamp_id, String stamp_name) {
		super();
		this.stamp_id = stamp_id;
		this.stamp_name = stamp_name;
	}

	//引数がないコンストラクタ
	public MasterStamp() {
		super();
		this.stamp_id = "";
		this.stamp_name = "";
	}

	//getter/setter
	public String getStamp_id() {
		return stamp_id;
	}

	public void setStamp_id(String stamp_id) {
		this.stamp_id = stamp_id;
	}

	public String getStamp_name() {
		return stamp_name;
	}

	public void setStamp_name(String stamp_name) {
		this.stamp_name = stamp_name;
	}

}
