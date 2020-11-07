package model;

public class User{
		
	//atributes 
	private String name;
	private String password;
	private String age;
	private int sharedS;
	
	//relations
	private Category category;
	
	
	//methods
	/**
	* User: It is the constructor of the User class <br>
	* <b> pre </b> The name cannot have spaces, the password and age should be positive integer numbers <br>
	* <b> pos </b> <br>
	* @param name Is the username of the user
	* @param password Is the password of the user
	* @param age Is age of the user
	*/
	public User(String name, String password, String age ){
		this.name=name;
		this.password=password;
		this.age=age;
		category=Category.NEWBIE;
		sharedS=0;
	}
	
	public String getName(){
		return name;
	}
	
	public String getAge(){
		return age;
	}
	
	public int getSharedS(){
		return sharedS;
	}
	
	public void setSharedS(int plus){
		sharedS=plus;
	}
	
	public Category getCategory(){
		return category;
	}
	
	/**
	* showCategory: It takes the enum value of category and return a string with the same value but a different format <br>
	* <b> pre </b> <br>
	* <b> pos </b> <br>
	* @return categoryS Is the same category but displayed different
	*/
	public String showCategory(){
		String categoryS="";
		if(category==Category.NEWBIE){
			categoryS="Newbie";
		}else if(category==Category.LITTLE_COTRIBUTOR){
			categoryS="Little contributor";
		}else if(category==Category.MILD_CONTRIBUTOR){
			categoryS="Mild contributor";
		}else if(category==Category.STAR_CONTRIBUTOR){
			categoryS="Star contributor";
		}
		return categoryS;
	}//end showCategory
	
	/**
	* setCategory: It changes the current value of the category if te conditions are met <br>
	* <b> pre </b> newCategory must be an integer number that can be either 1,2,3 or 4 <br>
	* <b> pos </b> <br>
	* @param newCategory is an integer number that can be either 1,2,3 or 4
	*/
	public void setCategory(int newCategory){
		
		if(newCategory==1){
			category=Category.NEWBIE;
		}else if(newCategory==2){
			category=Category.LITTLE_COTRIBUTOR;
		}else if(newCategory==3){
			category=Category.MILD_CONTRIBUTOR;
		}else if(newCategory==4){
			category=Category.STAR_CONTRIBUTOR;
		}
	}//end setCategory
	
	/**
	* showUser: It displays the informtion of the user <br>
	* <b> pre </b> <br>
	* <b> pos </b> <br>
	* @return message Is the message with all the required information
	*/
	public String showUser(){
						
		String message=("\n************** User **************"+
		"\n** Name: "+ getName() +
		"\n** Age: "+ getAge() + 
		"\n** Category: "+ showCategory());
			
		return message;
	}//end showSongs
	
	
	
}