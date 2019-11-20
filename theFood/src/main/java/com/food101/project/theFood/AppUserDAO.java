package com.food101.project.theFood;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;

import data.AppUser;
import data.AppUserForm;
import data.Gender;
 
@Repository
public class AppUserDAO {
 
    // Config in WebSecurityConfig
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public String name="";
 
    private static final Map<Long, AppUser> USERS_MAP = new HashMap<Long, AppUser>();
 
    static {
        try {
			initDATA();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
 
    private static void initDATA() throws InterruptedException, ExecutionException {
        String encrytedPassword = "12";
 
        AppUser tom = new AppUser(1L, "tom", "Tom", "Tom", //
                true, Gender.MALE, "tom@waltdisney.com", encrytedPassword, "US");
 
        AppUser jerry = new AppUser(2L, "jerry", "Jerry", "Jerry", //
                true, Gender.MALE, "jerry@waltdisney.com", encrytedPassword, "US");
 
        USERS_MAP.put(tom.getUserId(), tom);
        USERS_MAP.put(jerry.getUserId(), jerry);
    }
 
    public Long getMaxUserId() {
        long max = 0;
        for (Long id : USERS_MAP.keySet()) {
            if (id > max) {
                max = id;
            }
        }
        return max;
    }
 
    //
 
    public AppUser findAppUserByUserName(String userName) throws InterruptedException, ExecutionException {
    	Firestore db1 = FirestoreClient.getFirestore();
    	ApiFuture<QuerySnapshot> future = db1.collection("User").get();

    	List<QueryDocumentSnapshot> documents = future.get().getDocuments();
    		
    		for (DocumentSnapshot document : documents) {
    			  if(document.toObject(AppUser.class).getUserName().equalsIgnoreCase(userName)) {
    				  return document.toObject(AppUser.class);
    			  }
    			}
    	return null;
    }
 
    public AppUser findAppUserByEmail(String email) {
        Collection<AppUser> appUsers = USERS_MAP.values();
        for (AppUser u : appUsers) {
            if (u.getEmail().equals(email)) {
                return u;
            }
        }
        return null;
    }
 
    public List<AppUser> getAppUsers() {
        List<AppUser> list = new ArrayList<AppUser>();
 
        list.addAll(USERS_MAP.values());
        return list;
    }
 
    public AppUser createAppUser(AppUserForm form) throws InterruptedException, ExecutionException {
        Long userId = this.getMaxUserId() + 1;
       String encrytedPassword = this.passwordEncoder.encode(form.getPassword());
       // String encrytedPassword = form.getPassword();
 
        AppUser user = new AppUser(userId, form.getUserName(), //
                form.getFirstName(), form.getLastName(), false, //
                form.getGender(), form.getEmail(), form.getCountryCode(), //
                encrytedPassword);
 
        USERS_MAP.put(userId, user);
        name = user.getUserName();
        return user;
    }
 
}