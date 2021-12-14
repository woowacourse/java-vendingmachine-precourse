package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import vendingmachine.domain.Product;

public class InputView {

    private static final String INPUT_VENDING_MACHINE_OWN_MONEY_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";

    private static final String INPUT_PRODUCTS = "상품명과 가격, 수량을 입력해 주세요.";
    private static final String INPUT_PRODUCTS_DELIMITER = ";";
    private static final String INPUT_PRODUCT_DELIMIETER = ",";
    private static final int INPUT_PRODUCTS_LIMIT = -1;

    private static final String INPUT_MONEY = "투입 금액을 입력해 주세요.";

    private static final String INPUT_PURCHASE_PRODUCT = "구매할 상품명을 입력해 주세요.";

    private static final String INPUT_PRODUCT_START_FROMAT = "[";
    private static final String INPUT_PRODUCT_END_FROMAT = "]";
    private static final String INPUT_FORMAT_ERROR_MESSAGE = "[ERROR] 정해진 입력방식이 아닙니다.";
    private static final String INPUT_FORMAT_GUIDE_MESSAGE = "상품명, 가격, 수량은 쉼표로, 개별 상품은 대괄호([])로 묶어 세미콜론(;)으로 구분해주세요.";
    private static final String LINE_BREAK = "\n";

    private InputView() {
    }

    public static String inputVendinMachineOwnMoney() {
        System.out.println(INPUT_VENDING_MACHINE_OWN_MONEY_MESSAGE);
        return Console.readLine();
    }

    public static List<Product> calculateProductList() {
        System.out.println(INPUT_PRODUCTS);
        return inputProductValue().stream()
            .map(InputView::splitByDelimiterToList)
            .map(InputView::valueToProduct)
            .collect(Collectors.toList());
    }

    private static List<String> inputProductValue() {
        List<String> products = inputNamePriceAmounts();
        checkInputProductPattern(products);
        return products.stream()
            .map(product -> product.substring(1, product.length() - 1))
            .collect(Collectors.toList());
    }

    private static List<String> inputNamePriceAmounts() {
        return Arrays.stream(Console.readLine().split(INPUT_PRODUCTS_DELIMITER, INPUT_PRODUCTS_LIMIT))
            .collect(Collectors.toList());
    }

    private static void checkInputProductPattern(List<String> products) {
        if (isProductsPatternMismatches(products)) {
            throw new IllegalArgumentException(INPUT_FORMAT_ERROR_MESSAGE + LINE_BREAK + INPUT_FORMAT_GUIDE_MESSAGE);
        }
    }

    private static boolean isProductsPatternMismatches(List<String> products) {
        return products.stream()
            .anyMatch(InputView::isProductFormatMismatches);
    }

    private static boolean isProductFormatMismatches(String product) {
        return !product.startsWith(INPUT_PRODUCT_START_FROMAT) || !product.endsWith(INPUT_PRODUCT_END_FROMAT);
    }

    private static List<String> splitByDelimiterToList(String product) {
        return Arrays.asList(product.split(INPUT_PRODUCT_DELIMIETER));
    }

    private static Product valueToProduct(List<String> products) {
        return Product.crearteProduct(products);
    }

    public static String inputMoney() {
        System.out.println(INPUT_MONEY);
        return Console.readLine();
    }

    public static String inputPurChaseProductName() {
        System.out.println(INPUT_PURCHASE_PRODUCT);
        return Console.readLine();
    }
}
