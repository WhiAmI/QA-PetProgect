package automation.tests;

import automation.base.BaseTest;
import automation.pages.ProductsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductsTest extends BaseTest {

    final String USERNAME = "standard_user";
    final String PASSWORD = "secret_sauce";
    final String sortLowToHigh = "Price (low to high)";
    final String sortHighToLow = "Price (high to low)";
    final String sortAtoZ = "Name (A to Z)";
    final String sortZtoA = "Name (Z to A)";

    @Test
    public void shouldSortProductsByPriceLowToHigh() {
        ProductsPage productsPage = login(USERNAME, PASSWORD);

        productsPage.sortByVisibleText(sortLowToHigh);

        List<Double> actualPrices = productsPage.getProductPrices();

        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        expectedPrices.sort(Double::compareTo);

        Assertions.assertEquals(expectedPrices, actualPrices);
    }

    @Test
    public void shouldSortProductsByPriceHighToLow() {
        ProductsPage productsPage = login(USERNAME, PASSWORD);

        productsPage.sortByVisibleText(sortHighToLow);

        List<Double> actualPrices = productsPage.getProductPrices();

        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        expectedPrices.sort(Collections.reverseOrder());

        Assertions.assertEquals(expectedPrices, actualPrices);
    }

    @Test
    public void shouldSortProductsByNameNameAtoZ(){
        ProductsPage productsPage = login(USERNAME, PASSWORD);

        productsPage.sortByVisibleText(sortAtoZ);

        List<String> actualName = productsPage.getProductsName();

        List<String> expectedName = new ArrayList<>(actualName);
        expectedName.sort(Comparator.naturalOrder());

        Assertions.assertEquals(expectedName, actualName);
    }

    @Test
    public void shouldSortProductsByNameNameZtoA(){
        ProductsPage productsPage = login(USERNAME, PASSWORD);

        productsPage.sortByVisibleText(sortZtoA);

        List<String> actualName = productsPage.getProductsName();

        List<String> expectedName = new ArrayList<>(actualName);
        expectedName.sort(Comparator.reverseOrder());

        Assertions.assertEquals(expectedName, actualName);
    }
}