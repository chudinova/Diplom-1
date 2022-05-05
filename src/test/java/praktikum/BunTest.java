package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BunTest {

    Bun bun;
    String name = "Булка";
    float price = 111.00f;

    @Before
    public void setUp() {
         bun = new Bun(name, price);
    }

    @Test
    public void getName() {
        String actual = bun.getName();
        String expected = name;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPrice() {
        float actual = bun.getPrice();
        float expected = price;
        Assert.assertEquals(expected, actual, 0.0);
    }
}