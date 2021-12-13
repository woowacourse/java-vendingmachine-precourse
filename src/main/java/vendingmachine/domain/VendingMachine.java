package vendingmachine.domain;

import vendingmachine.view.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class VendingMachine {
    private int amount;
    private List<Product> products = new ArrayList<>();
    private int userMoney;
    public VendingMachine() {
    }

    private void setAmount() {
        amount = Integer.parseInt(InputView.getUserInput());
    }

    private void setProduct() {
        String productForm = InputView.getUserInput();
        String[] productInformations = productForm.split(";");
        for (String productInformation : productInformations) {
            String[] product = productInformation.replaceAll("[\\[\\]]", "").split(",");
            products.add(new Product(product[0], Integer.parseInt(product[1]), Integer.parseInt(product[2])));
        }
    }

    private void setUserMoney() {
        userMoney = Integer.parseInt(InputView.getUserInput());
    }

    public void printUserMoney() {
        System.out.println("투입 금액을 입력해 주세요.");
        setUserMoney();
        System.out.println("투입금액 = " + userMoney + " 원");
    }

    public void printProduct() {
        System.out.println("상품명과 가격, 수량을 입력해 주세요.");
        setProduct();
        for (Product product : products) {
            product.print();
        }
    }

    public void print() {
        System.out.println("금액을 입력하시오");
        setAmount();
        CoinGenerator coinGenerator = new CoinGenerator();
        List<Integer> coinCombination = coinGenerator.generate(amount);
        AtomicInteger index = new AtomicInteger();
        Coin.stream()
            .forEach(coin -> {
                System.out.println(coin.toString() + " - " + coinCombination.get(index.get()) + "개");
                index.addAndGet(1);
            });
    }
}