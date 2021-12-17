package vendingmachine;

import vendingmachine.domain.Product;
import vendingmachine.domain.ProductList;
import vendingmachine.validator.ProductValidator;

public class ProductDivider {
    private static final ProductValidator productValidator = new ProductValidator();
    private ProductList productList;

    public void divideProduct(ProductList productList, String productsString) {
        this.productList = productList;
        String[] products = changeStringToProductList(productsString);
        for (String productInfo : products) {
            Product product = changeStringToProductInformation(productInfo);
            productList.addProductList(product.getName(), product);
        }
    }

    public String[] changeStringToProductList(String inputProduct) {
        String[] productList = productValidator.validateSplitRegex(inputProduct);
        for (String productInfo : productList) {
            changeStringToProductInformation(productInfo);
        }
        return productList;
    }

    public Product changeStringToProductInformation(String productInfo) {
        productInfo = removeBracketInProduct(productInfo);
        String[] productInformation = productValidator.validateProductInfoSplitRegex(productInfo);
        return validateInformation(productInformation);
    }

    public Product validateInformation(String[] productInformation) {
        String name = productInformation[0];
        productValidator.validateDuplicateProductName(productList, name);
        int price = productValidator.validatePrice(productInformation[1]);
        int amount = productValidator.validateAmount(productInformation[2]);
        Product product = new Product(name, price, amount);
        return product;
    }

    private String removeBracketInProduct(String productInfo) {
        return productInfo.substring(1, productInfo.length() - 1);
    }
}
