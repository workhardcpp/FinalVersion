package data;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Meat //extends Food
{
	
	private String Name;
	private double Weight;
	private String date="";

	
	public Meat() {
		
	}
	
	public Meat(String Name, String Weight) {
		this.Name =Name;
		this.Weight = Double.parseDouble(Weight);
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		if(date.equals("")) {
		date = simpleDateFormat.format(new Date());
		}
		
	}
	
	public String getName() {
		return Name;
	}

	public double getWeight() {
		return Weight;
	}
	public void setWeight(double Weight) {
		this.Weight = Weight;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public String toString() {
		return Name+":  "  +  "   Weight:  "+  Weight +"    Date:   "+date;
	}

}
