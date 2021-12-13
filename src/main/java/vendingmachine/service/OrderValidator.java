package vendingmachine.service;

import vendingmachine.repository.Money;
import vendingmachine.repository.Product;
import vendingmachine.repository.Products;

public class OrderValidator {

    public boolean isValidMoney(String money) {
        String numericRegex = "[0-9]+";
        return money.matches(numericRegex);
    }

    public boolean isExistProduct(String order, Products products) {
        if(!products.hasProduct(order)){
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 상품입니다.");
        }
        return true;
    }

    public boolean isPossiblePrice(Product product, Money money) {
        if (product.getPrice() > money.getRemainder()){
            throw new IllegalArgumentException("[ERROR] 잔돈보다 가격이 비싼 상품을 선택했습니다.");
        }
        return true;

    }

    public boolean hasStock(String order, Products products){
        Product product = products.getProduct(order);
        if (!(product.getStock() > 0)){
            throw new IllegalArgumentException("[ERROR] 재고가 없습니다.");
        }
        return true;
    }

}
