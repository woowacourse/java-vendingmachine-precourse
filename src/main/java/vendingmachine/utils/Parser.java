package vendingmachine.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import vendingmachine.domain.Product;
import vendingmachine.validator.InputProductValidator;

public class Parser {
    public static int inputMoneyParser(String money) {
        return Integer.parseInt(money);
    }

    public static List<Product> productsParser(String inputProducts) {
        String[] products = inputProducts.split(";");
        Set<String> productNames = new HashSet<>();
        List<Product> machineProducts = new ArrayList<>();
        for (String product : products) {
            Product parsedProduct = InputProductValidator.validateProduct(product);
            if (!productNames.add(parsedProduct.getName())) {
                throw new IllegalArgumentException("[ERROR] 중복된 상품이 존재합니다.");
            }
            machineProducts.add(parsedProduct);
        }

        return machineProducts;
    }
}
