package data;

import java.util.ArrayList;
import java.util.List;

public class foodRecipe implements Comparable<foodRecipe> {
	
	public List<Meat> meatIngredient;// = new ArrayList<Meat>();
	//public List<condiment> conIngredient;//=new ArrayList<condiment>();
	//public List<Vege> vegeIngredient;
	private String Description;
	
	public String url;
	
	private String Name;
	
	public int priority = 0;
	
	
	
	public foodRecipe() {
		
	}
	
	public foodRecipe(String n,List<Meat> food, String descp,String u){
		url =u;
		
		Name =n;
		meatIngredient = food;
		
	//	conIngredient = co;
		
		Description = descp;
	}
	
	public int ComparebyIngredient(List<String> in) {
		if(meatIngredient!=null) {
		for(int i=0;i<meatIngredient.size();i++) {
			if(in.contains(meatIngredient.get(i).getName().toLowerCase())) {
				priority++;
			}
		}
		}
		int x =priority;
		priority =0;
		return x;
	}
	
	
	public int ComparebyFood(List<Meat> in) {
		if(meatIngredient!=null) {
		for(int i=0;i<meatIngredient.size();i++) {
			if(in.contains(meatIngredient.get(i))) {
				priority++;
			}
		}
		}
		int x =priority;
		priority =0;
		return x;
		/*
		if(conIngredient!=null){
		for(int i=0;i<conIngredient.size();i++) {
			if(in.contains(conIngredient.get(i))) {
				priority++;
			}
		}
		}
		*/
	}
	
	
	
	
	

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}



	public int compareTo(foodRecipe o) {
		return o.priority - priority;
		
	}
	
	public String toString() {
		return Name;
	}

}
