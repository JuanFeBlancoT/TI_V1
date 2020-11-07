package model;

public class PublicPl extends Playlist{
	
	//attributes
	private double score;
	private double acum_scores;
	private double evaluations;
	
	//Methods
	public PublicPl(int maxSongs, String name){
		super(maxSongs, name);
		score=0;
		evaluations=0;
		acum_scores=0;
	}
	
	public void updateScore(int scorex){
	
		evaluations+=1;
		acum_scores+=scorex;
		score=acum_scores/evaluations;		
	}//end updateScore
	
	public double getScore(){
		return score;
	}
	
	@Override
	public String showPlaylist(){
		String message=super.showPlaylist();

		message+="\n** Score: "+ getScore() ;
		
		return message;
	} 
}