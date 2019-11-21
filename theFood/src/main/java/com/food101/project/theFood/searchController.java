package com.food101.project.theFood;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

import data.AppUser;
import data.Food;
import data.Meat;
import data.foodRecipe;
import supply.Search;

@Controller
public class searchController {
	
	
	@RequestMapping("allFood")
    public String index3(
        Model model
    ) throws InterruptedException, ExecutionException {
		
		List<foodRecipe> list = new ArrayList<foodRecipe>();


		Firestore db1 = FirestoreClient.getFirestore();
		ApiFuture<QuerySnapshot> future = db1.collection("foodRecipe").get();


			List<QueryDocumentSnapshot> documents = future.get().getDocuments();
				
				for (DocumentSnapshot document : documents) {
					  list.add(document.toObject(foodRecipe.class));
					}
		
		model.addAttribute("userIds", list);
		
		
		return "home";
    }

	@RequestMapping("home")
    public String index(
        @RequestParam(value = "search", required = true) String searchInput,
        Model model
    ) throws InterruptedException, ExecutionException {
		
		System.out.println(searchInput);
		
		Search search = new Search();
		List<foodRecipe> list = search.performSearch(searchInput);
	
		
		String[] name = new String[list.size()];
		
		for(int i=0;i<list.size();i++) {
			name[i] =  list.get(i).getName();
		}
		
		model.addAttribute("userIds", name);
		
		
		return "home";
    }
	
	@RequestMapping("/update2")
    public String index2(
        @RequestParam(value = "Name", required = true) String na,
        @RequestParam(value = "Weight", required = true) String we,
        Model model
    ) throws InterruptedException, ExecutionException {
		
		
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		   
		   
		   String username;
		   if (principal instanceof UserDetails) {
		      username = ((UserDetails)principal).getUsername();
		     System.out.print(username);
		   } else {
		      username = principal.toString();
		   }
		   
		   Search search = new Search();
		   AppUser user = search.findUserbyUsername(username);
		   
		   Meat m = new Meat(na,we);
		
		
		   
		   Firestore db = FirestoreClient.getFirestore();
			DocumentReference docRef = db.collection("User").document(user.getUserName());
			
			ApiFuture<DocumentSnapshot> future = docRef.get();
			
			DocumentSnapshot document = future.get();
			if (document.exists()) {
				AppUser u = document.toObject(AppUser.class);
				
				
				u.updateFood(m);
				
				for(int i=0;i<u.getMeatList().size();i++) {
					if(u.getMeatList().get(i).getWeight()<=0) {
						u.getMeatList().remove(i);
					}
				}
				
				ApiFuture<WriteResult> future2 = db.collection("User").document(user.getUserName()).set(u);
				
			} else {
			  System.out.println("No such document!");
			}
		
		
		
		System.out.println(m.getName());
		System.out.println(m.getWeight());
		
		
		
		
		return "update";
    }



   

}
