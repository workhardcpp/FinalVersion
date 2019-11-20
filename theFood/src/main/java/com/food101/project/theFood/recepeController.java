package com.food101.project.theFood;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import supply.Search;
/*

@Controller
@RequestMapping(value = "recipe")
public class recepeController {
	
	ModelAndView model = new ModelAndView();
	Search s =new Search();
	
	
	@GetMapping(value = "/{recipeName}")
	public ModelAndView getModel(@PathVariable("{recipeName}") String rec) throws InterruptedException, ExecutionException {
		
		System.out.println("working");
		
		model.setViewName(rec);
		model.addObject(s.findRecipe(rec));
		
		return model;
		
	}
	}
*/
