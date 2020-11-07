package model;

public class PublicPl extends Playlist{
	
	//attributes
	private double score;
	private double acum_scores;
	private double evaluations;
	
	//Methods
	/**
	* PublicPl: It is the constructor of the PublicPl class <br>
	* <b> pre </b> <br>
	* <b> pos </b> <br>
	* @param maxSongs is the maximun number of songs a playlist can have
	* @param name The name of the playlist
	*/
	public PublicPl(int maxSongs, String name){
		super(maxSongs, name);
		score=0;
		evaluations=0;
		acum_scores=0;
	}
	
	/**
	* updateScore: It updates the score of the playlist <br>
	* <b> pre </b> The scorex must be an integer number between 1 and 5 <br>
	* <b> pos </b> The score of the playlist will change <br>
	* @param scorex is an integer number between 1 and 5 that modifies the score value of the playlist
	*/
	public void updateScore(int scorex){
	
		evaluations+=1;
		acum_scores+=scorex;
		score=acum_scores/evaluations;		
	}//end updateScore
	
	public double getScore(){
		return score;
	}
	
	/**
	* showPlaylist: It overrites the method of Playlist and displays the general informtion plus the specific information of the public playlist <br>
	* <b> pre </b> <br>
	* <b> pos </b> <br>
	* @return message Is the message with all the required information
	*/
	@Override
	public String showPlaylist(){
		String message=super.showPlaylist();

		message+="\n** Score: "+ getScore() ;
		
		return message;
	} 
}