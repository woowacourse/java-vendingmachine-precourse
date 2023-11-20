package vendingmachine.view;

import static vendingmachine.Message.BALANCE_MESSAGE;
import static vendingmachine.Message.CHANGES_AMOUNT;
import static vendingmachine.Message.CHANGES_MESSAGE;
import static vendingmachine.Message.REQUEST_BUYING_GOODS_INPUT_MESSAGE;
import static vendingmachine.Message.REQUEST_GOODS_INPUT_MESSAGE;
import static vendingmachine.Message.REQUEST_MONEY_INPUT_MESSAGE;
import static vendingmachine.Message.REQUEST_VENDING_MACHINE_HOLD_MONEY_INPUT_MESSAGE;
import static vendingmachine.Message.RESULT_VENDING_MACHINE_HOLD_COINS_MESSAGE;
import static vendingmachine.domain.Coin.COIN_10;
import static vendingmachine.domain.Coin.COIN_100;
import static vendingmachine.domain.Coin.COIN_50;
import static vendingmachine.domain.Coin.COIN_500;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import vendingmachine.domain.Coin;
import vendingmachine.domain.VendingMachineDto;

public class OutputView {
    public static void printVendingMachineCoinsInputRequest() {
        System.out.print(REQUEST_VENDING_MACHINE_HOLD_MONEY_INPUT_MESSAGE.getMessage());
    }

    public static void printVendingMachineCoins(VendingMachineDto dto) {
        System.out.printf(RESULT_VENDING_MACHINE_HOLD_COINS_MESSAGE.getMessage(),
                COIN_500.getAmount(), dto.quantity500(),
                COIN_100.getAmount(), dto.quantity100(),
                COIN_50.getAmount(), dto.quantity50(),
                COIN_10.getAmount(), dto.quantity10());
    }

    public static void printGoodsInputRequest() {
        System.out.print(REQUEST_GOODS_INPUT_MESSAGE.getMessage());
    }

    public static void printCustomerMoneyInputRequest() {
        System.out.print(REQUEST_MONEY_INPUT_MESSAGE.getMessage());
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }

    public static void printBalance(VendingMachineDto vendingMachineDto) {
        System.out.printf(BALANCE_MESSAGE.getMessage(), vendingMachineDto.customerMoney());
    }

    public static void printBuyingGoodsNameRequest() {
        System.out.print(REQUEST_BUYING_GOODS_INPUT_MESSAGE.getMessage());
    }

    public static void printChanges(LinkedHashMap<Coin, Integer> changes) {
        System.out.print(CHANGES_MESSAGE.getMessage());
        for (Entry<Coin, Integer> entry : changes.entrySet()) {
            System.out.printf(CHANGES_AMOUNT.getMessage(), entry.getKey().getAmount(), entry.getValue());
        }
    }
}
