package vendingmachine.utils;

import java.util.function.Supplier;
import vendingmachine.domain.HoldingAmount;
import vendingmachine.domain.InputAmount;
import vendingmachine.service.ProductService;
import vendingmachine.validator.InputValidator;
import vendingmachine.view.ErrorPrinter;

public class ConsoleInput {

    private static final String PROMPT_HOLDING_AMOUNT = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String PROMPT_PRODUCTS_INFO = "\n상품명과 가격, 수량을 입력해 주세요.";
    private static final String PROMPT_INPUT_AMOUNT = "\n투입 금액을 입력해 주세요.";
    private static final String PROMPT_ORDER_PRODUCT = "구매할 상품명을 입력해 주세요.";
    private final Supplier<String> lineSupplier;

    public ConsoleInput(Supplier<String> lineSupplier) {
        this.lineSupplier = lineSupplier;
    }

    public ProductService getProductSeller() {
        return iterateUntilValid(
            () -> new ProductService(ProductParser.parse(getInputWithPrompt(PROMPT_PRODUCTS_INFO)))
        );
    }

    public String getProductOrder() {
        return iterateUntilValid(() -> {
            String input = getInputWithPrompt(PROMPT_ORDER_PRODUCT);
            InputValidator.validateNonSpecialChar(input);
            return input;
        });
    }

    public InputAmount getValidInputAmount() {
        return iterateUntilValid(
            () -> new InputAmount(getValidNumberWithPrompt(PROMPT_INPUT_AMOUNT))
        );
    }

    public HoldingAmount getValidHoldingAmount() {
        return iterateUntilValid(
            () -> new HoldingAmount(getValidNumberWithPrompt(PROMPT_HOLDING_AMOUNT))
        );
    }

    private int getValidNumberWithPrompt(String prompt) {
        return iterateUntilValid(() -> {
            String input = getInputWithPrompt(prompt);
            InputValidator.validateNumeric(input);
            return Integer.parseInt(input);
        });
    }

    private String getInputWithPrompt(String prompt) {
        System.out.println(prompt);
        return lineSupplier.get();
    }

    /**
     * @param supplier 예외상황에서 IllegalArgumentException 을 던진다.
     * @param <T>      supplier 가 제공하는 객체
     * @return 예외가 발생하지 않을때까지 반복한다.
     */
    private <T> T iterateUntilValid(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            ErrorPrinter.printError(e);
            return iterateUntilValid(supplier);
        }
    }
}
