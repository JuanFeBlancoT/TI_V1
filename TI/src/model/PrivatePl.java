package model;

public class PrivatePl extends Playlist{
	
	//attributes
	private String userName;
	//relations
	private User onlyUser;
	
	//Methods
	public PrivatePl(int maxSongs, String name, String userName){
		super(maxSongs, name);
		this.userName=userName;
	}

}