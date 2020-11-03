package model;

public abstract class Playlist{
	//attributes
	private String name;
	private int duration;
	//Relations
	private Genre genre;
	private Song[] songs;
	
	//Methods
	public Playlist(int maxSongs, String name){
		this.name=name;
		duration=0;
		genre=Genre.UNKNOWN;
		songs=new Song[maxSongs];
		
	}
	
	public String addSong(String title, String artist, String date, String songGenre, int duration){
		
		boolean stop=false;
		String message="Couldnt add song";
		
		for(int i=0;i<songs.length && !stop;i++){
			if(songs[i]==null){
				stop=true;
				songs[i]=new Song(title, artist, date, songGenre, duration);
				message="\nSong added succesfully to the playlist";
			}
		}
		return message;
	}//end addSong
	
	public String getName(){
		return name;
	}
	
}