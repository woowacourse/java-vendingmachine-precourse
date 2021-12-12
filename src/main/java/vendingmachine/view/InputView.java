package vendingmachine.view;

public class InputView {

    private static final String NEW_LINE = "\n";
    private static final String HOLDING_MONEY_INPUT_REQUEST_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String PRODUCT_INFO_INPUT_REQUEST_MESSAGE = "상품명과 가격, 수량을 입력해 주세요.";
    private static final String INSERT_AMOUNT_INPUT_REQUEST_MESSAGE = "투입 금액을 입력해 주세요.";

    public static String inputHoldingMoney() {
        System.out.println(HOLDING_MONEY_INPUT_REQUEST_MESSAGE);
        String inputHoldingMoney = camp.nextstep.edu.missionutils.Console.readLine();
        System.out.print(NEW_LINE);
        return inputHoldingMoney;
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
}
