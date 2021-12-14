package vendingmachine;

import vendingmachine.util.VendingMachineConstant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Products {
    private static final List<Product> products = new ArrayList<>();

    public Products(String productInfo) {
        makeProducts(productInfo);
    }

    private void makeProducts(String productInfo) {
        String[] productsString = productInfo.split(";");
        for (String productString : productsString) {
            List<String> productResult = Arrays.asList(productString.replace("[", "").replace("]", "").split(","));
            Product product = new Product(productResult.get(0), Integer.parseInt(productResult.get(1)), Integer.parseInt(productResult.get(2)));
            products.add(product);
        }
    }

    public Product getProduct(String productName) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        throw new IllegalArgumentException(VendingMachineConstant.NOT_EXIST_PRODUCT);
    }

    public boolean checkInputMoney(int money) {
        return products.stream().mapToInt(Product::getPrice).min().orElse(0) <= money;
    }

    public boolean checkExistAmount() {
        return products.stream().mapToInt(Product::getAmount).sum() != 0;
    }
}
