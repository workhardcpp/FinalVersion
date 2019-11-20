package data;

import java.util.List;

public class User {
	 public String name;
	 public String password;
	 public List<foodRecipe> foodRecipes;
	 public User(String a,String b, List<foodRecipe>l) {
		 name = a;
		 password = b;
		 foodRecipes = l;
	 }
	 
	

}
