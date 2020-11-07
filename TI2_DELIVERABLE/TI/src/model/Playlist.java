package model;

public abstract class Playlist{
	//attributes
	public final static int GENRE_SIZE=6;
	private String name;
	private int duration;
	//Relations
	private Genre[] genres;
	private Song[] songs;
	
	//Methods
	
	/**
	* Playlist: Is the constructor of the class Playlist <br>
	* <b> pre </b> <br>
	* <b> pos </b> Generates an array of genres and songs <br>
	* @param maxSongs It is the maximun amount of songs a playlist can have
	* @param name Is the name of the playlist
	*/
	public Playlist(int maxSongs, String name){
		this.name=name;
		duration=0;
		genres=new Genre[GENRE_SIZE];
		songs=new Song[maxSongs];
	}
	
	/**
	* addSong: It adds an object song to the playlist  array of songs <br>
	* <b> pre </b> The new song must be an existing object within the pool array <br>
	* <b> pos </b> The array of songs of this playlist its gonna fill in one box <br>
	* @param newSong It is the object song that is going to be added to the array
	* @return message Is a message that informs the user about the state of the procedure
	*/
	public String addSong(Song newSong){
		
		boolean stop=false;
		String message="Couldnt add song";
		
		for(int i=0;i<songs.length && !stop;i++){
			if(songs[i]==null){
				stop=true;
				songs[i]=newSong;
				message="\nSong added succesfully to the playlist ";
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
	
	/**
	* updatePlaylist: It changes the value of the genre and the duration of the song  <br>
	* <b> pre </b> upSong must be a real or initialize object of Song <br>
	* <b> pos </b> It changes the value of genre and duration <br>
	* @param upSong It is the Song object
	*/
	public void updatePlaylist(Song upSong){
		setDuration(getDuration()+upSong.getDuration());
		updateGenre(upSong);
	}
	
	/**
	* updateGenre: It updates the genre of the playlist <br>
	* <b> pre </b> upSong must be a real or initialize object of Song <br>
	* <b> pos </b> The genre is going to change if theres a new genre added <br>
	* @param upSong It is the Song object
	*/
	public void updateGenre(Song upSong){
		
		boolean stop=false;
		boolean stop2=false;
		
		for(int i=0;i<genres.length && !stop;i++){
			if(genres[i]!=null && genres[i]==upSong.getGenre()){
				stop=true;
			}
		}
		for(int j=0;j<genres.length && !stop2;j++){
			if(stop==false && genres[j]==null){
				stop2=true;
				genres[j]=upSong.getGenre();
			}
		}
		
	}//end updateGenre
	
	/**
	* getTime: It takes the current duration of the playlist and returns it into an specified format <br>
	* <b> pre </b> <br>
	* <b> pos </b> <br>
	* @return message Is a message that shows the current playlist duration in a specified format
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
	* getGenres: It gets all the genres from the playlist and show them in a specified format <br>
	* <b> pre </b> <br>
	* <b> pos </b> <br>
	* @return genreList Is the list of genres of the playlist
	*/
	public String getGenres(){
		String genreList="";
		
		for(int i=0;i<genres.length && genres[i]!=null;i++){
			genreList+= (genres[i]+", ");
		}
		if(genreList.equals("")){
			genreList="UNKNOWN";
		}
		return genreList;
	}//end getGenres
	
	/**
	* showPlaylist: It displays the general informtion of a playlist <br>
	* <b> pre </b> <br>
	* <b> pos </b> <br>
	* @return message Is the message with all the required information
	*/
	public String showPlaylist(){
		
		String message=("\n************** Playlist **************"+
		"\n** Title: "+ getName() +
		"\n** Duration: "+ getTime() + 
		"\n** Genre: "+ getGenres());						//"\n** Genre: "+ genreList);
			
		return message;
	}//end showPlaylist
	
}