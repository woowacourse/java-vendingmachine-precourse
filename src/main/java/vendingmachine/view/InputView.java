package vendingmachine.view;

public class InputView {

    private static final String NEW_LINE = "\n";
    private static final String HOLDING_MONEY_INPUT_INIT_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";

    public static String inputHoldingMoney() {
        System.out.println(HOLDING_MONEY_INPUT_INIT_MESSAGE);
        String inputHoldingMoney = camp.nextstep.edu.missionutils.Console.readLine();
        System.out.print(NEW_LINE);
        return inputHoldingMoney;
    }
}
