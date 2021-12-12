package vendingmachine.controller;

import java.util.List;

import sun.tools.jconsole.OutputViewer;
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
            SystemMessageOutputView.printInsertAmount(vendingMachine.getInsertAmount());
            String productToBuy = InputView.inputProductToBuy();
        }
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
}
