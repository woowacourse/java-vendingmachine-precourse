package vendingmachine.products;

import vendingmachine.ValidatorMessage;

import java.util.ArrayList;
import java.util.List;

public class ProductsController {
    private static final String PRODUCTS_SEPARATE_UNIT = ";";
    private static final int EMPTY_STOCK = 0;

    private final Products products;

    public ProductsController() {
        products = new Products();
    }

    public void initProducts() {
        List<String> productList = new ArrayList<>();
        try {
            String productsListInput = ProductsInputView.inputProductsInitInfo();
            ProductsValidator.validateProductInfo(productsListInput);
            ProductsValidator.validateRightInfo(productsListInput);
            productList = separateProductsInfo(productsListInput);
        } catch (IllegalArgumentException e) {
            ValidatorMessage.printError(e.getMessage());
            initProducts();
        }
        products.setProducts(productList);
    }

    public List<String> separateProductsInfo(String productsListInput) {
        String[] productsInfo = productsListInput.split(PRODUCTS_SEPARATE_UNIT);
        List<String> productsList = new ArrayList<>();
        for (String productInfo : productsInfo) {
            productsList.add(productInfo.substring(1, productInfo.length() - 1));
        }
        return productsList;
    }

    public Product findProduct(String productName) {
        return products.findProduct(productName);
    }

    public boolean canBuyAnyProduct(int amount) {
        return products.findMinCountsProduct() != EMPTY_STOCK
                && products.findMinPriceProduct() <= amount;
    }

    public void canHaveStock(Product product) {
        ProductsValidator.checkEnoughCounts(product);
    }

    public void buyProduct(Product product) {
        products.buyProduct(product);
    }
}
