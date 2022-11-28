package vendingmachine;

import static vendingmachine.Messages.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Products {

    //상품 목록 반환
    public List<Product> getProducts(String inputProducts) {
        List<Product> products = new ArrayList<>();
        for (String product : inputProducts.split(";")) {
            validateProduct(product);
            products.add(getProductElements(product));
        }
        return products;
    }

    //상품 목록 포맷 확인
    public void validateProduct(String product) {
        if (!product.matches("^\\[[가-힣a-zA-Z]+,+[0-9]+,+[0-9]+\\].*")) {
            throw new IllegalArgumentException(ERROR_INPUT_PRODUCTS);
        }
    }

    //상품 목록 요소 반환
    public Product getProductElements(String product) {
        String[] elements = product.replaceFirst("^.", "")
                .replaceFirst(".$", "")
                .split(",");
        return new Product(elements[0], Integer.parseInt(elements[1]), Integer.parseInt(elements[2]));
    }

    //상품 가격 예외 확인
    public void validateProductsPrice(List<Product> products) {
        for (Product product : products) {
            validateProductsMinimum(product);
            validateProductsUnit(product);
        }
    }

    //상품 가격 100원 이하 예외 처리
    public void validateProductsMinimum(Product product) {
        if (product.getProductPrice() < 100) {
            throw new IllegalArgumentException(ERROR_PRODUCT_PRICE_MINIMUM);
        }
    }

    //상품 가격 10원 단위 예외 처리
    public void validateProductsUnit(Product product) {
        if (product.getProductPrice() % 10 != 0) {
            throw new IllegalArgumentException(ERROR_PRODUCT_PRICE_UNIT);
        }
    }

    //상품 수량, 사용자 금액 계산
    public int calculate(List<Product> productList, int money, String productName) {
        for (Product product : productList) {
            if (product.getProductName().equals(productName)) {
                product = product.calculateProductCount(product);
                money = Coin.calculateMoney(money, product.getProductPrice());
            }
        }
        return money;
    }

    //상품 목록에 존재하지 않으면 예외 처리
    public void validateProductName(String productName, List<Product> productList) {
        if (productList.stream().noneMatch(product -> product.getProductName().equals(productName))) {
            throw new IllegalArgumentException(ERROR_PRODUCT_NAME);
        }
    }

    //상품 최저 가격 반환
    public int getMinimumPrice(List<Product> productList) {
        return productList.stream().min(Comparator.comparingInt(Product::getProductPrice)).get().getProductPrice();
    }

    //모든 상품 소진 확인
    public boolean hasCount(List<Product> productList, String productName) {
        return productList.stream().filter(product -> product.getProductName().equals(productName))
                .anyMatch(product -> product.getProductCount() > 0);
    }
}