package vendingmachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.repository.InputAmount;

public class Products {
    private final List<Product> products;

    public Products(String value) {
        products = new ArrayList<>();
        convertToProductsElement(value)
            .forEach(elements -> products.add(Product.of(elements[0], elements[1], elements[2])));
    }

    public List<String[]> convertToProductsElement(String value) {
        return Arrays.stream(value.split(";")).map(this::convertToProductElements).collect(Collectors.toList());
    }

    public String[] convertToProductElements(String value) {
        checkForm(value);
        String[] elements = value.replaceAll("[\\[\\]]","").split(",");
        checkElementCount(elements.length);
        return elements;
    }

    private void checkForm(String value) {
        if (value.charAt(0) != '[' || value.charAt(value.length() - 1) != ']') {
            throw new IllegalArgumentException("[ERROR] 한 상품의 내용은 '[' 으로 시작해서 ']' 로 끝나야 합니다.");
        }
    }

    private void checkElementCount(int count) {
        if (count != 3) {
            throw new IllegalArgumentException("[ERROR] 양식에 맞게 다시 입력주세요. 예) [콜라,1500,20];[사이다,1000,10]");
        }
    }

    public void reduce(String productName) {
        products.stream().filter(product -> product.isSameName(productName)).findFirst().get().reduce();
    }

    public int getPriceByName(String productName) {
        return products.stream().filter(product -> product.isSameName(productName)).findFirst().get().getPrice();
    }

    public boolean isValidAmount(InputAmount inputAmount) {
        return !isOutOfStock() && canBuy(inputAmount);
    }

    private boolean canBuy(InputAmount inputAmount) {
        return products.stream().anyMatch(product -> product.isLessThan(inputAmount));
    }

    private boolean isOutOfStock() {
        return products.stream().allMatch(Product::isOutOfStock);
    }

    public void checkIsValidName(String name) {
        products.stream()
            .filter(product -> product.isSameName(name))
            .findFirst().orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 상품입니다."));
    }
}
