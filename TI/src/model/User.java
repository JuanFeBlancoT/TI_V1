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
	}
	
}