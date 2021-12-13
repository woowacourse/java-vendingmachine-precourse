package vendingmachine.controller;

import vendingmachine.domain.product.Product;
import vendingmachine.domain.coin.Coin;
import vendingmachine.domain.coin.CoinGenerator;
import vendingmachine.domain.product.Products;
import vendingmachine.domain.user.UserMoney;
import vendingmachine.domain.vendingMachine.Amount;
import vendingmachine.view.InputView;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class VendingMachine {
    private Amount amount;
    private Products products = new Products();
    private UserMoney userMoney;
    public VendingMachine() {
    }

    private void setAmount() {
        amount = new Amount(Integer.parseInt(InputView.getUserInput()));
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
        userMoney = new UserMoney(Integer.parseInt(InputView.getUserInput()));
    }

    public void printUserMoney() {
        System.out.println("투입금액 = " + userMoney.getMoney() + " 원");
    }

    public void inputUserMoney() {
        System.out.println("투입 금액을 입력해 주세요.");
        setUserMoney();
        printUserMoney();
    }

    public void inputProducts() {
        System.out.println("상품명과 가격, 수량을 입력해 주세요.");
        setProduct();
        products.print();
    }

    public void inputAmount() {
        System.out.println("금액을 입력하시오");
        setAmount();
        CoinGenerator coinGenerator = new CoinGenerator();
        List<Integer> coinCombination = coinGenerator.generate(amount.getAmount());
        AtomicInteger index = new AtomicInteger();
        Coin.stream()
            .forEach(coin -> {
                System.out.println(coin.toString() + " - " + coinCombination.get(index.get()) + "개");
                index.addAndGet(1);
            });
    }
}