package model;

public class Mcs{
	//constants
	public final int MAX_USERS=3;
	
	//relations
	private User users[];
	//private Song pool[];
	//private Playlist collection[];
	
	public Mcs(){
		//initialize users
		users=new User[MAX_USERS];
		for(int i=0;i<users.length;i++){
			users[i]=null;
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
}