package vendingmachine.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import vendingmachine.View.InputView;
import vendingmachine.View.OutputView;
import vendingmachine.model.Product;
import vendingmachine.model.VendingMachine;
import vendingmachine.utils.Messages;
import vendingmachine.utils.Symbol;

public class VendingMachineController {

    public static final int PRODUCT_INFORMATION_NAME_INDEX = 0;
    public static final int PRODUCT_INFORMATION_PRICE_INDEX = 1;
    public static final int PRODUCT_INFORMATION_COUNT_INDEX = 2;

    private final InputView inputView;
    private final OutputView outputView;

    public VendingMachineController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        VendingMachine vendingMachine = fillMoney();
        List<Product> products = displayProducts();
        int cheapestProductPrice = findCheapestProductPrice(products);

        int purchasingCost = inputView.inputPurchasingCost();

        while (!vendingMachine.isContinueDeal(products, cheapestProductPrice, purchasingCost)) {
            outputView.printPurChasingCost(purchasingCost);

            String choosePurchasingProductName = choosePurchasingProduct(products, vendingMachine);
            purchasingCost = vendingMachine.calculateRemainingPurchasingCost(products, choosePurchasingProductName, purchasingCost);
        }

    }

    protected int findCheapestProductPrice(final List<Product> products) {
        int cheapestProductPrice = products.get(0).getProductPrice();

        for (Product product : products) {
            if (product.isCheaper(cheapestProductPrice)) {
                cheapestProductPrice = product.getProductPrice();
            }
        }

        return cheapestProductPrice;
    }

    protected String choosePurchasingProduct(final List<Product> products, VendingMachine vendingMachine) {
        try {
            String purchasingProductName = inputView.inputPurchasingProductName(Messages.INPUT_PURCHASING_PRODUCT_NAME.getInputMessage());
            vendingMachine.validatePurchasingProductName(products, purchasingProductName);

            return purchasingProductName;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());

            return choosePurchasingProduct(products, vendingMachine);
        }
    }

    protected List<Product> displayProducts() {
        try {
            List<String> inputProductInformation = inputView.inputProducts(Messages.INPUT_PRODUCT_INFORMATION_MESSAGE.getInputMessage());

            return fillProducts(inputProductInformation);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());

            return displayProducts();
        }
    }

    protected List<Product> fillProducts(List<String> inputProductInformation) {
        final List<Product> productList = new ArrayList<>();

        for (String inputProduct : inputProductInformation) {
            String[] splitInputProduct = inputProduct.split(Symbol.COMMA.getSymbol());
            final List<String> productInformation = Arrays.asList(splitInputProduct);
            Product product = createProduct(productInformation);

            productList.add(product);
        }

        return productList;
    }

    protected Product createProduct(final List<String> productInformation) {
        String name = productInformation.get(PRODUCT_INFORMATION_NAME_INDEX);
        int price = Integer.parseInt(productInformation.get(PRODUCT_INFORMATION_PRICE_INDEX));
        int count = Integer.parseInt(productInformation.get(PRODUCT_INFORMATION_COUNT_INDEX));

        return new Product(name, price, count);
    }

    protected VendingMachine fillMoney() {
        try {
            int machineMoney = inputView.inputMoney(Messages.INPUT_MACHINE_HAVE_MONEY_MESSAGE.getInputMessage());
            VendingMachine vendingMachine = new VendingMachine(machineMoney);

            changeMachineMoneyIntoCoins(machineMoney, vendingMachine);

            return vendingMachine;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());

            return fillMoney();
        }
    }

    protected void changeMachineMoneyIntoCoins(final int machineMoney, final VendingMachine vendingMachine) {
        List<Integer> coinUnitList = vendingMachine.createCoinUnitList();
        List<Integer> machineCoins = vendingMachine.calculateCoins(machineMoney, coinUnitList);

        outputView.printMachineHaveCoin(machineCoins, coinUnitList);
    }

}
