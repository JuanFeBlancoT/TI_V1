package model;

public class Mcs{
	//constants
	public final int MAX_USERS=10;
	public final int MAX_SONGS=30;
	public final int MAX_PLAYLISTS=20;
	
	//relations
	private User users[];
	private Song pool[];
	private Playlist collection[];
	
	/**
	* Mcs: Its the constructor of the class Mcs <br>
	* <b> pre </b> <br>
	* <b> pos </b> It generates an array of users, songs and playlists<br>
	*/
	public Mcs(){
		
		users=new User[MAX_USERS];
		pool=new Song[MAX_SONGS];
		collection=new Playlist[MAX_PLAYLISTS];
		
	}
	
	/**
	* validName: It validates if the username of a new user is already taken <br>
	* <b> pre </b> <br>
	* <b> pos </b> <br>
	* @param name Is the username of the new user that its gonna be compared with the names of all the created users
	* @return stop Is the boolean that indicates if the username was found or not within the array of users
	*/
	public boolean validName(String name){
		boolean stop=false;
		for(int i=0;i<name.length() && !stop;i++){
			if(name.charAt(i)==' '){
				stop=true;
			}
		}
		return stop;
	}
	
	/**
	* findUser: It seeks for an user based on its username and it verficates if that user does exist <br>
	* <b> pre </b> <br>
	* <b> pos </b> <br>
	* @param name Is the username of the new user that its gonna be compared with the names of all the created users
	* @return stop Is the boolean that indicates if the name was found or not within the array of users
	*/
	public boolean findUser(String name){
		boolean exist=false;
		
		for(int i=0;i<users.length && !exist;i++){
			if(users[i]!=null && users[i].getName().equals(name)){
				exist=true;
			}
		}
		return exist;
	}//end findUser
	
	/**
	* createUser: It creates an user and add it to the users array <br>
	* <b> pre </b> Users array must be initialized, password cannot be a null or an empty string, the age must be an postive integer <br>
	* <b> pos </b> The users array is going to be filled in one box if it is not full already <br>
	* @param name Is the username of the new user
	* @param password Is the password of the user 
	* @param age is the age of the user
	* @return message Is a message that informs the user about the state of the procedure
	*/
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
	
	/**
	* showUsers: It generates a report of a single user based on the index given by the parameter <br>
	* <b> pre </b> Users array must be initialized, the index of the parameter must point an existing user<br>
	* <b> pos </b> <br>
	* @param userNumber Is the index of the song thats gonna be printed
	* @return message Is a message that informs the user about the state of the procedure
	*/
	public String showUsers(int userNumber){
		String message=users[userNumber].showUser();
		return message;
	}//end showSongs
	
	/**
	* addSong: It creates a song and add it to the pool array <br>
	* <b> pre </b> pool array must be initialized, title, artist and date cant be null or empty strings, the duration must be a positive integer<br>
	* <b> pos </b> The pool array is going to be filled in one box if it is not full already <br>
	* @param title Is the song title
	* @param artist Is the name of the artist or grupo that produced the song
	* @param date Is the release date of the song
	* @param songGenre Is the gender of the song which is already in the necesary format
	* @param duration Is the duration of the song
	* @return message Is a message that informs the user about the state of the procedure
	*/
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
	
	/**
	* updateCategory: It updates the category of a certain user based on the amount of songs it has shared <br>
	* <b> pre </b> Uploader cannot be null or an empty string <br>
	* <b> pos </b> It changes the category of the selected user if the conditions are there <br>
	* @param uploader Is the name of the user that uploads the song
	*/
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
	
	/**
	* showSongs: It generates a report of a single song based on the index given by the parameter  <br>
	* <b> pre </b> pool array must be initialized, the index of the parameter must point an existing song <br>
	* <b> pos </b> <br>
	* @param songNumber Is the index of the song that is gonna be shown
	* @return message Is a message that informs the user about the state of the procedure
	*/
	public String showSongs(int songNumber){
		String message=pool[songNumber].showSong();
		return message;
	}//end showSongs
	
