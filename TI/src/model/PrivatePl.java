package model;

public class PrivatePl extends Playlist{
	
	//relations
	private User onlyUser;
	
	//Methods
	public PrivatePl(int maxSongs, String name, User user){
		super(maxSongs, name);
		onlyUser=user;
	}
	
	
	/*public String showPlaylist(){
		
		
		String message=("\n************** Playlist **************"+
		"\n** Title: "+ getName() +
		"\n** Duration: "+ getTime() + 
		"\n** Genre: "+ genreList +
		"\n** Owner: "+ onlyUser.getName());
	} */

}