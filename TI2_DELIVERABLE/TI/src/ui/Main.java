package ui;

import model.Mcs;
import java.util.Scanner;

public class Main{
	
	public static Scanner sc =new Scanner(System.in);
	
	public static void main (String[] args){
		
		//attributes
		boolean menu=true;
		
		//Users control variables
		int control=0; 					//amount of users created
		boolean valid=false;			//validates if the user was created successfully or not in order to count it into control 
		
		//Songs control variables
		int controlS=0;					//amount of songs created
		boolean validS=false;			//validates if the song was added successfully or not in order to count it into controlS
		
		//Playlists control variables
		int controlP=0;					//amount of playlists created
		boolean validP=false;			//validates if the playlist was created successfully or not in order to count it into controlP
		
		//Start program
				
		//create Mcs
		Mcs mcs1=createMcs();
		
		//MENU
		
		while(menu){
			System.out.print("\n");
			System.out.println("\n Welcome to Mcs prototype, please chose an option from below: "+
			"\n 1) Create user"+
			"\n 2) Show user(s)"+
			"\n 3) Add song to the pool of songs"+
			"\n 4) Show song(s)"+
			"\n 5) Create playlist"+
			"\n 6) Add song to a playlist"+
			"\n 7) Show playlist(s)"+
			"\n 8) Grade a playlist"+
			"\n 9) Exit");
			
			int option=sc.nextInt();sc.nextLine();
			
			switch(option){
				
				case 1:
				
					if(control!=mcs1.MAX_USERS){
						
						valid=createUser(mcs1);
						if(valid){
						control++;
							}
					}else{
						System.out.println("\nCant create more users");
					}

					break;
				case 2:		
					showUsers(mcs1, control);
					break;
				case 3:
				
					if(controlS!=mcs1.MAX_SONGS){
						
						validS=addSong(mcs1, control);
						if(validS){
						controlS++;
							}
					}else{
						System.out.println("\nCant create more songs");
					}
					
					break;
				case 4:
					showSongs(mcs1, controlS);
					break;
				case 5:
					
					if(controlP!=mcs1.MAX_PLAYLISTS){
						
						validP=createPlaylist(mcs1);
						if(validP){
						controlP++;
							}
					}else{
						System.out.println("\nCant create more playlists");
					}
					
					break;
				case 6:
					addSongToPlaylist(mcs1);
					break;
				case 7:
					showPlaylist(mcs1, controlP);
					break;
				case 8:
					gradeP(mcs1);
					break;
				case 9:
					System.out.println("\n**** Bye ****");
					menu=false;
					break;
				default:
					System.out.println("\nError. Invalid option");
					break;
			}
		
		}
			
	}//end main
	
	
	//methods
	
	/**
	* createMcs: It creates a Mcs <br>
	* <b> pre </b> <br>
	* <b> pos </b> <br>
	* @return mcsx Is the Mcs
	*/
	public static Mcs createMcs(){
		Mcs mcsx=new Mcs();
		return mcsx;
	}//end createMcs
		
	/**
	* createUser: It creates an user in the Mcs adding it to the users array <br>
	* <b> pre </b> The array of users must be initialized<br>
	* <b> pos </b> <br>
	* @param mcsx Is the Mcs from the package model that controls everything
	* @return valid It validates if the user was created successfully or not
	*/
	public static boolean createUser(Mcs mcsx){
		String messagex;
		boolean valid=false;
		
		System.out.print("Type your user name, without spaces: ");
		String name=sc.nextLine();
		
		System.out.print("Type your password: ");
		String password=sc.nextLine();
		System.out.print("Type your age: ");
		String age=sc.nextLine();
		
		//validate name without " "
		boolean invalidName=mcsx.validName(name);
		if(invalidName==true){
			System.out.println("\nInvalid name, remeber that it has no spaces");
		}else{
			//validate if name isnt already taken
			boolean exist=mcsx.findUser(name);
			if(exist==false){
				messagex= mcsx.createUser(name,password,age);
				System.out.println("\n"+messagex);
				valid=true;
			}else{
				System.out.println("\nName already taken. Try another one");
				valid=false;
			}
		}
		return valid;
		
	}//end createUser
	
