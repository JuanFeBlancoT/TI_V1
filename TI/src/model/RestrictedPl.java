package model;

public class RestrictedPl extends Playlist{
	//Constant
	public final static int MAX_USERS=5;
	//Atributes
	private String[] userNames;
	
	//Methods
	public RestrictedPl(int maxSongs, String name, String[] userNames){
		super(maxSongs, name);
		this.userNames=userNames;
	}
	
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