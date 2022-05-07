package praktikum;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

//если честно, совсем не поняла, что и как здесь проверять... Может направите?

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