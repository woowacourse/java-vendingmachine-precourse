package vendingmachine.products;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class ProductsController {
    private static final String PRODUCTS_INIT_MESSAGE = "상품명과 가격, 수량을 입력해 주세요.";
    private static final String PRODUCTS_SEPARATE_UNIT = ";";

    private final Products products;

    public ProductsController() {
        products = new Products();
    }

    public void initProducts() {
        List<String> productsList = new ArrayList<>();
        try {
            System.out.println(PRODUCTS_INIT_MESSAGE);
            String productsListInput = Console.readLine();
            // 검증로직
            productsList = separateProductsInfo(productsListInput);
        } catch (IllegalArgumentException e) {
            initProducts();
        }
    }

    public List<String> separateProductsInfo(String productsListInput) {
        String[] productsInfo = productsListInput.split(PRODUCTS_SEPARATE_UNIT);
        List<String> productsList = new ArrayList<>();
        for (String productInfo : productsInfo) {
            productsList.add(productInfo.substring(1, productInfo.length() - 2));
        }
        return productsList;
    }
}
