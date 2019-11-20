package com.food101.project.theFood;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
// import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

import data.AppUser;
import data.AppUserForm;
import data.Country;
import data.Food;
import data.Meat;
import data.Vege;
import data.foodRecipe;
import supply.Search;



 
@Controller
public class MainController {
	
 
   @Autowired
   private AppUserDAO appUserDAO;
 
   @Autowired
   private CountryDAO countryDAO;
 
   @Autowired
   private AppUserValidator appUserValidator;
   
   
   
   
   private Search s = new Search();
   
   /*
	
	@RequestMapping(value = "/recipe/{recipe}")
	public String getModel(Model model) throws InterruptedException, ExecutionException {
		/*ModelAndView model = new ModelAndView();
		
		
		System.out.println(s.findRecipe(rec).getName());
		model.setViewName(rec);
		model.addObject("s",s.findRecipe(rec));
		
		String rec="greenfood";
		model.addAttribute(s.findFood(rec));
		
		return "recipe";
		
	}
*/
   /*
   @RequestMapping(value = "/recipe/{recipe}", method = RequestMethod.GET)
	foodRecipe getUser(@PathVariable("recipe") String recipe) throws InterruptedException, ExecutionException {
	   foodRecipe r = s.findRecipe(recipe);
		return r;
	}
   */
   //, params = {"{recipe}"}
  /* @RequestMapping(value = "/recipe", method = RequestMethod.GET)
	String getUser(Model model,@RequestParam(value = "userId", required =false)String recipe) throws InterruptedException, ExecutionException {
	   
	   foodRecipe r = s.findRecipe(recipe);
	   model.addAttribute("ok", "cedd");
	   
	   
		return "recipe";
	}
   */
   
   @RequestMapping(value = "/recipe/{userId}")
   public String getUser(Model model,@PathVariable("userId") String userId) throws InterruptedException, ExecutionException {
	   foodRecipe r = s.findRecipe(userId);
	   
	  // model.addAttribute("Veges", r.vegeIngredient);
	   model.addAttribute("Meats", r.meatIngredient);
	 //  model.addAttribute("Conds", r.conIngredient);
	   
	   
	   /*
        <h2>Vegatable</h2>
        <th:block th:each="vege: ${Veges}">
            <a th:href="@{/(id=${vege})}"> Vegetables [[${vege}]]</a> <br/>
            <td><input type="text"  th:placeholder="${vege.weight}" maxlength="4" size="4"></td>
        </th:block>
        
        <h4>Condiment</h4>
        
        <th:block th:each="cond: ${Conds}">
            <a th:href="@{/(id=${cond})}"> Condiment: [[${cond}]]</a> <br/>
            <td><input type="text"  th:placeholder="${cond.weight}" maxlength="4" size="4"></td>
        </th:block>
        */
	   model.addAttribute("title", r.getName());
	   model.addAttribute("desc", r.getDescription());
	   model.addAttribute("img", "http://www.exampleimagehost.com/my-cute-dog.jpg");
	   System.out.print(r.getDescription());
	   
	   return "recipe";
   }
   /*
   @RequestMapping(value = "/update", method = RequestMethod.GET)
   public String update(Model model) throws InterruptedException, ExecutionException {
	   
	  /*
	   *    @RequestMapping(value = "/register", method = RequestMethod.GET)
   public String viewRegister(Model model) {
 
      AppUserForm form = new AppUserForm();
      List<Country> countries = countryDAO.getCountries();
 
      model.addAttribute("appUserForm", form);
      model.addAttribute("countries", countries);
 
      return "/register";//registerPage
   }
	   
	   
	   Meat meat = new Meat();
	   return "/update";
	 /*  
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
	   
	   
	   
	   return "update";
	   
   }
   */
   

   
	   @RequestMapping(value = "hello", method = RequestMethod.GET)
	   public String viewRegister( Model model,@RequestParam(value = "hi", required =false)String name) throws InterruptedException, ExecutionException {
		   

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


		
	      Meat[] food = new Meat[2];//s.findFood("xx1");
	      food[0] = new Meat("tomato", "10");
	      food[1] = new Meat("beef","33");
	      /*
	      model.addAttribute("Veges", user.getVegeList());
	      System.out.print(user.getVegeList().size());
	      */
	      model.addAttribute("Meats", user.getMeatList());
	     // model.addAttribute("Conds", user.getConList());
	      
	      model.addAttribute("Conds", user.getRecipeList());
	      
	      return "hello";
	      
	   }
	   
	  
		@RequestMapping(value = "/hello",method = RequestMethod.POST)
	    public String index(String searchInput,Model model) throws InterruptedException, ExecutionException {
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


						
					      Meat[] food = new Meat[2];//s.findFood("xx1");
					      food[0] = new Meat("tomato", "10");
					      food[1] = new Meat("beef","33");
					      /*
					      model.addAttribute("Veges", user.getVegeList());
					      System.out.print(user.getVegeList().size());
					      */
					      model.addAttribute("Meats", user.getMeatList());
					      
					      model.addAttribute("Conds", user.getRecipeList());
			
			
		      
			return "hello";
	    }
   
 
   // Set a form validator
   @InitBinder
   protected void initBinder(WebDataBinder dataBinder) {
      // Form target
      Object target = dataBinder.getTarget();
      if (target == null) {
         return;
      }
      System.out.println("Target=" + target);
 
      if (target.getClass() == AppUserForm.class) {
         dataBinder.setValidator(appUserValidator);
      }
      // ...
   }
 
   /*
   @RequestMapping("/")
   public String viewHome(Model model) {
 
      return "welcomePage";
   }
 
   
   @RequestMapping("/members")
   public String viewMembers(Model model) {
 
      List<AppUser> list = appUserDAO.getAppUsers();
 
      model.addAttribute("members", list);
 
      return "membersPage";
   }
   */
 
   @RequestMapping("/registerSuccessfulPage")
   public String viewRegisterSuccessful(Model model) {
 
      return "/registerSuccessfulPage";
   }
 
 
   // Show Register page.
   @RequestMapping(value = "/register", method = RequestMethod.GET)
   public String viewRegister(Model model) {
 
      AppUserForm form = new AppUserForm();
      List<Country> countries = countryDAO.getCountries();
 
      model.addAttribute("appUserForm", form);
      model.addAttribute("countries", countries);
 
      return "/register";//registerPage
   }
 
   // This method is called to save the registration information.
   // @Validated: To ensure that this Form
   // has been Validated before this method is invoked.
   @RequestMapping(value = "/register", method = RequestMethod.POST)
   public String saveRegister(Model model, //
         @ModelAttribute("appUserForm") @Validated AppUserForm appUserForm, //
         BindingResult result, //
         final RedirectAttributes redirectAttributes) {
 
      // Validate result
      if (result.hasErrors()) {
         List<Country> countries = countryDAO.getCountries();
         model.addAttribute("countries", countries);
         return "register";
      }
      AppUser newUser= null;
      try {
         newUser = appUserDAO.createAppUser(appUserForm);
      }
      // Other error!!
      catch (Exception e) {
         List<Country> countries = countryDAO.getCountries();
         model.addAttribute("countries", countries);
         model.addAttribute("errorMessage", "Error: " + e.getMessage());
         return "register";
      }
 
      redirectAttributes.addFlashAttribute("flashUser", newUser);
      
      Firestore db = FirestoreClient.getFirestore();
		
		DocumentReference docRef = db.collection("User").document(newUser.getUserName());
		
		docRef.set(newUser);
		
       
      return "registerSuccessfulPage";
   }
}
