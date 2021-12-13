package vendingmachine.controller;

import java.util.List;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;
import vendingmachine.utils.validator.HoldingAmountValidator;
import vendingmachine.utils.validator.InsertAmountValidator;
import vendingmachine.utils.validator.ProductInfoValidator;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {

    private final VendingMachine vendingMachine;

    public VendingMachineController() {
        this.vendingMachine = new VendingMachine();
    }

    public void execute() {
        initializeHoldingMoney();
        initializeProductsInfo();
        initializeInsertAmount();
        while (vendingMachine.isBuyAbleProductRemain()) {
            typeProductToBuy();
        }
        letReturnChange();
    }

    private void initializeHoldingMoney() {
        try {
            int validHoldingMoneyInput = HoldingAmountValidator.getValidHoldingAmount(InputView.inputHoldingAmount());
            vendingMachine.initializeCoinCase(validHoldingMoneyInput);
            OutputView.printHoldingCoinsInfoMessage();
            for (Coin coin : Coin.getCoinListDecreasingOrder()) {
                OutputView.printHoldingCoins(coin.toString(), vendingMachine.getNumberOfHoldingCoins(coin));
            }
            OutputView.printNewLine();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            initializeHoldingMoney();
        }
    }

    private void initializeProductsInfo() {
        try {
            List<Product> productList = ProductInfoValidator.getValidProductList(InputView.inputProductInfo());
            productList.forEach(vendingMachine::storeProduct);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            initializeProductsInfo();
        }
    }

    private void initializeInsertAmount() {
        try {
            int insertAmount = InsertAmountValidator.getValidInsertAmountValidator(InputView.inputInsertAmount());
            vendingMachine.insertMoney(insertAmount);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            initializeInsertAmount();
        }
    }

    private void typeProductToBuy() {
        OutputView.printInsertAmount(vendingMachine.getInsertAmount());
        try {
            String productNameToBuy = InputView.inputProductToBuy();
            ProductInfoValidator.validateName(productNameToBuy);
            ProductInfoValidator.validateProductNameDropped(productNameToBuy);
            Product targetProduct = vendingMachine.findProduct(productNameToBuy);
            vendingMachine.buyProduct(targetProduct);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            typeProductToBuy();
        }
    }

    private void letReturnChange() {
        OutputView.printInsertAmount(vendingMachine.getInsertAmount());
        OutputView.printChangeInfoMessage();
        for (Coin coin : Coin.getCoinListDecreasingOrder()) {
            returnCoin(coin, vendingMachine.getInsertAmount());
        }
    }

    private int returnCoin(final Coin coin, int remainInsertAmount) {
        int numberOfChangeCoins = 0;
        while (vendingMachine.getNumberOfHoldingCoins(coin) > 0 && remainInsertAmount >= coin.getAmount()) {
            remainInsertAmount -= coin.getAmount();
            vendingMachine.returnCoin(coin);
            numberOfChangeCoins++;
        }
        OutputView.printChangeCoins(coin.toString(), numberOfChangeCoins);
        return remainInsertAmount;
    }
}
