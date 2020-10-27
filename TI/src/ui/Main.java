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
		
		//create Mcs
		Mcs mcs1=createMcs();
		
		//create user
		while(noMoreU==false && control<mcs1.MAX_USERS){
			String answer;
			System.out.print("Do you wanna create an user? yer or not: ");
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
			System.out.println("\nCant create more users");
		}
		
		//showUsers
		showUsers(mcs1);
		
		//addSong
		addSong(mcs1);
		
	}//end main
	
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
	
	public static void showUsers(Mcs mcsx){
		
		for(int i=0;i<3;i++){
			String messagesx[]=new String[3];
			messagesx = mcsx.showUsers(i);
			System.out.print("\n************** User **************\n");
			System.out.println("** userName: "+ messagesx[0]);
			System.out.println("** Age: "+ messagesx[1]);
			System.out.println("** Category: "+ messagesx[2]);
		}
	}//end showUsers
	
	public static void addSong(Mcs mcsx){
		String messagex;
		System.out.print("\n");
		System.out.print("Type the song title: ");
		String title=sc.nextLine();
		System.out.print("Type the song artist or group name: ");
		String artist=sc.nextLine();
		System.out.print("Type the song release date: ");
		String date=sc.nextLine();
		System.out.print("Type the song duartion in seconds: ");
		int duration=sc.nextInt();sc.nextLine();
		
		messagex=mcsx.addSong(title,artist,date,duration);
		System.out.print(messagex);
	}
}