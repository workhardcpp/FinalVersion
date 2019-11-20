package data;

public class condiment extends Food{
	
	private String name;
	private double quanlity;
	private String imageURL;
	private double calorie_g;
	private Food[] foodList;
	
	public condiment() {
		
	}
	
	public condiment(String n, double w, String i,double c, Food[]f) {
		name =n;
		quanlity = w;
		imageURL =i;
		calorie_g = c;
		setFoodList(f);
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public double getWeight() {
		// TODO Auto-generated method stub
		return quanlity;
	}

	public String getImageURL() {
		// TODO Auto-generated method stub
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public void setWeight(double weight) {
		this.quanlity = weight;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCalorie () {
		return calorie_g*getWeight();
	}

	public double getCalorie_g() {
		return calorie_g;
	}

	public void setCalorie_g(double calorie_g) {
		this.calorie_g = calorie_g;
	}

	public Food[] getFoodList() {
		return foodList;
	}

	public void setFoodList(Food[] foodList) {
		this.foodList = foodList;
	}
	
	public String toString() {
		return "Name: "+ name+" Weight: "+ quanlity;
	}
	
}
