package model;

public class MasterVideo {
	private String id;
	private String name;
	private int year;
	private int time;
	private String genreID;

	public MasterVideo(String id, String name, int year, int time, String genreID) {
		this.id = id;
		this.name = name;
		this.year = year;
		this.time = time;
		this.genreID = genreID;
	}

	public MasterVideo() {
		this(null, null, -1, -1, null);
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getGenreID() {
		return genreID;
	}
	public void setGenreID(String genreID) {
		this.genreID = genreID;
	}
}
