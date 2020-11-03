package model;

public class PublicPl extends Playlist{
	
	//attributes
	private int score;
	
	//Methods
	public PublicPl(int maxSongs, String name){
		super(maxSongs, name);
		score=0;
	}
}