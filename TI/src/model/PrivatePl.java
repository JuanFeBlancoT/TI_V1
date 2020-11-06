package model;

public class PrivatePl extends Playlist{
	
	//relations
	private User onlyUser;
	
	//Methods
	public PrivatePl(int maxSongs, String name, User user){
		super(maxSongs, name);
		onlyUser=user;
	}
	

}