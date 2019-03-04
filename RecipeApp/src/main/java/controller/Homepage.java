package controller;

import javax.servlet.http.HttpServletResponse;

import java.util.*;

import javax.servlet.http.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import util.*;

@Controller

public class Homepage {

	Utility objUtil = new Utility();

	@GetMapping(value = "/")
	public String recipeList() {

		return "home";

	}

	@GetMapping(value = "/search")
	public ModelAndView listIngredients() {

		Set<String> ingredients = objUtil.readIngredients();
		Iterator<String> itr = ingredients.iterator();
		ModelAndView mv = new ModelAndView("ingredients");
		mv.addObject("INGREDIENTS_LIST", itr);
		return mv;

	}

	@PostMapping(value = "/list")
	public ModelAndView displayRecipe(HttpServletResponse response, HttpServletRequest request) {
		
		String[] str = request.getParameterValues("SELECTED_INGREDIENT");
		Set<String> strlist = objUtil.searchRecipe(str);
		ModelAndView mv = new ModelAndView("displayrecipe");
		Iterator<String> itr = strlist.iterator();
		mv.addObject("RECIPE_LIST", itr);

		return mv;

	}

}
