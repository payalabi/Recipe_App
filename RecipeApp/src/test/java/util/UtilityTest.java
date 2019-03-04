package util;

import static org.junit.Assert.*;

import org.junit.Test;

public class UtilityTest {
	Utility utilObj= new Utility(); 
	@Test
	public void testReadRecipeJson() {
		//fail("Not yet implemented");
		
		
		assertFalse("Recipe list should not be empty", utilObj.readRecipeJson().isEmpty());
		
	}

	@Test
	public void testReadIngredients() {
		//fail("Not yet implemented");
		
		assertFalse("Ingredient list should not be empty", utilObj.readIngredients().isEmpty());
	}

	@Test
	public void testSearchRecipe() {
		//fail("Not yet implemented");
		String[] strIngredients= {"onions","butter"};
		assertEquals("[Crock Pot Caramelized Onions]",utilObj.searchRecipe(strIngredients).toString()) ;
		
		//assertFalse(Onliion list should not be empty, condition);
	}

}
