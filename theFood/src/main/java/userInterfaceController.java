import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import data.Food;
import data.foodRecipe;
import supply.Search;


@Controller
public class userInterfaceController {
	@Autowired
	Search s;
	
	   @RequestMapping(value = "hello", method = RequestMethod.GET)
	   public String viewRegister(
			   @RequestParam(value = "hi", required =true)String name, Model model) throws InterruptedException, ExecutionException {
	 
	      
	      Food[] food = s.findFood(name);
	      System.out.print(name);
	      model.addAttribute("userIds", food);
	      
	      return "hello";
	      
	   }
	

}
