package model;

public class PrivatePl extends Playlist{
	
	//relations
	private User onlyUser;
	
	//Methods
	/**
	* PrivatePl: It is the constructor of the PrivatePl class <br>
	* <b> pre </b> <br>
	* <b> pos </b> <br>
	* @param maxSongs is the maximun number of songs a playlist can have
	* @param name The name of the playlist
	* @param user The object User that has access to the playlist
	*/
	public PrivatePl(int maxSongs, String name, User user){
		super(maxSongs, name);
		onlyUser=user;
	}
	
	/**
	* showPlaylist: It overrites the method of Playlist and displays the general informtion plus the specific information of the private playlist <br>
	* <b> pre </b> <br>
	* <b> pos </b> <br>
	* @return message Is the message with all the required information
	*/
	@Override
	public String showPlaylist(){
		String message=super.showPlaylist();

		message+="\n** Owner: "+ onlyUser.getName();
		
		return message;
	} 

}