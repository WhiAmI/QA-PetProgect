package automation.tests;

import automation.base.BaseTest;
import automation.pages.ProductsPage;

public class ProductsPageTest extends BaseTest {
    public void shouldSortProductsByPriceLowToHigh() {
        ProductsPage productsPage = login("standard_user", "secret_sauce");

        productsPage.sortByVisibleText
    }
}
