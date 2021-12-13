package vendingmachine.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import vendingmachine.View.InputView;
import vendingmachine.View.OutputView;
import vendingmachine.model.Product;
import vendingmachine.model.VendingMachine;
import vendingmachine.utils.ExceptionMessages;
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
        int machineMoney = fillMoney();
        VendingMachine vendingMachine = new VendingMachine(machineMoney);

        Map<Integer, Integer> machineCoins = vendingMachine.getMachineCoins();
        outputView.printMachineHaveCoin(machineCoins);

        List<Product> products = displayProducts();
        int cheapestProductPrice = findCheapestProductPrice(products);
        int purchasingCost = inputView.inputPurchasingCost();

        purchasingCost = purchaseProducts(vendingMachine, products, cheapestProductPrice, purchasingCost);
        returnChange(vendingMachine, machineCoins, purchasingCost);
    }

    protected void returnChange(final VendingMachine vendingMachine, final Map<Integer, Integer> machineCoins, final int purchasingCost) {
        Map<Integer, Integer> returnCoins = vendingMachine.calculateReturnChangeCoin(machineCoins, purchasingCost);
        outputView.printReturnChange(purchasingCost, returnCoins);
    }

    protected int purchaseProducts(final VendingMachine vendingMachine, final List<Product> products, final int cheapestProductPrice, int purchasingCost) {
        do {
            outputView.printPurChasingCost(purchasingCost);

            String choosePurchasingProductName = choosePurchasingProduct(products, vendingMachine);
            purchasingCost = vendingMachine.sellProduct(products, choosePurchasingProductName, purchasingCost);
        } while (vendingMachine.isContinuePurchasing(products, cheapestProductPrice, purchasingCost));

        return purchasingCost;
    }

    protected int findCheapestProductPrice(final List<Product> products) {
        int cheapestProductPrice = products.get(0).getProductPrice();

        for (Product product : products) {
            if (product.getPrice().isCheaper(cheapestProductPrice)) {
                cheapestProductPrice = product.getProductPrice();
            }
        }

        return cheapestProductPrice;
    }

    protected String choosePurchasingProduct(final List<Product> products, VendingMachine vendingMachine) {
        try {
            String purchasingProductName = inputView.inputPurchasingProductName(Messages.INPUT_PURCHASING_PRODUCT_NAME.getInputMessage());
            vendingMachine.validatePurchasingProductNameOnMachine(products, purchasingProductName);
            vendingMachine.validatePurchasingProductSoldOut(products, purchasingProductName);

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

        validateDuplicateProduct(productList);

        return productList;
    }

    protected void validateDuplicateProduct(final List<Product> productList) {
        final List<String> productNames = new ArrayList<>();
        for (Product product : productList) {
            productNames.add(product.getProductName());
        }

        final Set<String> noDuplicateProductName = new HashSet<>(productNames);
        if (productNames.size() != noDuplicateProductName.size()) {
            throw new IllegalArgumentException(ExceptionMessages.ERROR_MESSAGE_PRODUCT_NAME_DUPLICATE.getErrorMessage());
        }
    }

    protected Product createProduct(final List<String> productInformation) {
        String name = productInformation.get(PRODUCT_INFORMATION_NAME_INDEX);
        int price = Integer.parseInt(productInformation.get(PRODUCT_INFORMATION_PRICE_INDEX));
        int count = Integer.parseInt(productInformation.get(PRODUCT_INFORMATION_COUNT_INDEX));

        return new Product(name, price, count);
    }

    protected int fillMoney() {
        try {
            int inputMoney = inputView.inputMoney(Messages.INPUT_MACHINE_HAVE_MONEY_MESSAGE.getInputMessage());
            isOverZero(inputMoney);

            return inputMoney;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());

            return fillMoney();
        }
    }

    protected void isOverZero(final int inputMoney) {
        if(inputMoney == 0){
            throw new IllegalArgumentException(ExceptionMessages.ERROR_MESSAGE_INPUT_MONEY_LESS_THAN_ZERO.getErrorMessage());
        }
    }

}