	/**
	* showUsers: It shows all created users by asking other methods for a message with the specified data <br>
	* <b> pre </b> There must be at least one user created <br>
	* <b> pos </b> <br>
	* @param mcsx Is the Mcs from the package model that controls everything
	* @param totUsers The integer number that represents how many users exist
	*/
	public static void showUsers(Mcs mcsx, int totUsers){
		for(int i=0;i<totUsers;i++){

			String messagex = mcsx.showUsers(i);
			System.out.println(messagex);
		}
	}//end showSongs
		
	/**
	* addSong: It creates a new song and add it to the pool array <br>
	* <b> pre </b> The array onf songs, called pool, must be initialized<br>
	* <b> pos </b> <br>
	* @param mcsx Is the Mcs from the package model that controls everything
	* @param control Is the integer number that contains the mount of users that exist, it is used to determine if we can or not ask for the user that uploads the song 
	* @return created validates if the song was created successfully or not
	*/
	public static boolean addSong(Mcs mcsx, int control){
		
		boolean created=false;
		
		String messagex;
		System.out.print("\n");
		System.out.print("Type the song title: ");
		String title=sc.nextLine();
		System.out.print("Type the song artist or group name: ");
		String artist=sc.nextLine();
		System.out.print("Type the song release date: ");
		String date=sc.nextLine();

		System.out.print("Type the song genre: \n"+
			"1. Rock\n"+
			"2. Hip hop\n"+
			"3. Musica clasica\n"+
			"4. Reggae\n"+
			"5. Salsa\n"+
			"6. Metal\n");
		int songGenre=sc.nextInt();sc.nextLine();
		
		String s_genre="";
		switch(songGenre){
			case 1:
			s_genre="ROCK";
		break;
			case 2:
			s_genre="HIP_HOP";
		break;
			case 3:
			s_genre="CLASSIC_MUSIC";
		break;
			case 4:
			s_genre="REGGAE";
		break;
			case 5:
			s_genre="SALSA";
		break;
			case 6:
			s_genre="METAL";
		break;
		}
		
		System.out.print("Type the song duration in seconds: ");
		int duration=sc.nextInt();sc.nextLine();
		
		//actually creates the song here
		messagex=mcsx.addSong(title,artist,date, s_genre,duration);
		System.out.print(messagex);
		created=true;
		
		if(control!=0){
			System.out.print("\nWhich user is gonna upload the song? Type de username: ");
			String uploader=sc.nextLine();
			mcsx.updateCategory(uploader);
		}
		
		return created;
	}//end song
	
	/**
	* showSongs: It shows all songs in the pool array by asking other methods for a message with the specified data <br>
	* <b> pre </b> There must be at least one song created <br>
	* <b> pos </b> <br>
	* @param mcsx Is the Mcs from the package model that controls everything
	* @param totSongs Is the  integer number that contains the amount of songs created
	*/
	public static void showSongs(Mcs mcsx, int totSongs){
		for(int i=0;i<totSongs;i++){

			String messagex = mcsx.showSongs(i);
			System.out.println(messagex);
		}
	}//end showSongs
	
