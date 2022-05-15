package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest {


    String name = "Булка";
    float price = 111.00f;
    Bun bun = new Bun(name, price);

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