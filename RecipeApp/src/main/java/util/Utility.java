package util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import model.Recipe;

public class Utility {

	List<Recipe> recipeListObj = new ArrayList<Recipe>();

	public List<Recipe> readRecipeJson() {

		try {
			JSONParser parser = new JSONParser();
			JSONArray jsonArray = (JSONArray) parser
					.parse(new FileReader(getClass().getClassLoader().getResource("recipe.json").getFile()));

			for (Object obj : jsonArray) {
				JSONObject receipe = (JSONObject) obj;
				Recipe reObj = new Recipe();
				String strtitle = (String) receipe.get("title");
				reObj.setTitle(strtitle);

				String strhref = (String) receipe.get("href");
				reObj.setHref(strhref);

				String strthumbnail = (String) receipe.get("thumbnail");
				reObj.setStrthumbnail(strthumbnail);

				JSONArray arrays = (JSONArray) receipe.get("ingredients");
				List<String> ingredientsList = new ArrayList<String>();
				for (Object object : arrays) {
					String strIngredient = object.toString();
					ingredientsList.add(strIngredient);
				}
				reObj.setIngredients(ingredientsList);
				recipeListObj.add(reObj);
				recipeListObj.sort((Recipe recipe1, Recipe recipe2) -> recipe1.getTitle().compareTo(recipe2.getTitle()));

			}
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}

		return recipeListObj;
	}

	public Set<String> readIngredients() {

		List<Recipe> recipelist = readRecipeJson();

		java.util.Iterator<Recipe> itr = recipelist.iterator();

		Set<String> ingredients = new HashSet<String>();
		Recipe recipe;
		while (itr.hasNext()) {
			recipe = itr.next();

			List<String> ingredientsList = recipe.getIngredients();

			for (String string : ingredientsList) {
				ingredients.add(string);
			}

		}

		return ingredients;
	}

	public Set<String> searchRecipe(String[] strIngredients) {

		List<Recipe> recipelist = readRecipeJson();
		Set<String> strReceipelist = new HashSet<String>();

		java.util.Iterator<Recipe> itr = recipelist.iterator();
		String strTitle = null;
		boolean bValue = false;
		while (itr.hasNext()) {
			Recipe recipe = new Recipe();
			recipe = itr.next();
			strTitle = recipe.getTitle();
			List<String> ingredients = recipe.getIngredients();
			for (String string : strIngredients) {
				bValue = ingredients.contains(string);
				if (bValue == false)
					break;
			}
			if (bValue) {
				strReceipelist.add(strTitle);
			}
		}

		return strReceipelist;
	}

}