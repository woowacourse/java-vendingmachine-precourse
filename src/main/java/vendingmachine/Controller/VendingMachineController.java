package vendingmachine.Controller;

import java.util.List;

import vendingmachine.View.InputView;
import vendingmachine.View.OutputView;
import vendingmachine.domain.Product;
import vendingmachine.service.VendingMachineService;
import vendingmachine.utils.Coin;
import vendingmachine.utils.ExceptionMessages;
import vendingmachine.utils.RegularExpressions;

public class VendingMachineController {

    private final InputView inputView;
    private final OutputView outputView;
    private VendingMachineService vendingMachineService;

    public VendingMachineController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        vendingMachineService = new VendingMachineService(inputView, outputView);
        int machineHaveMoney = vendingMachineService.inputMachineHaveMoney();

//        outputView.printCoinCountMessage();
//        calculateCoins(machineHaveMoney);
        System.out.println(Coin.COIN_500);

        List<Product> productInformation = vendingMachineService.createProductList();
        int purchasingCost = inputPurchasingCost();

    }

    private int inputPurchasingCost() {
        try {
            inputView.printInputPurchasingCost();
            String inputPurchasingCost = vendingMachineService.inputValue();
            validateInputPurchasingCost(inputPurchasingCost);

            return Integer.parseInt(inputPurchasingCost);
        } catch (IllegalArgumentException illegalArgumentException) {
            outputView.printErrorMessage(illegalArgumentException);

            return inputPurchasingCost();
        }
    }

    protected void validateInputPurchasingCost(final String inputPurchasingCost) {
        if (!isNaturalNumber(inputPurchasingCost)) {
            throw new IllegalArgumentException(ExceptionMessages.ERROR_MESSAGE_INPUT_PURCHASING_COST.getErrorMessage());
        }
    }

    protected boolean isNaturalNumber(final String inputPurchasingCost) {
        return inputPurchasingCost.matches(RegularExpressions.INPUT_NUMBER_REGULAR_EXPRESSION.getRegularExpression());
    }

}
