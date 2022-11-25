package vendingmachine;

import java.util.ArrayList;
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
            if (product.getProductPrice() < 100) {
                throw new IllegalArgumentException("[ERROR] 100원 이하는 입력할 수 없습니다.");
            }
            if (product.getProductPrice() % 10 != 0) {
                throw new IllegalArgumentException("[ERROR] 10원 단위로 입력해야 합니다.");
            }
        }
    }
}