	//private playlist
	/**
	* createPlaylist: It creates a private playlist <br>
	* <b> pre </b> collection array must be initialized <br>
	* <b> pos </b> The collection array is going to be filled in one box if it is not full already <br>
	* @param maxSongs Is the maximun amount of songas that a playlist can have
	* @param name Is the name of the playlist
	* @param userName is the name of the user that has access to the playlist
	* @return message Is a message that informs the user about the state of the procedure
	*/
	public String createPlaylist(int maxSongs, String name, String userName){
		
		boolean stop=false;
		User songUser=null;
		String message="Couldnt create playlist";
		
		for(int j=0;j<users.length && !stop;j++){
			if(users[j]!=null && users[j].getName().equals(userName)){
				songUser=users[j];
			}
		}
		
		for(int i=0;i<collection.length && !stop;i++){
			if(collection[i]==null){
				stop=true;
				collection[i]=new PrivatePl(maxSongs, name, songUser);
				message="Private playlist created succesfully";
			}
		}
		return message;
	}//end createPlaylist private
	
	//Restricted playlist
	/**
	* createPlaylist: It creates a protected playlist <br>
	* <b> pre </b> collection array must be initialized <br>
	* <b> pos </b> The collection array is going to be filled in one box if it is not full already <br>
	* @param maxSongs Is the maximun amount of songas that a playlist can have
	* @param name Is the name of the playlist
	* @param userNames is the array of names of the users that have access to the playlist
	* @return message Is a message that informs the user about the state of the procedure
	*/
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
	/**
	* createPlaylist: It creates a public playlist <br>
	* <b> pre </b> collection array must be initialized <br>
	* <b> pos </b> The collection array is going to be filled in one box if it is not full already <br>
	* @param maxSongs Is the maximun amount of songas that a playlist can have
	* @param name Is the name of the playlist
	* @return message Is a message that informs the user about the state of the procedure
	*/
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
	
	/**
	* findPlaylist: It finds a certain playlist <br>
	* <b> pre </b> collection array must be initialized <br>
	* <b> pos </b> <br>
	* @param playlistName It is the name of the playlist we are looking for
	* @return playIndex Is the index of the playlist we were looking for
	*/
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
	
	/**
	* findSong: It finds a certain playlist <br>
	* <b> pre </b> pool array must be initialized <br>
	* <b> pos </b> <br>
	* @param songName It is the name of the song we are looking for
	* @return exist It validates if the song exist or not
	*/
	public boolean findSong(String songName){
		boolean exist=false;
		
		for(int i=0;i<pool.length && !exist;i++){
			if(pool[i]!=null && pool[i].getTitle().equals(songName)){		//poner el condicional de != en el for 
				exist=true;
			}
		}
		
		return exist;
	}//end findSong
	
	/**
	* addSongToPlaylist: It adds a song to a certain playlist <br>
	* <b> pre </b> pool array must be initialized <br>
	* <b> pos </b> <br>
	* @param songName It is the name of the song we are looking for
	* @param playIndex It is the index of the playlist where the song is going to be added 
	* @return message Is a message that informs the user about the state of the procedure
	*/
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

	/**
	* confirmP: It validates that a playlist exist <br>
	* <b> pre </b> collection array must be initialized <br>
	* <b> pos </b> <br>
	* @param playIndex It contains the position of the playlist in the array
	* @return valid It validates if the playlist exits
	*/
	public boolean confirmP(int playIndex){
		
		boolean valid=false;
		
		if(collection[playIndex] instanceof PublicPl){
			valid=true;
		}else{
			valid=false;
		}
		return valid;
	}//end confirmP
	
	/**
	* updateScore: It updates the socre of a public playlist <br>
	* <b> pre </b> collection array must be initialized <br>
	* <b> pos </b> It changes the score of the playlist <br>
	* @param playIndex It contains the position of the playlist in the array
	* @param score It contains the new score from 1 to 5
	*/
	public void updateScore(int playIndex, int score){
		((PublicPl)collection[playIndex]).updateScore(score);
	}
	
	/**
	* showPlaylist: It generates a report of a single playlist based on the index given by the parameter  <br>
	* <b> pre </b> collection array must be initialized, playIndex must point a real object <br>
	* <b> pos </b> <br>
	* @param playlistIndex It contains the position of the playlist in the array
	* @return message Is a message that informs the user about the state of the procedure
	*/
	public String showPlaylist(int playlistIndex){
		String message=collection[playlistIndex].showPlaylist();
		return message;
	}
}