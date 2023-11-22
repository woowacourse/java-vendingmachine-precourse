package vendingmachine.view;

import static vendingmachine.constants.Message.ASK_BUY_PRODUCT_NAME;
import static vendingmachine.constants.Message.ASK_INPUT_AMOUNT;
import static vendingmachine.constants.Message.ASK_MACHINE_OWN;
import static vendingmachine.constants.Message.ASK_PRODUCT_INFO;
import static vendingmachine.constants.Message.CHANGE_STATUS_HEADER;
import static vendingmachine.constants.Message.EACH_COIN;
import static vendingmachine.constants.Message.MONEY_STATUS;

import vendingmachine.dto.ChangeDTO;

public class OutputView {
    public static void printError(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printAskProductName() {
        System.out.println(ASK_BUY_PRODUCT_NAME.getMessage());
    }

    public void printCurrentAmount(int currentAmount) {
        System.out.printf(MONEY_STATUS.getMessage(), currentAmount);
        System.out.println();
    }

    public void printAskInputAmount() {
        System.out.println(ASK_INPUT_AMOUNT.getMessage());
    }

    public void printAskStockInfo() {
        System.out.println(ASK_PRODUCT_INFO.getMessage());
    }

    public void printAskMachineMoney() {
        System.out.println(ASK_MACHINE_OWN.getMessage());
    }

    public void printCoinStatus(ChangeDTO changeDTO) {
        StringBuilder stringBuilder = new StringBuilder(String.format(CHANGE_STATUS_HEADER.getMessage()));

        changeDTO.changeStatus().entrySet()
                .stream()
                .filter(entry -> entry.getValue() != 0)
                .forEach(entry -> {
                    stringBuilder.append(
                            String.format(EACH_COIN.getMessage(), entry.getKey().getValue(), entry.getValue()));
                });
        System.out.println(stringBuilder.toString());
    }
}
