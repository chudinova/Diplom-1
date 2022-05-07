package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BurgerTest {
    Burger burger = new Burger();
    Database database = new Database();

    @Before
    public void setUp() {
        burger.ingredients = new ArrayList<>();
        burger.bun = database.availableBuns().get(0);
        burger.addIngredient(database.availableIngredients().get(0));
        burger.addIngredient(database.availableIngredients().get(1));
        burger.addIngredient(database.availableIngredients().get(2));
    }


    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        Ingredient burgerFirstIngredient = burger.ingredients.get(0);
        burger.removeIngredient(0);
        assertFalse(burger.ingredients.contains(burgerFirstIngredient));
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        Ingredient expected = burger.ingredients.get(0);
        burger.moveIngredient(1, 0);
        Ingredient actual = burger.ingredients.get(1);
        assertEquals(expected, actual);
    }

    @Test
    public void burgerGetPriceTest() {

        float expected =
                (database.availableBuns().get(0).getPrice() * 2 +
                        database.availableIngredients().get(0).getPrice() +
                        database.availableIngredients().get(1).getPrice() +
                        database.availableIngredients().get(2).getPrice());
        float actual = burger.getPrice();
        assertEquals(expected, actual, 0.0);
    }

    @Test
    public void burgerGetReceipt() {
        String actual = burger.getReceipt();
        String expected = "(==== black bun ====)\n" +
                "= sauce hot sauce =\n" +
                "= sauce sour cream =\n" +
                "= sauce chili sauce =\n" +
                "(==== black bun ====)\n" +
                "\n" +
                "Price: 800,000000\n";
        assertEquals(expected, actual);
    }
}