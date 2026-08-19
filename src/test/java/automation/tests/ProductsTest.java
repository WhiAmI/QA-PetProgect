package automation.tests;

import automation.base.BaseTest;
import automation.pages.ProductsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ProductsTest extends BaseTest {

    @Test
    public void shouldSortProductsByPriceLowToHigh() {
        ProductsPage productsPage = login("standard_user", "secret_sauce");

        productsPage.sortByVisibleText("Price (low to high)");

        List<Double> actualPrices = productsPage.getProductPrices();

        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        expectedPrices.sort(Double::compareTo);

        Assertions.assertEquals(expectedPrices, actualPrices);
    }
}