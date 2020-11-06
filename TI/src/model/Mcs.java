package model;

public class Mcs{
	//constants
	public final int MAX_USERS=3;
	public final int MAX_SONGS=2;
	public final int MAX_PLAYLISTS=2;
	
	//relations
	private User users[];
	private Song pool[];
	private Playlist collection[];
	
	public Mcs(){
		
		users=new User[MAX_USERS];
		pool=new Song[MAX_SONGS];
		collection=new Playlist[MAX_PLAYLISTS];
		
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
	
	public String showUsers(int userNumber){
		String message=users[userNumber].showUser();
		return message;
	}//end showSongs
	
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
	
	public String showSongs(int songNumber){
		String message=pool[songNumber].showSong();
		return message;
	}//end showSongs
	
	//private playlist
	public String createPlaylist(int maxSongs, String name, String userName){
		
		boolean stop=false;
		String message="Couldnt create playlist";
		
		for(int i=0;i<collection.length && !stop;i++){
			if(collection[i]==null){
				stop=true;
				collection[i]=new PrivatePl(maxSongs, name, userName);
				message="Private playlist created succesfully";
			}
		}
		return message;
	}//end createPlaylist private
	
	//Restricted playlist
	public String createPlaylist(int maxSongs, String name, String[] userNames){
		
		boolean stop=false;
		String message="Couldnt create playlist";
		
		for(int i=0;i<collection.length && !stop;i++){
			if(collection[i]==null){
				stop=true;
				collection[i]=new RestrictedPl(maxSongs, name, userNames);
				message="Restricted playlist created succesfully";
			}
		}
		return message;
	}//end createPlaylist restricted
	
	//Public playlist
	public String createPlaylist(int maxSongs, String name){
		
		boolean stop=false;
		String message="Couldnt create playlist";
		
		for(int i=0;i<collection.length && !stop;i++){
			if(collection[i]==null){
				stop=true;
				collection[i]=new PublicPl(maxSongs, name);
				message="Public playlist created succesfully";
			}
		}
		return message;
	}//end createPlaylist public
	
	public int findPlaylist(String playlistName){
		boolean exist=false;
		int playIndex=-1;
		
		for(int i=0;i<collection.length && !exist;i++){
			if(collection[i]!=null && collection[i].getName().equals(playlistName)){
				exist=true;
				playIndex=i;
			}
		}
		
		return playIndex;
	}//end findPlaylist
	
	public boolean findSong(String songName){
		boolean exist=false;
		
		for(int i=0;i<pool.length && !exist;i++){
			if(pool[i]!=null && pool[i].getTitle().equals(songName)){		//poner el condicional de != en el for 
				exist=true;
			}
		}
		
		return exist;
	}//end findSong
	
	public String addSongToPlaylist(String songName, int playIndex){
		
		String message="";
		boolean exist=false;
		int songIndex=-1;
		
		for(int i=0;i<pool.length && !exist;i++){
			if(pool[i]!=null && pool[i].getTitle().equals(songName)){
				exist=true;
				songIndex=i;
			}
		}
		
		message=collection[playIndex].addSong(pool[songIndex]);
		collection[playIndex].updatePlaylist(pool[songIndex]);
		
		return message;
	}//end addSongToPlaylist

	public boolean confirmP(int playIndex){
		
		boolean valid=false;
		
		if(collection[playIndex] instanceof PublicPl){
			valid=true;
		}else{
			valid=false;
		}
		return valid;
	}//end confirmP
	
	public void updateScore(int playIndex, int score){
		((PublicPl)collection[playIndex]).updateScore(score);
	}
	
	public String showPlaylist(int playlistIndex){
		String message=collection[playlistIndex].showPlaylist();
		return message;
	}
}