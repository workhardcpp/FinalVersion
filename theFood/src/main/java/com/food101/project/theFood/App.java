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
    			  new FileInputStream("D:\\foodrecipe-ebdec-firebase-adminsdk-d37z1-341aa1c134.json");

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
    			 * 
    			 *
    			 */
    			//List<foodRecipe> l = new ArrayList<foodRecipe>();
    			
                /*
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
    			
    			*/
                
                
                List<Meat> pepper_steak_list = new ArrayList<Meat>();
                pepper_steak_list.add(new Meat("steak","1"));    	
                pepper_steak_list.add(new Meat("soysauce","1"));  
                pepper_steak_list.add(new Meat("ginger","2"));   
                pepper_steak_list.add(new Meat("pepper","3"));  

                    			
                foodRecipe pepper_steak = new foodRecipe(
                		//菜名
                		"Chinese pepper steak",
                		//材料list
                		pepper_steak_list, 
                		//做法
                		"Slice the steak into 1/2-inch thick slices across the grain.t.\nHeat 1 tablespoon of vegetable oil in a wok or large skillet over medium-high heat, and place 1/3 of the steak strips into the hot oil. Cook and stir until the beef is well-browned, about 3 minutes, and remove the beef from the wok to a bowl. Repeat twice more, with the remaining beef, and set the cooked beef aside.\neturn all the cooked beef to the hot wok, and stir in the onion. Toss the beef and onion together until the onion begins to soften, about 2 minutes, then stir in the green pepper. Cook and stir the mixture until the pepper has turned bright green and started to become tender, about 2 minutes, then add the tomatoes, stir everything together, and serve.",
                		//网页图片 （尽量找jpg结尾的url）
                		"https://images.media-allrecipes.com/userphotos/600x600/7127114.jpg"
                		);
                
  			
                DocumentReference pepper_steak_ref = db.collection("foodRecipe").document(
                //菜名
                "Chinese Pepper Steak"
                );
                    			
                ApiFuture<WriteResult> pepper_steak_result = pepper_steak_ref.set(pepper_steak);
                    				
                
                
                List<Meat> pineapple_fried_rice_list = new ArrayList<Meat>();
                pineapple_fried_rice_list.add(new Meat("white rice","1"));    	
                pineapple_fried_rice_list.add(new Meat("onion","3"));  
                pineapple_fried_rice_list.add(new Meat("ham","1"));   
                pineapple_fried_rice_list.add(new Meat("pineapple","8"));  


                    			
                foodRecipe pineapple_fried_rice = new foodRecipe(
                		//菜名
                		"Pineapple Fried Rice",
                		//材料list
                		pineapple_fried_rice_list, 
                		//做法
                		"Bring the rice and water to a boil in a saucepan over high heat. Reduce heat to medium-low, cover, and simmer until the rice is tender, and the liquid has been absorbed, 20 to 25 minutes. Spread cooked rice out on a rimmed baking sheet and refrigerate until cooled, about 20 minutes.\nHeat sesame oil in a large skillet or wok over medium-high heat. Cook and stir the green onions, ham, and peas in the hot oil until onions have softened, about 2 minutes. Stir the pineapple chunks into the wok; cook until pineapple begins to darken, about 2 minute. Push ingredients to the side of the wok, and pour beaten egg in the center. Cook until egg begins to set, about 30 seconds. Stir together all contents of the wok.\nMix the cooled rice, sugar, salt, white pepper, and garlic powder into the wok; stir constantly to keep from sticking. Cook until heated through, about 3 minutes. Sprinkle the rice with the soy sauce, and stir to combine.",
                		//网页图片 （尽量找jpg结尾的url）
                		"https://images.media-allrecipes.com/userphotos/250x250/384934.jpg"
                		);
                
  			
                DocumentReference pineapple_fried_rice_ref = db.collection("foodRecipe").document(
                //菜名
                "Pineapple_fried_rice"
                );
                    			
                ApiFuture<WriteResult> pineapple_fried_rice_result = pineapple_fried_rice_ref.set(pineapple_fried_rice);
    			
    			
                
                List<Meat> creamy_mushroom_meatloaf_list = new ArrayList<Meat>();
                creamy_mushroom_meatloaf_list.add(new Meat("buter","1"));    	
                creamy_mushroom_meatloaf_list.add(new Meat("mushrooms, sliced","3"));  
                creamy_mushroom_meatloaf_list.add(new Meat("salt","1"));   
                creamy_mushroom_meatloaf_list.add(new Meat("flour","3"));  
        		creamy_mushroom_meatloaf_list.add(new Meat("heavy cream","2"));  
        		creamy_mushroom_meatloaf_list.add(new Meat("beef","2"));  



                            			
                        foodRecipe creamy_mushroom_meatloaf = new foodRecipe(
                        		//菜名
                        		"Creamy mushroom meatloaf",
                        		//材料list
                        		creamy_mushroom_meatloaf_list, 
                        		//做法
                        		"Preheat the oven to 325 degrees F (165 degrees C).\nMelt butter in an oven-safe skillet over medium-high heat. Stir in mushrooms and a pinch of salt; cook and stir until mushrooms begin to brown, about 5 minutes.\nWhisk in beef broth, 1/2 cup at a time, whisking constantly to prevent lumps.Turn heat to high and bring the sauce to a simmer. Simmer a few minutes until sauce starts to thicken. Season with salt and pepper to taste.\nStir in fresh rosemary. Add flour and stir to coat the mushrooms; cook and stir for about 3 minutes.\nRemove pan from the oven and gently remove meatloaf to a serving platter.Skim off any extra fat from the surface of the sauce.Bring the sauce to a boil over medium-high heat to reduce until thick, about 5 minutes.",
                        		//网页图片 （尽量找jpg结尾的url）
                        		"https://images.media-allrecipes.com/userphotos/720x405/3563536.jpg"
                        		);
                        
          			
                        DocumentReference creamy_mushroom_meatloaf_ref = db.collection("foodRecipe").document(
                        //菜名
                        "Cream mushroom meatloaf"
                        );
                            			
                        ApiFuture<WriteResult> creamy_mushroom_meatloaf_result = creamy_mushroom_meatloaf_ref.set(creamy_mushroom_meatloaf);
                        
        //2.
        List<Meat> shrimp_pasta_list = new ArrayList<Meat>();

                		shrimp_pasta_list.add(new Meat("buter","2"));    	
                        shrimp_pasta_list.add(new Meat("garlic","2")); 
                        shrimp_pasta_list.add(new Meat("pepper","1"));   
                        shrimp_pasta_list.add(new Meat("shrimp","3"));  
                  		shrimp_pasta_list.add(new Meat("pasta","2"));  
                  		shrimp_pasta_list.add(new Meat("lemmon","2"));  
                                      			
                                  foodRecipe shrimp_pasta = new foodRecipe(
                                  		//菜名
                                  		"shrimp pasta",
                                  		//材料list
                                  		shrimp_pasta_list, 
                                  		//做法
                                  		"Bring a large pot of salted water to a boil; cook linguine in boiling water until nearly tender, 6 to 8 minutes. Drain.\nMelt 2 tablespoons butter with 2 tablespoons olive oil in a large skillet over medium heat. Cook and stir shallots, garlic, and red pepper flakes in the hot butter and oil until shallots are translucent, 3 to 4 minutes. Season shrimp with kosher salt and black pepper; add to the skillet and cook until pink, stirring occasionally, 2 to 3 minutes. Remove shrimp from skillet and keep warm\nPour white wine and lemon juice into skillet and bring to a boil while scraping the browned bits of food off of the bottom of the skillet with a wooden spoon. Melt 2 tablespoons butter in skillet, stir 2 tablespoons olive oil into butter mixture, and bring to a simmer. Toss linguine, shrimp, and parsley in the butter mixture until coated; season with salt and black pepper. Drizzle with 1 teaspoon olive oil to serve.",
                                  		//网页图片 （尽量找jpg结尾的url）
                                  		"https://images.media-allrecipes.com/userphotos/720x405/7190959.jpg"
                                  		);
                                  
                    			
                                  DocumentReference shrimp_pasta_ref = db.collection("foodRecipe").document(
                                  //菜名
                                  "shrimp pasta"
                                  );
                                      			
                                  ApiFuture<WriteResult> shrimp_pasta_result = shrimp_pasta_ref.set(shrimp_pasta);
        //3
                                  List<Meat> mongolian_beef_list = new ArrayList<Meat>();
                                  mongolian_beef_list.add(new Meat("boneless beef","2"));    	
                                  mongolian_beef_list.add(new Meat("soy sauce","2"));  
                                 mongolian_beef_list.add(new Meat("bronw sugar","2"));   
                                  mongolian_beef_list.add(new Meat("pepper","3"));  
                  		mongolian_beef_list.add(new Meat("green onions","2"));  
                  		mongolian_beef_list.add(new Meat("cornstarch","2"));  



                                      			
                                  foodRecipe mongolian_beef = new foodRecipe(
                                  		//菜名
                                  		"Mongolian beef",
                                  		//材料list
                                  		mongolian_beef_list, 
                                  		//做法
                                  		"Partially freeze the roast for easier slicing. Slice the roast into 3x1/2 inch strips, and set aside.\nIn a large bowl, combine well the soy sauce, sherry, sesame oil, cornstarch, brown sugar, crushed red pepper and whole chile peppers. Place beef in the mixture and coat well. Cover and refrigerate for 20 to 30 minutes.\nHeat 2 tablespoons of the oil in a large skillet or wok over medium high heat. Place green onions in the hot oil. Cover, reduce heat to low and cook 6 minutes, or until tender. Remove green onions and set aside.\nIn the same skillet or wok, heat remaining 1/4 cup of oil over medium high heat. Add beef mixture and saute for 5 minutes, or until the beef is thoroughly cooked. Return green onions to the pan and saute for 30 seconds more, or until heated through.",
                                  		//网页图片 （尽量找jpg结尾的url）
                                  		"https://images.media-allrecipes.com/userphotos/720x405/297149.jpg"
                                  		);
                                  
                    			
                                  DocumentReference mongolian_beef_ref = db.collection("foodRecipe").document(
                                  //菜名
                                  "Mongolian beef"
                                  );
                                      			
                                  ApiFuture<WriteResult> mongolian_beef_result = mongolian_beef_ref.set(mongolian_beef);


        //4
                                  List<Meat> turkey_breast_list = new ArrayList<Meat>();
                                  turkey_breast_list.add(new Meat("buttermilk","2"));    	
                                  turkey_breast_list.add(new Meat("boneless turkey","4"));  
                                 turkey_breast_list.add(new Meat("rosemary","1"));   
                                  turkey_breast_list.add(new Meat("thyme","2"));  
                  		



                                      			
                                  foodRecipe turkey_breast = new foodRecipe(
                                  		//菜名
                                  		"Turkey Breast",
                                  		//材料list
                                  		turkey_breast_list, 
                                  		//做法
                                  		"Whisk together olive brine and buttermilk. Put the turkey breast into a resealable plastic bag and pour brine-buttermilk mixture into the bag. Add rosemary and thyme sprigs. Seal bag and refrigerate for 8 hours.\nTake the bag out of the fridge and allow to rest until the breast reaches room temperature.\nPreheat an air fryer to 350 degrees F (175 degrees C).\n Cook the breast in the air fryer for 15 minutes. Flip over the breast and cook for 5 minutes until turkey breast is no longer pink in the center and the juices run clear. An instant-read thermometer inserted into the center should read at least 165 degrees F (74 degrees C). If internal temperature is lower, keep cooking at 5 minute intervals until the correct temperature is reached. ",
                                  		//网页图片 （尽量找jpg结尾的url）
                                  		"https://images.media-allrecipes.com/userphotos/720x405/5819973.jpg"
                                  		);
                                  
                    			
                                  DocumentReference turkey_breast_ref = db.collection("foodRecipe").document(
                                  //菜名
                                  "Turkey Breast"
                                  );
                                      			
                                  ApiFuture<WriteResult> turkey_breast_result = turkey_breast_ref.set(turkey_breast);
                       
        //5
        List<Meat> tofu_salad_list = new ArrayList<Meat>();
                         tofu_salad_list.add(new Meat("tofu","14"));    	
                         tofu_salad_list.add(new Meat("soy sauce","3"));  
                         tofu_salad_list.add(new Meat("vinegar","1"));   
                         tofu_salad_list.add(new Meat("garlic","2"));  
                  		 tofu_salad_list.add(new Meat("ginger","1"));  
                  		 tofu_salad_list.add(new Meat("onion","2"));  
                  		



                                      			
                                  foodRecipe tofu_salad = new foodRecipe(
                                  		//菜名
                                  		"Japanese Tofu Salad",
                                  		//材料list
                                  		tofu_salad_list, 
                                  		//做法
                                  		"Place tofu between two plates, and weigh down with a heavy book. Allow tofu to drain for 1 hour, pouring out the expelled liquid every 20 minutes.\nWhisk together the soy sauce, mirin, sesame oil, and rice vinegar in a small bowl. Heat the oil in a small pan over medium heat, stir in the garlic and ginger, and gently cook until lightly golden; stir into the soy sauce mixture.\nCut tofu into bite-sized pieces, and toss together with the tomato, onion, and cilantro. Pour in the dressing and toss to coat. Garnish with a sprinkle of sesame seeds.",
                                  		//网页图片 （尽量找jpg结尾的url）
                                  		"https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fimages.media-allrecipes.com%2Fuserphotos%2F1045329.jpg&w=722&h=483.74&c=sc&poi=face&q=85"
                                  		);
                                  
                    			
                                  DocumentReference tofu_salad_ref = db.collection("foodRecipe").document(
                                  //菜名
                                  "Japanese Tofu Salad"
                                  );
                                      			
                                  ApiFuture<WriteResult> tofu_salad_result = tofu_salad_ref.set(tofu_salad);



    	
        SpringApplication.run(App.class, args);
    }

}
