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
				addSong(mcs1, control);
				controlS++;
			}else{
				noMoreS=true;
			}
		}
		if(controlS==mcs1.MAX_SONGS){
			System.out.println("\nCant add more songs\n");
		}
		
		//showUsers(mcs1, control);
		
		//show songs
		System.out.println("controlS: "+controlS);
		showSongs(mcs1, controlS);
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

			String messagesx[]=new String[3];
			messagesx = mcsx.showUsers(i);
			System.out.print("\n************** User **************\n");
			System.out.println("** userName: "+ messagesx[0]);
			System.out.println("** Age: "+ messagesx[1]);
			System.out.println("** Category: "+ messagesx[2]);
		}
	}//end showUsers
	
	public static void addSong(Mcs mcsx, int control){
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

			String messagesx[]=new String[4];
			messagesx = mcsx.showSongs(i);
			System.out.print("\n************** Song **************\n");
			System.out.println("** Title: "+ messagesx[0]);
			System.out.println("** Artist: "+ messagesx[1]);
			System.out.println("** Duration: "+ messagesx[2]);
			System.out.println("** Genre: "+ messagesx[3]);	
		}
	}//end showSongs
}