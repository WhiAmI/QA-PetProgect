package automation.tests;

import automation.base.BaseTest;
import automation.pages.CartBadgePage;
import automation.pages.ProductsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductsTest extends BaseTest {

    private static final String USERNAME = "standard_user";
    private static final String PASSWORD = "secret_sauce";
    private static final String sortLowToHigh = "Price (low to high)";
    private static final String sortHighToLow = "Price (high to low)";
    private static final String sortAtoZ = "Name (A to Z)";
    private static final String sortZtoA = "Name (Z to A)";

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

        List<String> actualName = productsPage.getProductsNames();

        List<String> expectedName = new ArrayList<>(actualName);
        expectedName.sort(Comparator.naturalOrder());

        Assertions.assertEquals(expectedName, actualName);
    }

    @Test
    public void shouldSortProductsByNameNameZtoA(){
        ProductsPage productsPage = login(USERNAME, PASSWORD);

        productsPage.sortByVisibleText(sortZtoA);

        List<String> actualName = productsPage.getProductsNames();

        List<String> expectedName = new ArrayList<>(actualName);
        expectedName.sort(Comparator.reverseOrder());

        Assertions.assertEquals(expectedName, actualName);
    }

    @Test
    public void shouldAddAllProductsToCart() {

        ProductsPage productsPage = login(USERNAME, PASSWORD);

        // 1. Запоминаем все товары ДО добавления
        List<String> expectedProductNames = productsPage.getProductsNames();

        List<Double> expectedProductPrices = productsPage.getProductPrices();

        // 2. Добавляем ВСЕ товары
        productsPage.addAllProductsToCart();

        // 3. Можно проверить количество товаров в badge
        Assertions.assertEquals(expectedProductNames.size(),
                                productsPage.getCartBadgeCount()
        );

        // 4. Переходим в корзину
        CartBadgePage cartBadgePage = productsPage.goToCartBadge();

        // 5. Получаем то, что реально оказалось в корзине
        List<String> actualProductNames = cartBadgePage.getProductsNames();

        List<Double> actualProductPrices = cartBadgePage.getProductPrices();

        // 6. Сравниваем
        Assertions.assertEquals(expectedProductNames,
                                actualProductNames
        );

        Assertions.assertEquals(expectedProductPrices,
                actualProductPrices
        );
    }
}