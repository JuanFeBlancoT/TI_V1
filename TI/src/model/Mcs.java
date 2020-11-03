package model;

public class Mcs{
	//constants
	public final int MAX_USERS=3;
	public final int MAX_SONGS=2;
	
	//relations
	private User users[];
	private Song pool[];
	//private Playlist collection[];
	
	public Mcs(){
		
		users=new User[MAX_USERS];
		pool=new Song[MAX_SONGS];
		
		for(int i=0;i<users.length;i++){
			users[i]=null;
		}
		for(int i=0;i<pool.length;i++){
			pool[i]=null;
		}
		
	}
	
	public boolean validName(String name){
		boolean stop=false;
		for(int i=0;i<name.length() && !stop;i++){
			if(name.charAt(i)==' '){
				stop=true;
			}
		}
		return stop;
	}
	
	public boolean findUser(String name){
		boolean exist=false;
		
		for(int i=0;i<users.length && !exist;i++){
			if(users[i]!=null && users[i].getName().equals(name)){
				exist=true;
			}
		}
		return exist;
	}//end findUser
	
	public String createUser(String name, String password, String age){
		boolean stop=false;
		String message="Couldnt create user";
		
		for(int i=0;i<users.length && !stop;i++){
			if(users[i]==null){
				stop=true;
				users[i]=new User(name,password,age);
				message="User created succesfully";
			}
		}
		return message;
	}//end createUser
	
	public String[] showUsers(int userNumber){
		String messages[]=new String[3];
		
		if(users[userNumber]!=null){
			messages[0]=users[userNumber].getName();
			messages[1]=users[userNumber].getAge();
			messages[2]=users[userNumber].showCategory();
		}
		return messages;
	}//end showUsers
	
	public String addSong(String title, String artist, String date, String songGenre, int duration){
		
		boolean stop=false;
		String message="Couldnt add song";
		
		for(int i=0;i<pool.length && !stop;i++){
			if(pool[i]==null){
				stop=true;
				pool[i]=new Song(title, artist, date, songGenre, duration);
				message="\nSong added succesfully";
			}
		}
		return message;
	}//end addSong
	
	public void updateCategory(String uploader){
		boolean exist=false;
		int userIndex=0;
		
		for(int i=0;i<users.length && !exist;i++){
			if(users[i]!=null && users[i].getName().equals(uploader)){
				exist=true;
				userIndex=i;
			}
		}
		users[userIndex].setSharedS(users[userIndex].getSharedS()+1	);
		
		if(users[userIndex].getSharedS()>2){
			users[userIndex].setCategory(2);
		}else if(users[userIndex].getSharedS()>9){
			users[userIndex].setCategory(3);
		}else if(users[userIndex].getSharedS()>29){
			users[userIndex].setCategory(4);
		}
		
		
	}//end updateCategory
	
	public String[] showSongs(int songNumber){
		String messages[]=new String[4];
		if(pool[songNumber]!=null){
			messages[0]=pool[songNumber].getTitle();
			messages[1]=pool[songNumber].getArtist();
			messages[2]=pool[songNumber].getTime();//null;//pool[songNumber].calculateTime(pool[songNumber].getDuration());
			messages[3]=pool[songNumber].showGenre();
		}
		return messages;
	}//end showSongs
}