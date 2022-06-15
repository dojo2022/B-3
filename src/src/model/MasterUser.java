package model;
import java.io.Serializable;

public class MasterUser implements Serializable {
	private String id;				//ID
	private String user_id;			//ユーザーID
	private String user_mail;		//メールアドレス
	private String user_pw;			//パスワード
	private String user_name;		//ユーザー名
	private String user_pf;			//プロフィール文
	private String user_img;		//アイコン画像
	private String user_hd;			//ヘッダー画像

	//引数があるコンストラクタ
	public MasterUser(String id, String user_id, String user_mail, String user_pw, String user_name, String user_pf,
			String user_img, String user_hd) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.user_mail = user_mail;
		this.user_pw = user_pw;
		this.user_name = user_name;
		this.user_pf = user_pf;
		this.user_img = user_img;
		this.user_hd = user_hd;
	}

	//引数がないコンストラクタ
	public MasterUser() {
		super();
		this.id = "";
		this.user_id = "";
		this.user_mail = "";
		this.user_pw = "";
		this.user_name = "";
		this.user_pf = "";
		this.user_img = "";
		this.user_hd = "";
	}

	//getter/setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_mail() {
		return user_mail;
	}

	public void setUser_mail(String user_mail) {
		this.user_mail = user_mail;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_pf() {
		return user_pf;
	}

	public void setUser_pf(String user_pf) {
		this.user_pf = user_pf;
	}

	public String getUser_img() {
		return user_img;
	}

	public void setUser_img(String user_img) {
		this.user_img = user_img;
	}

	public String getUser_hd() {
		return user_hd;
	}

	public void setUser_hd(String user_hd) {
		this.user_hd = user_hd;
	}


}