package model;

public class Song{
	
	private String title;
	private String artist;
	private String date;
	private int duration;
	
	//Methods
	public Song(String title, String artist, String date, int duration){
		this.title=title;
		this.artist=artist;
		this.date=date;
		this.duration=duration;
	}
}