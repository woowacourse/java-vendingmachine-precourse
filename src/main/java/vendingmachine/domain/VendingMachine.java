package vendingmachine.domain;

import vendingmachine.view.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class VendingMachine {
    private int amount;
    private List<Product> products = new ArrayList<>();
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

    public void printProduct() {
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


