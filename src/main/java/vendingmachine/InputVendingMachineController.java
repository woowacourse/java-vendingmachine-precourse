package vendingmachine;

import java.util.List;

import vendingmachine.domain.Product;
import vendingmachine.system.message.SystemErrorMessage;
import vendingmachine.system.message.SystemInputMessage;
import vendingmachine.system.validation.Validation;
import vendingmachine.system.validation.ValidationImplementation;
import vendingmachine.util.InputParsingUtility;

import camp.nextstep.edu.missionutils.Console;

public class InputVendingMachineController {

    private final Validation validation;
    private final OutPutVendingMachineController outputController;
    private final InputParsingUtility inputParsingUtility;

    private InputVendingMachineController() {
        this.validation = ValidationImplementation.getInstance();
        this.outputController = OutPutVendingMachineController.getInstance();
        this.inputParsingUtility = InputParsingUtility.getInstance();
    }

    private static class LazyHolder {
        public static final InputVendingMachineController INSTANCE = new InputVendingMachineController();
    }

    public static InputVendingMachineController getInstance() {
        return InputVendingMachineController.LazyHolder.INSTANCE;
    }

    public int inputHoldingMoney() {
        boolean isValidInput = false;
        String holdingMoney = "";
        do {
            try {
                outputController.printConsoleMessage(SystemInputMessage.INPUT_HOLDING_MONEY_MESSAGE.getMessage());
                holdingMoney = Console.readLine();
                isValidInput = validation.isValidHoldingMoney(holdingMoney);
            } catch (IllegalArgumentException e) {
                outputController.printConsoleMessage(SystemErrorMessage.ERROR_INPUT_HOLDING_MONEY_MESSAGE.getMessage());
                isValidInput = false;
            }
        } while (!isValidInput);
        return Integer.parseInt(holdingMoney);
    }

    public List<Product> inputProductNameAndPriceAndStock() {
        boolean isValidInput = false;
        String productNameAndPriceAndStocks = "";
        do {
            try {
                outputController.printConsoleMessage(SystemInputMessage.INPUT_PRODUCT_PRICE_STOCK_MESSAGE.getMessage());
                productNameAndPriceAndStocks = Console.readLine();
                isValidInput = validation.isValidProductNameAndPriceAndStock(productNameAndPriceAndStocks);
            } catch (IllegalArgumentException e) {
                outputController.printConsoleMessage(SystemErrorMessage.ERROR_PRODUCT_PRICE_STOCK_MESSAGE.getMessage());
                isValidInput = false;
            }
        } while (!isValidInput);
        return inputParsingUtility.toProductFormatting(productNameAndPriceAndStocks);
    }

    public int inputCustomerInsertMoney() {
        boolean isValidInput = false;
        int userInputMoney = 0;
        do {
            try {
                outputController.printConsoleMessage(SystemInputMessage.INPUT_USER_INSERT_MONEY_MESSAGE.getMessage());
                String userInsertMoney = Console.readLine();
                isValidInput = validation.isValidUserInsertMoney(userInsertMoney);
                userInputMoney = Integer.parseInt(userInsertMoney);
            } catch (IllegalArgumentException e) {
                outputController.printConsoleMessage(SystemErrorMessage.ERROR_USER_INSERT_MONEY_MESSAGE.getMessage());
                isValidInput = false;
            }
        } while (!isValidInput);
        return userInputMoney;
    }

    public String inputProductNameToBuy() {
        boolean isValidInput = false;
        String productNameToBuy = "";
        do {
            try {
                outputController.printConsoleMessage(SystemInputMessage.INPUT_PRODUCT_NAME_TO_BUY_MESSAGE.getMessage());
                productNameToBuy = Console.readLine();
                isValidInput = validation.isValidProductNameToBuy(productNameToBuy);
            } catch (IllegalArgumentException e) {
                outputController.printConsoleMessage(SystemErrorMessage.ERROR_PRODUCT_NAME_TO_BUY_MESSAGE.getMessage());
                isValidInput = false;
            }
        } while (!isValidInput);
        return productNameToBuy;
    }

}
