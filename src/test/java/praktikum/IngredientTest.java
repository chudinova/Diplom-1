package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {

    private final static IngredientType TYPE = IngredientType.FILLING;
    private final static String NAME = "cutlet";
    private final static float PRICE = 100f;


    Ingredient ingredient = new Ingredient(TYPE, NAME, PRICE);

    @Test
    public void ingredientGetPriceTest() {
        float actual = ingredient.getPrice();
        assertEquals(0, Float.compare(PRICE, actual));
    }

    @Test
    public void ingredientGetNameTest() {
        String actual = ingredient.getName();
        assertEquals(NAME, actual);
    }

    @Test
    public void ingredientGetTypeTest() {
        IngredientType actual = ingredient.getType();
        assertEquals(TYPE, actual);
    }
}