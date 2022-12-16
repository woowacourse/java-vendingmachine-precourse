package model;

import exception.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class VendingMachine {

    private final List<Product> products;

    private Money inputMoney;

    private Money change;


    public VendingMachine(String productGroup) {
        products = setProducts(productGroup);
    }

    public Money getInputMoney() {
        return inputMoney;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setInputMoney(Money inputMoney) {
        this.inputMoney = inputMoney;
    }

    public void setChange(Money change) {
        this.change = change;
    }

    /**
     * 잔돈 존재 여부 확인 기능
     */

    public boolean isChangeMore(){
        return inputMoney.getAmount() <= change.getAmount();
    }

    /**
     * 남은 금액이 상품의 최저 가격보다 적거나, 모든 상품이 소진된 경우 바로 잔돈을 돌려준다.
     */
    public boolean isPossibleUsing() {
        return inputMoney.getAmount() >= minimumPrice();
    }


    public boolean isRemaining() {
        return products.stream().mapToInt(p -> p.getPrice())
                .allMatch(p -> p == 0);
    }

    public int minimumPrice() {
        return products.stream()
                .mapToInt(p -> p.getPrice())
                .min()
                .getAsInt();
    }


    /**
     * 상품 구매
     */
    public void buyProduct(String name) {
        Product product = findProduct(name);
        if (isPossibleBuy(product)) {
            product.decreaseAmount();
            decreaseMoney(product);
        }
    }

    public Product findProduct(String name) {
        return products.stream()
                .filter(p -> p.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NON_PRESENT_PRODUCT_ERROR_MESSAGE.getMessage()));
    }

    public boolean isPossibleBuy(Product product) {
        return product.getPrice() <= this.inputMoney.getAmount();
    }

    public void decreaseMoney(Product product) {
        this.inputMoney.removeMoney(product.getPrice());
    }

    /**
     * new -> Product 처음 생성시
     */
    public List<Product> setProducts(String productGroup) {
        List<String> parsedGroup = parseProductGroup(productGroup);
        return parsedGroup.stream().map(Product::new).collect(Collectors.toList());
    }

    public List<String> parseProductGroup(String productGroup) {
        String[] split = productGroup.split(";");
        return Arrays.stream(split).collect(Collectors.toList());
    }

}
