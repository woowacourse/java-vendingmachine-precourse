package vendingmachine.view;

public class InputView {

    private static final String NEW_LINE = "\n";
    private static final String HOLDING_AMOUNT_INPUT_REQUEST_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String PRODUCT_INFO_INPUT_REQUEST_MESSAGE = "상품명과 가격, 수량을 입력해 주세요.";
    private static final String INSERT_AMOUNT_INPUT_REQUEST_MESSAGE = "투입 금액을 입력해 주세요.";
    private static final String PRODUCT_TO_BUY_INPUT_REQUEST_MESSAGE = "구매할 상품명을 입력해 주세요.";

    public static String inputHoldingAmount() {
        System.out.println(HOLDING_AMOUNT_INPUT_REQUEST_MESSAGE);
        String inputHoldingAmount = camp.nextstep.edu.missionutils.Console.readLine();
        System.out.print(NEW_LINE);
        return inputHoldingAmount;
    }

    public static String inputProductInfo() {
        System.out.println(PRODUCT_INFO_INPUT_REQUEST_MESSAGE);
        String inputProductInfo = camp.nextstep.edu.missionutils.Console.readLine();
        System.out.print(NEW_LINE);
        return inputProductInfo;
    }

    public static String inputInsertAmount() {
        System.out.println(INSERT_AMOUNT_INPUT_REQUEST_MESSAGE);
        String inputInsertAmount = camp.nextstep.edu.missionutils.Console.readLine();
        System.out.print(NEW_LINE);
        return inputInsertAmount;
    }

    public static String inputProductToBuy() {
        System.out.println(PRODUCT_TO_BUY_INPUT_REQUEST_MESSAGE);
        String productToBuy = camp.nextstep.edu.missionutils.Console.readLine();
        System.out.print(NEW_LINE);
        return productToBuy;
    }
}
