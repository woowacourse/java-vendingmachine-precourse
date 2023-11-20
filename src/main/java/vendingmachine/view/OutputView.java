package vendingmachine.view;

import static vendingmachine.Message.REQUEST_VENDING_MACHINE_HOLD_MONEY_MESSAGE;
import static vendingmachine.Message.RESULT_VENDING_MACHINE_HOLD_COINS_MESSAGE;
import static vendingmachine.domain.Coin.COIN_10;
import static vendingmachine.domain.Coin.COIN_100;
import static vendingmachine.domain.Coin.COIN_50;
import static vendingmachine.domain.Coin.COIN_500;

import vendingmachine.domain.VendingMachineDto;

public class OutputView {
    public static void printVendingMachineCoinsInputRequest() {
        System.out.print(REQUEST_VENDING_MACHINE_HOLD_MONEY_MESSAGE.getMessage());
    }

    public static void printVendingMachineCoins(VendingMachineDto dto) {
        System.out.printf(RESULT_VENDING_MACHINE_HOLD_COINS_MESSAGE.getMessage(),
                COIN_500.getAmount(), dto.quantity500(),
                COIN_100.getAmount(), dto.quantity100(),
                COIN_50.getAmount(), dto.quantity50(),
                COIN_10.getAmount(), dto.quantity10());
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }
}
