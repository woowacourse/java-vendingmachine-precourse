package vendingmachine;

import static vendingmachine.Messages.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Products {

    public List<Product> getProducts(String inputProducts) {
        List<Product> products = new ArrayList<>();
        for (String product : inputProducts.split(";")) {
            String[] elements = product.replaceFirst("^.", "")
                    .replaceFirst(".$", "")
                    .split(",");
            products.add(new Product(elements[0],
                    Integer.parseInt(elements[1]), Integer.parseInt(elements[2])));
        }
        return products;
    }

    public void validateProductsPrice(List<Product> products) {
        for (Product product : products) {
            validateProductsMinimum(product);
            validateProductsUnit(product);
        }
    }

    public void validateProductsMinimum(Product product) {
        if (product.getProductPrice() < 100) {
            throw new IllegalArgumentException(ERROR_PRODUCT_PRICE_MINIMUM);
        }
    }

    public void validateProductsUnit(Product product) {
        if (product.getProductPrice() % 10 != 0) {
            throw new IllegalArgumentException(ERROR_PRODUCT_PRICE_UNIT);
        }
    }

    public int calculate(List<Product> productList, int money, String productName) {
        for (Product product : productList) {
            if (product.getProductName().equals(productName)) {
                product = new Product(product.getProductName(), product.getProductPrice(),
                        product.getProductCount() - 1);
                money -= product.getProductPrice();
            }
        }
        return money;
    }

    public void validateProductName(String productName, List<Product> productList) {
        if (productList.stream().noneMatch(product -> product.getProductName().equals(productName))) {
            throw new IllegalArgumentException(ERROR_PRODUCT_NAME);
        }
    }

    public int getMinimumPrice(List<Product> productList) {
        return productList.stream().min(Comparator.comparingInt(Product::getProductPrice)).get().getProductPrice();
    }

    public boolean hasCount(List<Product> productList, String productName) {
        return productList.stream().filter(product -> product.getProductName().equals(productName))
                .anyMatch(product -> product.getProductCount() > 0);
    }
}