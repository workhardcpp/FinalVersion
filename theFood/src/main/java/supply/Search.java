package supply;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Repository;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;

import data.AppUser;
import data.Food;
import data.Meat;
import data.foodRecipe;

@Repository
public class Search {
	
public List<foodRecipe> performSearch(String s) throws InterruptedException, ExecutionException  {
		
		//List<foodRecipe> l = new ArrayList<foodRecipe>();
		
List<foodRecipe> list = new ArrayList<foodRecipe>();


Firestore db1 = FirestoreClient.getFirestore();
ApiFuture<QuerySnapshot> future = db1.collection("foodRecipe").get();


	List<QueryDocumentSnapshot> documents = future.get().getDocuments();
		
		for (DocumentSnapshot document : documents) {
			  list.add(document.toObject(foodRecipe.class));
			}
		

		String[] inputItems = s.toLowerCase().split(",");
	
		List<String> in = Arrays.asList(inputItems);
		/*
		if(list.size()==0) {
			list.add(new foodRecipe(9)); //("fuck you");
		}
		*/
		
		for(int i=0;i< list.size();i++) {
			list.get(i).ComparebyIngredient(in);
		}
		
		Collections.sort(list);
		
		return list;
	}


public List<foodRecipe> performSearch(List<Meat> in) throws InterruptedException, ExecutionException {
	
	//List<foodRecipe> l = new ArrayList<foodRecipe>();
	
List<foodRecipe> list = new ArrayList<foodRecipe>();


Firestore db1 = FirestoreClient.getFirestore();
ApiFuture<QuerySnapshot> future = db1.collection("foodRecipe").get();


List<QueryDocumentSnapshot> documents = future.get().getDocuments();
	
	for (DocumentSnapshot document : documents) {
		  list.add(document.toObject(foodRecipe.class));
		}
	/*
	if(list.size()==0) {
		list.add(new foodRecipe(9)); //("fuck you");
	}
	*/
	
	for(int i=0;i< list.size();i++) {
		list.get(i).ComparebyFood(in);
	}
	
	Collections.sort(list);
	
	return list;
}

public AppUser findUserbyUsername(String name) throws InterruptedException, ExecutionException {
	Firestore db1 = FirestoreClient.getFirestore();
	ApiFuture<QuerySnapshot> future = db1.collection("User").get();

	List<QueryDocumentSnapshot> documents = future.get().getDocuments();
		
		for (DocumentSnapshot document : documents) {
			  if(document.toObject(AppUser.class).getUserName().equalsIgnoreCase(name)) {
				  return document.toObject(AppUser.class);
			  }
			}
	return null;
}

public Food[] findFood(String name) throws InterruptedException, ExecutionException {
	Firestore db = FirestoreClient.getFirestore();
	DocumentReference docRef = db.collection("User").document("recipeList");
	
	ApiFuture<DocumentSnapshot> future = docRef.get();
	
	DocumentSnapshot document = future.get();
	if (document.exists()) {
		return (Food[]) document.getData().entrySet().toArray();
	} else {
	  System.out.println("No such document!");
	}
	return null;
}


public foodRecipe findRecipe(String name) throws InterruptedException, ExecutionException {
	Firestore db1 = FirestoreClient.getFirestore();
	ApiFuture<QuerySnapshot> future = db1.collection("foodRecipe").get();

	List<QueryDocumentSnapshot> documents = future.get().getDocuments();
		
		for (DocumentSnapshot document : documents) {
			  if(document.toObject(foodRecipe.class).getName().equalsIgnoreCase(name)) {
				  return document.toObject(foodRecipe.class);
			  }
			}
		return null;
}
	

}
