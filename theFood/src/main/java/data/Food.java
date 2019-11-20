package data;

public abstract class Food {
	

	public Food() {
		
	}
	
	public String getName() {
		return null;};
	
	public abstract double getWeight();

	public abstract String getImageURL();

	public abstract void setImageURL(String imageURL);

	public abstract void setWeight(double weight);

	public abstract void setName(String name);

	public abstract double getCalorie ();

	public abstract double getCalorie_g();

	public abstract void setCalorie_g(double calorie_g);
	

}

/*
 * 	public double getWeight();

	public String getImageURL();

	public void setImageURL(String imageURL);

	public void setWeight(double weight);

	public void setName(String name);

	public double getCalorie ();

	public double getCalorie_g();

	public void setCalorie_g(double calorie_g);
	
	*/
