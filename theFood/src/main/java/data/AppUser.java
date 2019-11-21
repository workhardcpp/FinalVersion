package data;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.context.annotation.Role;
import org.springframework.security.core.GrantedAuthority;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;

import supply.Search;

public class AppUser {
	
private Long userId;
private String userName;
private String firstName;
private String lastName;
private boolean enabled;
private String gender;
private String email;
private String encrytedPassword;



private List<Meat> meatList = new ArrayList<Meat>();// {new Meat(), new Meat()};




private List<foodRecipe> recipeList;
 
private String countryCode;

public AppUser() {}


public AppUser(Long userId, String userName, String firstName, String lastName, //
        boolean enabled, String gender, //
        String email,String countryCode, String encrytedPassword) throws InterruptedException, ExecutionException {
    super();
    this.userId = userId;
    this.userName = userName;
    this.firstName = firstName;
    this.lastName = lastName;
    this.enabled = enabled;
    this.gender = gender;
    this.email = email;
    this.countryCode= countryCode;
    this.encrytedPassword = encrytedPassword; 
    
    /*
    meatList.add(new Meat());
    meatList.add(new Meat());
    meatList.add(new Meat());
    */
    /*
    vegeList.add(new Vege());
    vegeList.add(new Vege());
    vegeList.add(new Vege());
    
    conList.add(new condiment());
    conList.add(new condiment());
    conList.add(new condiment());
    
    */
    if(meatList!=null) {
    updateRecipe();}
}

public Long getUserId() {
    return userId;
}

public void setUserId(Long userId) {
    this.userId = userId;
}

public String getUserName() {
    return userName;
}

public void setUserName(String userName) {
    this.userName = userName;
}

public String getFirstName() {
    return firstName;
}

public void setFirstName(String firstName) {
    this.firstName = firstName;
}

public String getLastName() {
    return lastName;
}

public void setLastName(String lastName) {
    this.lastName = lastName;
}

public boolean isEnabled() {
    return enabled;
}

public void setEnabled(boolean enabled) {
    this.enabled = enabled;
}

public String getGender() {
    return gender;
}

public void setGender(String gender) {
    this.gender = gender;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public String getEncrytedPassword() {
    return encrytedPassword;
}

public void setEncrytedPassword(String encrytedPassword) {
    this.encrytedPassword = encrytedPassword;
}

public String getCountryCode() {
    return countryCode;
}

public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
}



public List<Meat> getFoodList()  {
	//updateRecipe();
	return meatList;
}


public void setFoodList(List<Meat> foodList) {
	this.meatList = foodList;
}

public void updateFood(Meat food) throws InterruptedException, ExecutionException {
	Boolean flag = false;
	for(int i=0;i<meatList.size();i++) {
		if(meatList.get(i).getName().equalsIgnoreCase(food.getName())) {
			flag = true;
			meatList.get(i).setWeight(food.getWeight());
		}
	}
	if(!flag) {
	meatList.add(food);}
	updateRecipe();
}

public void updateRecipe() throws InterruptedException, ExecutionException {
	Search s = new Search();
	String n="";
	for(int i=0;i<getFoodList().size();i++) {
		n=n+getFoodList().get(i).getName()+",";
	}
	setRecipeList(s.performSearch(n));
	//setRecipeList(s.performSearch(getFoodList()));	
}


public List<foodRecipe> getRecipeList() throws InterruptedException, ExecutionException {
	Search s = new Search();
	
	
	String n="";
	for(int i=0;i<getFoodList().size();i++) {
		n=n+getFoodList().get(i).getName()+",";
	}
	return s.performSearch(n);
	//return s.performSearch(getFoodList());
	//return recipeList;
}


public void setRecipeList(List<foodRecipe> recipeList) {
	this.recipeList = recipeList;
}
/*
public String[] getRoles(){
	String[]l =new String[2];
	return l;
}
*/

/*
public List<condiment> getConList() {
	return conList;
}


public void setConList(List<condiment> conList) {
	this.conList = conList;
}


public List<Vege> getVegeList() {
	return vegeList;
}


public void setVegeList(List<Vege> vegeList) {
	this.vegeList = vegeList;
}

*/
public List<Meat> getMeatList() {
	return meatList;
}


public void setMeatList(List<Meat> meatList) {
	this.meatList = meatList;
}
}