	/**
	* createPlaylist: It creates a playlist in the Mcs adding it to the collection array <br>
	* <b> pre </b> The array collection must be initialized<br>
	* <b> pos </b> <br>
	* @param mcsx Is the Mcs from the package model that controls everything
	* @return created validates if the playlist was created successfully or not
	*/
	public static boolean createPlaylist(Mcs mcsx){
		final int MAX_RU=5;
		//keep is a condition for adding more usernames to the restricted playklist
		boolean keep=false;
		String answer="";
		String messagex="";
		boolean created=false;
		//validates if the strings in the restricted playlist are pointing a real user
		boolean exists=false;
		
		System.out.print("\nType the playlist name: ");
		String name=sc.nextLine();
		
		System.out.println("\nWhich kind of playlist do you want to create?: "+
		"\n1. Private"+
		"\n2. Restricted"+
		"\n3. Public");
		int selection=sc.nextInt();sc.nextLine();
		
		switch(selection){
			case 1:
				System.out.print("\nType the username of the user that will have access to this playlist: ");
				String userName=sc.nextLine();
				boolean exist=mcsx.findUser(userName);
				if(exist){
					messagex=mcsx.createPlaylist(mcsx.MAX_SONGS, name, userName);
					created=true;
				}else{
						System.out.print("\nThis user does not exist. Cant create playlist: ");
				}
				
			break;
			case 2:
				String userNames[]=new String[MAX_RU];
				String singleUserName="";
				
				System.out.print("\nType the usernames of the users that will have access to this playlist: ");
				for(int i=0;i<MAX_RU && !keep;i++){
					System.out.print("\nType the "+(i+1)+" username : ");
					singleUserName=sc.nextLine();
					
					//verificate if the typed user actually exists 
					exists=mcsx.findUser(singleUserName);
					if(exists){
						userNames[i]=sc.nextLine();
						
						if(i<4){
							System.out.print("Add another user to the playlist? yes or not: ");
							answer=sc.nextLine();
						}
						if(!(answer.equalsIgnoreCase("yes"))){
							keep=true;
						}
						if(i==(MAX_RU-1)){
							System.out.print("\nCant add more users to this playlist");
							keep=true;
						}
					}else{
						System.out.print("\nThis user does not exist. Cant create playlist, please try again ");
						keep=true;
					}
					
				}
				if(exists!=false){
					
					messagex=mcsx.createPlaylist(mcsx.MAX_SONGS, name, userNames);
					created=true;
				}
				
			break;
			case 3:
				messagex=mcsx.createPlaylist(mcsx.MAX_SONGS, name);
				created=true;
			break;
		}
		System.out.print(messagex);
		return created;
		
	}//end createPlaylist
	
	/**
	* addSongToPlaylist: It adds a song to a certain playlist <br>
	* <b> pre </b> <br>
	* <b> pos </b> <br>
	* @param mcsx Is the Mcs from the package model that controls everything
	*/
	public static void addSongToPlaylist(Mcs mcsx){
		String messageY="";
		
		System.out.print("\nDo you want to add a song to a playlist? yes or not: ");
		String answer=sc.nextLine();
		
		if(answer.equalsIgnoreCase("yes")){
			System.out.print("Type the name of the song (from the pool): ");
			String songName=sc.nextLine();
			boolean exist=mcsx.findSong(songName);
			
			if(exist){
				
				System.out.print("Type the name of the playlist you wish to add this song to: ");
				String playlistName=sc.nextLine();
				int playIndex=mcsx.findPlaylist(playlistName);
				if(playIndex!=-1){
					messageY=mcsx.addSongToPlaylist(songName, playIndex);
				}else{
					System.out.print("This playlist does not exist: ");
				}
				//mcsx.addSongToPlaylist();
			}else{
				System.out.print("This song does not exist");
			}
			System.out.print(messageY);
		}
	}//end addSongToPlaylist
	
	/**
	* gradeP: It allows the user to rate a playlist <br>
	* <b> pre </b> There must be at least one public playlist created <br>
	* <b> pos </b> <br>
	* @param mcsx Is the Mcs from the package model that controls everything
	*/
	public static void gradeP(Mcs mcsx){

			System.out.print("Type the name of the public playlist: ");
			String playlistName=sc.nextLine();
			int playIndex=mcsx.findPlaylist(playlistName);
			if(playIndex!=-1){
				boolean valid=mcsx.confirmP(playIndex);
				
				if(valid==true){
					System.out.print("Type the score, from 1 to 5: ");
					int score=sc.nextInt();sc.nextLine();
				
					if(score<1 && score>5){
						System.out.print("\n INVALID SCORE: ");
					}else{
						mcsx.updateScore(playIndex, score);
					}
				}
			}else{
				System.out.print("Not a public playlist");
			}
			
	}//end gradeP
	
		/**
	* showPlaylist: It shows all the playlist that were created <br>
	* <b> pre </b> There must be at least one playlist created <br>
	* <b> pos </b> <br>
	* @param mcsx Is the Mcs from the package model that controls everything
	* @param totPlaylists Is the integer number that contains the amount of playlists that were created
	*/
	public static void showPlaylist(Mcs mcsx, int totPlaylists){
		for(int i=0;i<totPlaylists;i++){

			String message=mcsx.showPlaylist(i);
			System.out.println(message);
		}
	}//end showPlaylist
	
}