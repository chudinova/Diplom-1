package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void valuesSauseTest() {
        IngredientType actual = IngredientType.SAUCE;
        IngredientType expected = IngredientType.SAUCE;
        assertEquals(expected, actual);
    }

    @Test
    public void valuesFillingTest() {
        IngredientType actual = IngredientType.FILLING;
        IngredientType expected = IngredientType.FILLING;
        assertEquals(expected, actual);
    }
}