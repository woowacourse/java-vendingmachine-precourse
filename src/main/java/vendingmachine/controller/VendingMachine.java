package vendingmachine.controller;

import vendingmachine.domain.coin.CoinCombination;
import vendingmachine.domain.product.Product;
import vendingmachine.domain.coin.CoinGenerator;
import vendingmachine.domain.product.ProductService;
import vendingmachine.domain.product.Products;
import vendingmachine.domain.user.UserMoney;
import vendingmachine.domain.vendingMachine.VendingMachineAmount;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachine {
    private VendingMachineAmount vendingMachineAmount;

    private Products products;
    private UserMoney userMoney;
    public VendingMachine() {
    }

    public void run() {
        setVendingMachineAmount();
        OutputView.printCoinCount(vendingMachineAmount.getVendingMachineCoinCombination());
        setProduct();
        setUserMoney();
        OutputView.printUserMoney(userMoney);
        inputProductByUser();
        returnChange();
    }

    private void setVendingMachineAmount() {
        try {
            vendingMachineAmount = new VendingMachineAmount(InputView.getVendingMachineAmount());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            setVendingMachineAmount();
        }
    }

    private void setProduct() {
        try {
            products = ProductService.makeProducts(InputView.getProducts());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            setProduct();
        }
    }

    private void setUserMoney() {
        try {
            userMoney = new UserMoney(InputView.getUserMoney());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            setUserMoney();
        }
    }

    private void inputProductByUser() {
        while (!isReturnChange()) {
            String productByUser = InputView.getProductByUser();
            Product pro = products.reduce(productByUser);
            userMoney.reduce(pro.getPrice());
            OutputView.printUserMoney(userMoney);
        }
    }

    private void returnChange() {
        int totalChange = userMoney.reduceMoney();
        CoinCombination changeCoinCombination = CoinGenerator.calculatePossibleCoinCombination(totalChange);
        changeCoinCombination.print();
    }

    private boolean isReturnChange() {
        return userMoney.canNotBuyCheapestProduct(products) || products.isSoldOut();
    }
}