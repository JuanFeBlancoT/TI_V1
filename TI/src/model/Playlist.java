package model;

public abstract class Playlist{
	//attributes
	private int genreSize=6;
	private String name;
	private int duration;
	//Relations
	private Genre[] genres;
	private Song[] songs;
	
	//Methods
	public Playlist(int maxSongs, String name){
		this.name=name;
		duration=0;
		genres=new Genre[genreSize];
		
		songs=new Song[maxSongs];
		
	}
	
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
	
	public void updatePlaylist(Song upSong){
		setDuration(getDuration()+upSong.getDuration());
		updateGenre(upSong);
		
		
	}
	
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
	
	public String showPlaylist(){
		
		String message=("\n************** Playlist **************"+
		"\n** Title: "+ getName() +
		"\n** Duration: "+ getTime() + 
		"\n** Genre: "+ getGenres());						//"\n** Genre: "+ genreList);
			
		return message;
	}//end showPlaylist
	
}