package vendingmachine.view.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

import vendingmachine.dto.InputItemDTO;

public class ConsoleInputView implements InputView {
    private static final String VENDING_MACHINE_INPUT_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String ITEMS_INPUT_MESSAGE = "상품명과 가격, 수량을 입력해 주세요.";
    private static final String CUSTOMER_MONEY_INPUT_MESSAGE = "투입 금액을 입력해 주세요.";
    private static final String WANTED_ITEM_NAME_INPUT_MESSAGE = "구매할 상품명을 입력해 주세요.";

    private static final String ERROR_SYMBOL = "[ERROR] ";

    @Override
    public String inputVendingMachineMoney() {
        System.out.println(VENDING_MACHINE_INPUT_MESSAGE);
        return readLine();
    }

    @Override
    public String inputCustomerMoney() {
        System.out.println(CUSTOMER_MONEY_INPUT_MESSAGE);
        return readLine();
    }

    @Override
    public String inputWantedItemName() {
        System.out.println(WANTED_ITEM_NAME_INPUT_MESSAGE);
        return readLine();
    }

    @Override
    public void showErrorMessage(final String errorMessage) {
        System.out.println(ERROR_SYMBOL + errorMessage);
    }

    @Override
    public List<InputItemDTO> inputItemInfos() {
        System.out.println(ITEMS_INPUT_MESSAGE);
        String userInput = readLine();
        InputItemInfos inputItemInfos = new InputItemInfos();
        return inputItemInfos.generateInputItemDTOs(userInput);
    }
}
