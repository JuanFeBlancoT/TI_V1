package ui;

import model.Mcs;
import java.util.Scanner;

public class Main{
	
	public static Scanner sc =new Scanner(System.in);
	
	public static void main (String[] args){
		
		//attributes
		boolean noMoreU=false;
		int control=0;
		boolean valid=false;
		boolean noMoreS=false;
		int controlS=0;
		boolean validS=false;
		boolean noMoreP=false;
		int controlP=0;
		boolean validP=false;
		
		//create Mcs
		Mcs mcs1=createMcs();
		
		//create user
		while(noMoreU==false && control<mcs1.MAX_USERS){
			String answer;
			System.out.print("\nDo you want to create an user? yes or not: ");
			answer=sc.nextLine();
			if(answer.equalsIgnoreCase("yes")){
				valid=createUser(mcs1);
				if(valid==true){
					control++;
				}
			}else{
				noMoreU=true;
			}
		}
		if(control==mcs1.MAX_USERS){
			System.out.println("\nCant create more users\n**************");
		}
		
		//showUsers
		showUsers(mcs1, control);
		
		//addSong
		
		while(noMoreS==false && controlS<mcs1.MAX_SONGS){
			String answerS;
			System.out.print("\nDo you want to add a song? yer or not: ");
			answerS=sc.nextLine();
			if(answerS.equalsIgnoreCase("yes")){
				addSong(mcs1, control, controlP);
				controlS++;
			}else{
				noMoreS=true;
			}
		}
		if(controlS==mcs1.MAX_SONGS){
			System.out.println("\nCant add more songs\n");
		}
		
		
		//showUsers(mcs1, control);
		showSongs(mcs1, controlS);
		
		//create playlist
		while(noMoreP==false && controlP<mcs1.MAX_PLAYLISTS){
			String answerP;
			System.out.print("\nDo you want to add a playlist? yer or not: ");
			answerP=sc.nextLine();
			if(answerP.equalsIgnoreCase("yes")){
				controlP+=createPlaylist(mcs1);
			}else{
				noMoreP=true;
			}
		}
		if(controlP==mcs1.MAX_SONGS){
			System.out.println("\nCant add more playlists\n");
		}
		//repeat addsong
		noMoreS=false;
		while(noMoreS==false && controlS<mcs1.MAX_SONGS){
			String answerS;
			System.out.print("\nDo you want to add a song? yer or not: ");
			answerS=sc.nextLine();
			if(answerS.equalsIgnoreCase("yes")){
				addSong(mcs1, control,controlP);
				controlS++;
			}else{
				noMoreS=true;
			}
		}
		if(controlS==mcs1.MAX_SONGS){
			System.out.println("\nCant add more songs\n");
		}
		//add song to playlist
		addSongToPlaylist(mcs1);
		addSongToPlaylist(mcs1);
		
		showPlaylist(mcs1, controlP);
		
		gradeP(mcs1);
		
		gradeP(mcs1);
		
		gradeP(mcs1);
		
		
		
	}//end main
	
	
	//methods
	public static Mcs createMcs(){
		Mcs mcsx=new Mcs();
		return mcsx;
	}//end createMcs
	
	public static boolean createUser(Mcs mcsx){
		String messagex;
		boolean valid=true;
		
		System.out.print("Type your user name, without spaces: ");
		String name=sc.nextLine();
		//validar cadena
		System.out.print("Type your password: ");
		String password=sc.nextLine();
		System.out.print("Type your age: ");
		String age=sc.nextLine();
		
		//validate name without " "
		boolean validName=mcsx.validName(name);
		if(validName==true){
			System.out.println("\nInvalid name, remeber that it has no spaces");
			valid=false;
		}else{
			//validate if name isnt already taken
			boolean exist=mcsx.findUser(name);
			if(exist==false){
				messagex= mcsx.createUser(name,password,age);
				System.out.println("\n"+messagex);
			}else{
				System.out.println("\nName already taken. Try another one");
				valid=false;
			}
		}
		return valid;
		
	}//end createUser
	
	public static void showUsers(Mcs mcsx, int totUsers){
		for(int i=0;i<totUsers;i++){

			String messagex = mcsx.showUsers(i);
			System.out.println(messagex);
		}
	}//end showSongs
	
	public static void addSong(Mcs mcsx, int control, int totPl){
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
		
		if(control!=0){
			System.out.print("\nWhich user is gonna upload the song? Type de username: ");
			String uploader=sc.nextLine();
			mcsx.updateCategory(uploader);
		}
			
	}//end song
	
		public static void showSongs(Mcs mcsx, int totSongs){
		for(int i=0;i<totSongs;i++){

			String messagex = mcsx.showSongs(i);
			System.out.println(messagex);
		}
	}//end showSongs
	
	public static int createPlaylist(Mcs mcsx){
		final int MAX_RU=5;
		boolean keep=false;
		String answer="";
		String messagex="";
		int created=0;
		
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
					created++;
				}else{
						System.out.print("\nThis user does not exist. Cant create playlist: ");
				}
				
			break;
			case 2:
				String userNames[]=new String[MAX_RU];
				
				System.out.print("\nType the usernames of the users that will have access to this playlist: ");
				for(int i=0;i<MAX_RU && !keep;i++){
					System.out.print("\nType the "+(i+1)+" username : ");
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
				}
				messagex=mcsx.createPlaylist(mcsx.MAX_SONGS, name, userNames);
				created++;
			break;
			case 3:
				messagex=mcsx.createPlaylist(mcsx.MAX_SONGS, name);
				created++;
			break;
		}
		System.out.print(messagex);
		return created;
		
	}//end createPlaylist
	
	//cambiar nombres
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
	
	public static void gradeP(Mcs mcsx){

		System.out.print("\nDo you want to grade a playlist? yes or not : ");
		String answer=sc.nextLine();
		
		if(answer.equalsIgnoreCase("yes")){
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
			
		}
	}//end gradeP
	
	public static void showPlaylist(Mcs mcsx, int totPlaylists){
		for(int i=0;i<totPlaylists;i++){

			String message=mcsx.showPlaylist(i);
			System.out.println(message);
		}
	}//end showPlaylist
	
}