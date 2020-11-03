package model;

public class RestrictedPl extends Playlist{
	
	//attributes
	private String[] userNames;
	//relations
	private User[] usersA;
	
	//Methods
	public RestrictedPl(int maxSongs, String name, String[] userNames){
		super(maxSongs, name);
		this.userNames=userNames;	
	}
	
}