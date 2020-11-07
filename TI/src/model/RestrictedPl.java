package model;

public class RestrictedPl extends Playlist{
	//Constant
	public final static int MAX_USERS=5;
	//Atributes
	private String[] userNames;
	
	//Methods
	/**
	* PrivatePl: It is the constructor of the RestrictedPl class <br>
	* <b> pre </b> <br>
	* <b> pos </b> <br>
	* @param maxSongs is the maximun number of songs a playlist can have
	* @param name The name of the playlist
	* @param userNames The chain of strings with the usernames of the users that have access to the playlist
	*/
	public RestrictedPl(int maxSongs, String name, String[] userNames){
		super(maxSongs, name);
		this.userNames=userNames;
	}
	
	/**
	* showPlaylist: It overrites the method of Playlist and displays the general informtion plus the specific information of the restricted playlist <br>
	* <b> pre </b> <br>
	* <b> pos </b> <br>
	* @return message Is the message with all the required information
	*/
	@Override
	public String showPlaylist(){
		String message=super.showPlaylist();
		
		String owners="";

		for(int i=0;i<MAX_USERS && userNames[i]!=null;i++){
			owners+=userNames[i]+", ";
		}
		
		message+="\n** Owners: "+ owners;
		
		return message;
	} 
	
}