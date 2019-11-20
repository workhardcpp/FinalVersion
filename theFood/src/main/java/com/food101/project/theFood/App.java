package com.food101.project.theFood;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import data.Food;
import data.Meat;
import data.User;
import data.foodRecipe;

@SpringBootApplication
public class App {

    public static void main(String[] args) throws Throwable {
    	
    	FileInputStream serviceAccount =
    			  new FileInputStream("/Users/jianchaosun/Downloads/foodrecipe-ebdec-firebase-adminsdk-d37z1-341aa1c134.json");

    			FirebaseOptions options = new FirebaseOptions.Builder()
    			  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
    			  .setDatabaseUrl("https://foodrecipe-ebdec.firebaseio.com")
    			  .build();

    			FirebaseApp.initializeApp(options);
    			
                Firestore db = FirestoreClient.getFirestore();
    			
    			
    			
    			/*Map<String, Object> data = new HashMap<String, Object>();
    			data.put("first", "Ada");
    			data.put("last", "Lovelace");
    			data.put("born", 1815);
    			//asynchronously write data
    			 * 
    			 */
    			//List<foodRecipe> l = new ArrayList<foodRecipe>();
    			
    			List<Meat> food = new ArrayList<Meat>();
    			
    			food.add(new Meat("beef", "20"));
    			food.add(new Meat("chicken", "20"));
    			
    			foodRecipe food1 = new foodRecipe("ChikenBeefMix",food,"beef","");
    			
    			
    			DocumentReference docRef = db.collection("foodRecipe").document("ChickenBeefMix");
    			
    			//User data = new User("j","s",l);
    			ApiFuture<WriteResult> result = docRef.set(food1);
    			
    			
    			
List<Meat> food2 = new ArrayList<Meat>();
    			
    			food2.add(new Meat("green", "10"));
    			food2.add(new Meat("red", "20"));
    			
    			foodRecipe food3 = new foodRecipe("greenfood",food2, "green","");
    			
    			DocumentReference docRef2 = db.collection("foodRecipe").document("greenfood");
    			
    			//User data = new User("j","s",l);
    			ApiFuture<WriteResult> result1 = docRef2.set(food3);
    			
    			// ...
    			// result.get() blocks on response
    			System.out.println("Update time : " + result.get().getUpdateTime());
    			
    			
    			
    			
    	
        SpringApplication.run(App.class, args);
    }

}
