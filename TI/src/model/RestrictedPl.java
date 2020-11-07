package model;

public class RestrictedPl extends Playlist{
	//Constant
	public final static int MAX_USERS=5;
	//Atributes
	private String[] userNames;
	//relations
	private User[] usersA;
	
	//Methods
	public RestrictedPl(int maxSongs, String name, String[] userNames){
		super(maxSongs, name);
		usersA= new User[MAX_USERS];
		this.userNames=userNames;
	}
	
}