package vendingmachine.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.View.InputView;
import vendingmachine.View.OutputView;
import vendingmachine.domain.Product;
import vendingmachine.utils.ExceptionMessages;
import vendingmachine.utils.RegularExpressions;
import vendingmachine.utils.Symbol;

public class VendingMachineService {

    public static final int PRODUCT_INFORMATION_NAME_INDEX = 0;
    public static final int PRODUCT_INFORMATION_PRICE_INDEX = 1;
    public static final int PRODUCT_INFORMATION_COUNT_INDEX = 2;

    private final InputView inputView;
    private final OutputView outputView;

    public VendingMachineService(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public List<Product> createProductList() {
        try {
            inputView.printInputProductInformation();
            String inputProducts = inputValue();

            validateInputProducts(Arrays.asList(splitInputProducts(inputProducts)));
            List<String> inputProductList = Arrays.asList(splitInputProducts(deleteSquareBrackets(inputProducts)));

            return addProduct(inputProductList);
        } catch (IllegalArgumentException illegalArgumentException) {
            outputView.printErrorMessage(illegalArgumentException);

            return createProductList();
        }
    }

    protected void validateInputProducts(final List<String> inputProducts) {
        for (String inputProduct : inputProducts) {
            if (!isFollowingProductsInformationFormat(inputProduct)) {
                throw new IllegalArgumentException(ExceptionMessages.ERROR_MESSAGE_PRODUCT_INFORMATION_FORMAT.getErrorMessage());
            }
        }
    }

    private boolean isFollowingProductsInformationFormat(final String inputProducts) {
        return inputProducts.matches(RegularExpressions.INPUT_PRODUCT_INFORMATION_REGULAR_EXPRESSION.getRegularExpression());
    }

    protected String deleteSquareBrackets(final String inputProducts) {
        return inputProducts.replaceAll(Symbol.FRONT_SQUARE_BRACKET.getSymbol(), Symbol.BLANK.getSymbol())
                .replaceAll(Symbol.REAR_SQUARE_BRACKET.getSymbol(), Symbol.BLANK.getSymbol());
    }

    protected String[] splitInputProducts(final String inputProducts) {
        return inputProducts.split(Symbol.SEMI_COLON.getSymbol());
    }

    protected List<Product> addProduct(final List<String> inputProductList) {
        final List<Product> productList = new ArrayList<>();

        for (String inputProduct : inputProductList) {
            final List<String> productInformation = Arrays.asList(inputProduct.split(Symbol.COMMA.getSymbol()));
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

    public int inputMachineHaveMoney() {
        try {
            inputView.printInputMachineHaveMoney();
            String inputMachineHaveMoney = inputValue();
            validateMoney(inputMachineHaveMoney);

            return Integer.parseInt(inputMachineHaveMoney);
        } catch (IllegalArgumentException illegalArgumentException) {
            outputView.printErrorMessage(illegalArgumentException);

            return inputMachineHaveMoney();
        }
    }

    protected void validateMoney(final String inputMachineMoney) {
        if (!isNaturalNumber(inputMachineMoney)) {
            throw new IllegalArgumentException(ExceptionMessages.ERROR_MESSAGE_INPUT_MONEY_NUMBER.getErrorMessage());
        }
    }

    protected boolean isNaturalNumber(final String inputMachineMoney) {
        return inputMachineMoney.matches(RegularExpressions.INPUT_NUMBER_REGULAR_EXPRESSION.getRegularExpression());
    }

    public String inputValue() {
        return Console.readLine();
    }

}
