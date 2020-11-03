package model;

public abstract class Playlist{
	//attributes
	private int genreC=1;
	private String name;
	private int duration;
	//Relations
	private Genre[] genres;
	private Song[] songs;
	
	//Methods
	public Playlist(int maxSongs, String name){
		this.name=name;
		duration=0;
		genres=new Genre[genreC];
		genres[0]=Genre.UNKNOWN;
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
	
	public int getDuration(){
		return duration;
	}
	
	public void setDuration(int duration){
		this.duration=duration;
	}
	
	/*public void addGenre (String genre){
		
		String playGenre="";
		if(genre==Genre.ROCK){
			playGenre="Rock";
		}else if(genre==Genre.HIP_HOP){
			playGenre="Hip hop";
		}else if(genre==Genre.CLASSIC_MUSIC){
			playGenre="Classic music";
		}else if(genre==Genre.REGGAE){
			playGenre="Reggea";
		}else if(genre==Genre.SALSA){
			playGenre="Salsa";
		}else if(genre==Genre.METAL){
			playGenre="Metal";
		}
		
		for(int i=0;i<genres.length;i++){
			if(genres[i]=Genre.ROCK){
				
			}
			genres[0]=Genre.valueOf(playGenre);
		}
		
		

	}*/
	
	/*public String toString(){
		String message="";
	}*/
	
}