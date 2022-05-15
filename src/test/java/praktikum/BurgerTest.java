package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger = new Burger();

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Mock
    Database database;

 /*   @Before
    public void setUp() {
        Mockito.when(database.availableBuns()).thenReturn(new ArrayList<Bun>(new Bun("black bun", 100), new Bun(
                "white bun", 200), new Bun("red bun", 300)));
        Mockito.when(database.availableIngredients().get(0)).thenReturn(new Ingredient(IngredientType.SAUCE, "hot " +
                "sauce", 100));
        Mockito.when(database.availableIngredients().get(1)).thenReturn(new Ingredient(IngredientType.SAUCE, "sour " +
                "cream", 200));
        Mockito.when(database.availableIngredients().get(2)).thenReturn(new Ingredient(IngredientType.FILLING,
                "cutlet", 100));

        burger.ingredients = new ArrayList<>();
        burger.bun = database.availableBuns().get(0);
        burger.addIngredient(database.availableIngredients().get(0));
        burger.addIngredient(database.availableIngredients().get(1));
        burger.addIngredient(database.availableIngredients().get(2));
    }*/



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

        Mockito.when(bun.getPrice()).thenReturn(5.5f);
        Mockito.when(ingredient.getPrice()).thenReturn(1.1f);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        float actual = burger.getPrice();

        assertEquals(0, Float.compare(12.1f, actual));
    }

    @Test
    public void burgerGetReceipt() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "cutlet", 100);

        Mockito.when(bun.getName()).thenReturn("white bun");

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        String expected = "(==== white bun ====)\n" +
                "= filling cutlet =\n" +
                "(==== white bun ====)\n" +
                "\n" +
                "Price: 100,000000\n";

        String actual = burger.getReceipt();

        assertEquals(expected, actual);
    }
}