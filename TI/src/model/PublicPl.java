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
	
	public void updateScore(int score){
	
		evaluations+=1;
		acum_scores+=score;
		double totalScore=acum_scores/evaluations;		
	}//end updateScore
	
}