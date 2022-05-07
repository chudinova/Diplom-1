package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTest {
    Database database = new Database();
    Ingredient ingredient = new Ingredient(database.availableIngredients().get(0).getType(),
            database.availableIngredients().get(0).getName(), database.availableIngredients().get(0).getPrice());

    @Test
    public void ingridientGetPriceTest() {
        float actual = ingredient.getPrice();
        float expected = database.availableIngredients().get(0).getPrice();
        assertEquals(expected, actual, 0.0);
    }

    @Test
    public void ingridientGetNameTest() {
        String actual = ingredient.getName();
        String expected = database.availableIngredients().get(0).getName();
        assertEquals(expected, actual);
    }

    @Test
    public void ingridientGetTypeTest() {
        IngredientType actual = ingredient.getType();
        IngredientType expected = database.availableIngredients().get(0).getType();
        assertEquals(expected, actual);
    }
}