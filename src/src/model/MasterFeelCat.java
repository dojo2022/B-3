package model;

import java.io.Serializable;

public class MasterFeelCat implements Serializable  {
	private String feelcat_id;
	private String feelcat_name;

	//引数があるコンストラクタ
	public MasterFeelCat(String feelcat_id, String feelcat_name) {
		super();
		this.feelcat_id = feelcat_id;
		this.feelcat_name = feelcat_name;
	}

	//引数がないコンストラクタ
	public MasterFeelCat() {
		super();
		this.feelcat_id = "";
		this.feelcat_name = "";
	}

	//getter/setter
	public String getFeelcat_id() {
		return feelcat_id;
	}

	public void setFeelcat_id(String feelcat_id) {
		this.feelcat_id = feelcat_id;
	}

	public String getFeelcat_name() {
		return feelcat_name;
	}

	public void setFeelcat_name(String feelcat_name) {
		this.feelcat_name = feelcat_name;
	}

}
