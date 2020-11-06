package model;

public class Song{
	
	private String title;
	private String artist;
	private String date;
	private int duration;
	
	//Relations
	private Genre genre;
	
	//Methods
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
	
	public String showSong(){
						
		String message=("\n************** Song **************"+
		"\n** Title: "+ getTitle() +
		"\n** Duration: "+ getTime() + 
		"\n** Genre: "+ showGenre());
			
		return message;
	}//end showSongs
	
}