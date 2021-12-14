package vendingmachine.domain.vendingMachine;

import vendingmachine.domain.coin.Coin;
import vendingmachine.domain.coin.CoinCombination;
import vendingmachine.domain.coin.CoinGenerator;
import vendingmachine.domain.product.Product;
import vendingmachine.domain.product.Products;
import vendingmachine.domain.user.UserMoney;
import vendingmachine.validator.ProductValidator;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.Map;

public class VendingMachineCalculator {
    private UserMoney userMoney;

    public VendingMachineCalculator() {
    }

    public void run(Products products, VendingMachineAmount vendingMachineAmount) {
        setUserMoney();
        OutputView.printUserMoney(userMoney);

        inputProductByUser(products);
        returnChange(vendingMachineAmount);
    }

    private void setUserMoney() {
        try {
            userMoney = new UserMoney(InputView.getUserMoney());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            setUserMoney();
        }
    }

    private void inputProductByUser(Products products) {
        try {
            buyAgain(products);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            inputProductByUser(products);
        }
    }

    private void buyAgain(Products products) {
        while (!isReturnChange(products)) {
            String productByUser = InputView.getProductByUser();
            ProductValidator.checkProductContain(products, productByUser);
            ProductValidator.checkProductName(productByUser);
            Product pro = products.reduce(productByUser);
            userMoney.reduce(pro.getPrice());
            OutputView.printUserMoney(userMoney);
        }
    }

    private void returnChange(VendingMachineAmount vendingMachineAmount) {
        int totalChange = userMoney.reduceMoney();
        CoinCombination changeCoinCombination = CoinGenerator.calculateChangeCoinCombination(vendingMachineAmount.getVendingMachineCoinCombination(), totalChange);
        changeCoinCombination.print2();
    }

    private boolean isReturnChange(Products products) {
        return userMoney.canNotBuyCheapestProduct(products) || products.isSoldOut();
    }
}
