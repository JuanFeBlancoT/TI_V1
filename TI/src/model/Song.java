package model;

public class Song{
	//Atributes
	private String title;
	private String artist;
	private String date;
	private int duration;
	
	//Relations
	private Genre genre;
	
	//Methods
	/**
	* Song: It is the constructor of the Song class <br>
	* <b> pre </b> the songGenre must be a string equal to one of the Genre enum types <br>
	* <b> pos </b> <br>
	* @param title Is the title of the song
	* @param artist Is the artist name
	* @param date Is the date in which the song was released
	* @param songGenre Is the genre of the song
	* @param duration is the duration of the song in integer secods
	*/
	public Song(String title, String artist, String date, String songGenre, int duration){
		this.title=title;
		this.artist=artist;
		this.date=date;
		this.duration=duration;
		this.genre=Genre.valueOf(songGenre);
		
	}
	
	public String getTitle(){
		return title;
	}
	
	public String getArtist(){
		return artist;
	}
	
	public int getDuration(){
		return duration;
	}
	
	public Genre getGenre(){
		return genre;
	}
	
	/**
	* showGenre: It takes the enum value of genre and return a string with the same value but a different format <br>
	* <b> pre </b> <br>
	* <b> pos </b> <br>
	* @return categoryS Is the same genre but displayed different
	*/
	public String showGenre(){
		String categoryS="";
		if(genre==Genre.ROCK){
			categoryS="Rock";
		}else if(genre==Genre.HIP_HOP){
			categoryS="Hip hop";
		}else if(genre==Genre.CLASSIC_MUSIC){
			categoryS="Classic music";
		}else if(genre==Genre.REGGAE){
			categoryS="Reggea";
		}else if(genre==Genre.SALSA){
			categoryS="Salsa";
		}else if(genre==Genre.METAL){
			categoryS="Metal";
		}
		return categoryS;
	}//end showCategory
	
	/**
	* getTime: It takes the current duration of the song and returns it into an specified format <br>
	* <b> pre </b> <br>
	* <b> pos </b> <br>
	* @return message Is a message that shows the current song duration in a specified format
	*/
	public String getTime(){
		int mins=0;
		int segs=0;
		String message="";
		if(duration>=60){
			mins=(int)Math.floor(duration/60);
			segs=duration-(mins*60);
		}else{
			segs=duration;
		}
		if(mins==0){
			message="00:"+segs;
		}else{
			message=mins+":"+segs;
		}
		return message;
	}//end getTime
	
	/**
	* showSong: It displays the informtion of the song <br>
	* <b> pre </b> <br>
	* <b> pos </b> <br>
	* @return message Is the message with all the required information
	*/
	public String showSong(){
						
		String message=("\n************** Song **************"+
		"\n** Title: "+ getTitle() +
		"\n** Duration: "+ getTime() + 
		"\n** Genre: "+ showGenre());
			
		return message;
	}//end showSongs
	
}