package vendingmachine.controller;

import java.util.List;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;
import vendingmachine.utils.validator.HoldingAmountValidator;
import vendingmachine.utils.validator.InsertAmountValidator;
import vendingmachine.utils.validator.ProductInfoValidator;
import vendingmachine.view.ErrorMessageOutputView;
import vendingmachine.view.InputView;
import vendingmachine.view.SystemMessageOutputView;

public class VendingMachineController {

    private final VendingMachine vendingMachine;

    public VendingMachineController(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public void execute() {
        initializeHoldingMoney();
        initializeProductsInfo();
        initializeInsertAmount();
        while (vendingMachine.isBuyAbleProductRemain()) {
            typeProductToBuy();
        }
        returnChange();
    }

    private void initializeHoldingMoney() {
        try {
            int validHoldingMoneyInput = HoldingAmountValidator.getValidHoldingAmount(InputView.inputHoldingAmount());
            vendingMachine.initializeCoinCase(validHoldingMoneyInput);
            SystemMessageOutputView.printHoldingCoins(vendingMachine.getHoldingCoins());
        } catch (IllegalArgumentException e) {
            ErrorMessageOutputView.printErrorMessage(e.getMessage());
            initializeHoldingMoney();
        }
    }

    private void initializeProductsInfo() {
        try {
            List<Product> productList = ProductInfoValidator.getValidProductList(InputView.inputProductInfo());
            productList.forEach(vendingMachine::storeProduct);
        } catch (IllegalArgumentException e) {
            ErrorMessageOutputView.printErrorMessage(e.getMessage());
            initializeProductsInfo();
        }
    }

    private void initializeInsertAmount() {
        try {
            int insertAmount = InsertAmountValidator.getValidInsertAmountValidator(InputView.inputInsertAmount());
            vendingMachine.insertMoney(insertAmount);
        } catch (IllegalArgumentException e) {
            ErrorMessageOutputView.printErrorMessage(e.getMessage());
            initializeInsertAmount();
        }
    }

    private void typeProductToBuy() {
        SystemMessageOutputView.printInsertAmount(vendingMachine.getInsertAmount());
        try {
            String productNameToBuy = InputView.inputProductToBuy();
            ProductInfoValidator.validateName(productNameToBuy);
            ProductInfoValidator.validateProductNameDropped(productNameToBuy);
            Product targetProduct = vendingMachine.findProduct(productNameToBuy);
            vendingMachine.buyProduct(targetProduct);
        } catch (IllegalArgumentException e) {
            ErrorMessageOutputView.printErrorMessage(e.getMessage());
            typeProductToBuy();
        }
    }

    private void returnChange() {
        SystemMessageOutputView.printInsertAmount(vendingMachine.getInsertAmount());
        SystemMessageOutputView.printChangeInfoMessage();
        int remainInsertAmount = vendingMachine.getInsertAmount();
        for (Coin coin : Coin.getCoinListDecreasingOrder()) {
            remainInsertAmount = returnChange(coin, remainInsertAmount);
        }
    }

    private int returnChange(final Coin coin, int remainInsertAmount) {
        int numberOfChangeCoins = 0;
        while (vendingMachine.getNumberOfHoldingCoins(coin) > 0 && remainInsertAmount >= coin.getAmount()) {
            remainInsertAmount -= coin.getAmount();
            vendingMachine.returnCoin(coin);
            numberOfChangeCoins++;
        }
        SystemMessageOutputView.printChangeCoins(coin, numberOfChangeCoins);
        return remainInsertAmount;
    }
}
