package vendingmachine.controller;

import vendingmachine.domain.product.Product;
import vendingmachine.domain.coin.Coin;
import vendingmachine.domain.coin.CoinGenerator;
import vendingmachine.domain.product.Products;
import vendingmachine.domain.user.UserMoney;
import vendingmachine.domain.vendingMachine.Amount;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.Map;

public class VendingMachine {
    private Amount amount;
    private Products products = new Products();
    private UserMoney userMoney;
    public VendingMachine() {
    }

    private void setAmount() {
        amount = new Amount(Integer.parseInt(InputView.getVendingmachineAmount()));
    }

    private void setProduct() {
        String productForm = InputView.getProducts();
        String[] productInformations = productForm.split(";");
        for (String productInformation : productInformations) {
            String[] product = productInformation.replaceAll("[\\[\\]]", "").split(",");
            products.add(new Product(product[0], Integer.parseInt(product[1]), Integer.parseInt(product[2])));
        }
    }

    private void setUserMoney() {
        userMoney = new UserMoney(Integer.parseInt(InputView.getUserMoney()));
    }

    public void inputUserMoney() {
        setUserMoney();
        OutputView.printUserMoney(userMoney);
    }

    public void inputProducts() {
        setProduct();
        OutputView.printProducts(products);
    }

    public void inputAmount() {
        setAmount();
        CoinGenerator coinGenerator = new CoinGenerator();
        Map<Coin, Integer> coinCombination = coinGenerator.
                generate(amount.getAmount());
        OutputView.printCoinCount(coinCombination);
    }

    public void inputProductByUser() {
        String productByUser = InputView.getProductByUser();
        Product pro = products.reduce(productByUser);
        userMoney.reduce(pro.getPrice());
        OutputView.printUserMoney(userMoney);
    }

    public void returnChange() {
        if (!userMoney.canBuyCheapestProduct(products) || products.isSoldOut()) {
            System.out.println(getUserMoney());
        }
    }

    private int getUserMoney() {
        return userMoney.getMoney();
    }
}