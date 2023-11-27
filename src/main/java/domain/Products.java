package domain;

import util.exception.DuplicateException;

import java.util.*;
import java.util.stream.Collectors;

import static domain.constant.ProductsConstant.*;
import static util.message.ExceptionMessage.*;

public class Products {
    private final List<Product> products;

    public Products(final String productsInfo){
        validateBlank(productsInfo);
        this.products = create(productsInfo);
        validateDuplicateProducts();
        validateDuplicateProductName();
    }

    public List<Product> getProducts() {
        return products;
    }

    private void validateBlank(final String productsInfo){
        if (productsInfo == null || productsInfo.trim().isEmpty()) {
            throw new IllegalArgumentException(String.format(BLANK_MESSAGE.getValue(), "상품정보"));
        }
    }

    private List<Product> create(final String productsInfo){
        String[] product = splitProducts(productsInfo);
        return Arrays.stream(product)
                .map(Product::create)
                .collect(Collectors.toList());
    }

    private String[] splitProducts(final String productsInfo) {
        String[] product = productsInfo.split(SPLIT_DELIMITER_SEMICOLON.getValue());
        for (int i = 0; i < product.length; i++) {
            product[i] = product[i].trim().replaceAll("\\[|\\]", BLANK.getValue());
        }
        return product;
    }

    private void validateDuplicateProducts() {
        int uniqueCarCount = new HashSet<>(products).size();
        if (products.size() != uniqueCarCount) {
            throw new DuplicateException(String.format(DUPLICATE_MESSAGE.getValue(), "상품정보"));
        }
    }

    private void validateDuplicateProductName(){
        Set<String> productNames = new HashSet<>();
        for (Product product : products) {
            String productName = product.getName().toString();
            if (!productNames.add(productName)) {
                throw new DuplicateException(String.format(DUPLICATE_MESSAGE.getValue(), "상품명"));
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products1 = (Products) o;
        return Objects.equals(products, products1.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("입력한 상품 정보").append('\n');
        for(Product product : products){
            sb.append(product.getName() + " " + product.getPrice() + " " + product.getQuantity()).append('\n');
        }
        return sb.toString();
    }


}

