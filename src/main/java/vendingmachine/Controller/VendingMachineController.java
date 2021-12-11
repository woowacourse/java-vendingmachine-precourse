package vendingmachine.Controller;

import java.util.Arrays;
import java.util.List;

import vendingmachine.View.InputView;
import vendingmachine.View.OutputView;
import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;
import vendingmachine.service.VendingMachineService;
import vendingmachine.utils.Messages;
import vendingmachine.utils.Symbol;

public class VendingMachineController {

    private final InputView inputView;
    private final OutputView outputView;
    private VendingMachineService vendingMachineService;

    public VendingMachineController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        vendingMachineService = new VendingMachineService();

        String fillMachineMoney = fillMachineMoney();
        VendingMachine vendingMachine = new VendingMachine(fillMachineMoney);

        List<Integer> coins = vendingMachine.createCoinList();
        List<Integer> machineCoins = vendingMachine.calculateCoins(fillMachineMoney, coins);

        final String machineCoinPrintFormat = createMachineCoinPrintFormat(machineCoins, coins);
        outputView.printMachineHaveCoin(machineCoinPrintFormat);

        List<Product> products = fillProducts();

        outputView.printNewLine();
        int purchasingCost = inputPurchasingCost();

        outputView.printNewLine();
        outputView.printPurChasingCost(purchasingCost);

        inputView.inputPurchasingProductName();
    }

    protected String fillMachineMoney() {
        try {
            String inputMachineMoney = inputView.inputMoney(Messages.INPUT_MACHINE_HAVE_MONEY_MESSAGE.getInputMessage());
            vendingMachineService.validateMachineMoney(inputMachineMoney);

            return inputMachineMoney;
        } catch (IllegalArgumentException illegalArgumentException) {
            outputView.printErrorMessage(illegalArgumentException);

            return fillMachineMoney();
        }
    }

    protected List<Product> fillProducts() {
        try {
            String inputProducts = inputView.inputProducts();
            vendingMachineService.isFollowingProductsFormat(Arrays.asList(vendingMachineService.splitInputProducts(inputProducts)));

            String noSquareBracketsProducts = vendingMachineService.deleteSquareBrackets(inputProducts);
            List<String> inputProductList = Arrays.asList(vendingMachineService.splitInputProducts(noSquareBracketsProducts));

            return vendingMachineService.addProduct(inputProductList);
        } catch (IllegalArgumentException illegalArgumentException) {
            outputView.printErrorMessage(illegalArgumentException);

            return fillProducts();
        }
    }

    public String createMachineCoinPrintFormat(final List<Integer> machineCoins, final List<Integer> coins) {
        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < machineCoins.size(); i++) {
            stringBuilder.append(coins.get(i))
                    .append(Symbol.WON.getSymbol())
                    .append(Symbol.SPACE.getSymbol())
                    .append(Symbol.DASH.getSymbol())
                    .append(Symbol.SPACE.getSymbol())
                    .append(machineCoins.get(i))
                    .append(Symbol.EA.getSymbol())
                    .append(Symbol.NEW_LINE.getSymbol());
        }

        return stringBuilder.toString();
    }

    protected int inputPurchasingCost() {
        try {
            String inputPurchasingCost = inputView.inputMoney(Messages.INPUT_USED_PURCHASING_MONEY_MESSAGE.getInputMessage());
            vendingMachineService.validateInputPurchasingCost(inputPurchasingCost);

            return Integer.parseInt(inputPurchasingCost);
        } catch (IllegalArgumentException illegalArgumentException) {
            outputView.printErrorMessage(illegalArgumentException);

            return inputPurchasingCost();
        }
    }

}
