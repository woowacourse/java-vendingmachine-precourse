package vendingmachine.service;

import vendingmachine.repository.Money;
import vendingmachine.repository.Product;
import vendingmachine.repository.Products;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class OrderService {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    OrderValidator orderValidator = new OrderValidator();
    Products products;
    Money money;

    public void get(Products products) {
        this.products = products;
        outputView.printOrderMoney();
        getUserMoney();
        getProduct();
        //남은 가능한 잔돈을 반환하고 손님을 보낸다.
        //printCoin();
    }

    public void getUserMoney() {
        while (true) {
            try {
                String tempMoney = inputView.getMoney();
                orderValidator.isValidMoney(tempMoney);
                money = new Money(Integer.parseInt(tempMoney));
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void getProduct() {
        while (true) {
            outputView.printInputMoney(money.getRemainder());
            Product userProduct = getOrderFromUser();
            subtract(userProduct, money);
            if (isEnd()) {
                return;
            }
        }
    }

    public boolean isEnd() {
        if (compareLowestAndRemainder()) {
            return true;
        }
        //남은 금액이 상품 최저가격보다 작거나
        //모든 상품이 소진된 경우
        return false;

    }

    public boolean compareLowestAndRemainder() {
        return products.getLowestPrice() > money.getRemainder();
    }

    public void subtract(Product userProduct, Money money) {
        userProduct.subtractStock();
        money.subtract(userProduct.getPrice());
    }

    public Product getOrderFromUser() {
        while (true) {
            outputView.printProduct();
            try {
                String userOrder = inputView.getOrder();
                isValidOrder(userOrder);
                return products.getProduct(userOrder);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean isValidOrder(String userOrder) {
        orderValidator.isExistProduct(userOrder, products);
        isPossiblePrice(userOrder);
        orderValidator.hasStock(userOrder, products);
        return true;
    }

    public boolean isPossiblePrice(String userOrder) {
        for (Product product : products.getProducts()) {
            if (product.getName().equals(userOrder)) {
                orderValidator.isPossiblePrice(product, money);
            }
        }
        return true;
    }

}