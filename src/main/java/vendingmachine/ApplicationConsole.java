package vendingmachine;

import static vendingmachine.StringConstants.*;

import java.util.function.Supplier;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.coin.Coins;
import vendingmachine.dto.request.AvailableMoneyRequest;
import vendingmachine.dto.request.CoinBalanceRequest;
import vendingmachine.dto.request.ItemPurchaseRequest;
import vendingmachine.dto.request.iteminventory.ItemsInventoryRequest;
import vendingmachine.dto.response.CoinsResponse;
import vendingmachine.dto.response.MoneyAvailableResponse;
import vendingmachine.dto.servicedto.ItemsInventoryInfo;

public class ApplicationConsole {

    public int inputCoinBalance() {
        printCoinBalanceRequestMessage();
        return inputUntilSucceed(() -> new CoinBalanceRequest(input()).toCoinBalance());
    }

    public void printCoinBalance(Coins coinBalance) {
        System.out.println();
        System.out.println(NOTICE_PHRASE_FOR_COIN_BALANCE);
        System.out.println(new CoinsResponse(coinBalance).convertCoinBalanceToPrint());
    }

    public ItemsInventoryInfo inputItemInventoryInfo() {
        printItemInventoryInfoRequestMessage();
        return inputUntilSucceed(() -> new ItemsInventoryRequest(input()).toItemsInventoryInfo());
    }

    public int inputAvailableMoney() {
        printAvailableMoneyRequestMessage();
        return inputUntilSucceed(() -> new AvailableMoneyRequest(input()).toAvailableMoney());
    }

    public void printAvailableMoney(int moneyAvailable) {
        System.out.println(new MoneyAvailableResponse(moneyAvailable).toPrint());
    }

    public String inputItemsToPurchase() {
        System.out.println(REQUEST_MESSAGE_ABOUT_PURCHASING_ITEM);
        return new ItemPurchaseRequest(input()).toItemNameToPurchase();
    }

    public void printErrorMessage(String errorMessage) {
        System.out.print(PREFIX_OF_ERROR_MESSAGE);
        System.out.println(errorMessage);
    }

    public void printChange(Coins change) {
        System.out.println(NOTICE_PHRASE_FOR_CHANGE);
        System.out.println(new CoinsResponse(change).convertChangeToPrint());
    }

    private void printCoinBalanceRequestMessage() {
        System.out.println(REQUEST_MESSAGE_ABOUT_COIN_BALANCE);
    }

    private String input() {
        return Console.readLine();
    }

    private void printItemInventoryInfoRequestMessage() {
        System.out.println();
        System.out.println(REQUEST_MESSAGE_ABOUT_ITEM_INVENTORY_INFO);
    }

    private void printAvailableMoneyRequestMessage() {
        System.out.println();
        System.out.println(REQUEST_MESSAGE_ABOUT_AVAILABLE_MONEY);
    }

    private <T> T inputUntilSucceed(Supplier<T> input) {
        T inputValue = null;
        while (true) {
            try {
                inputValue = input.get();
                break;
            } catch (IllegalArgumentException error) {
                printErrorMessage(error.getMessage());
            }
        }
        return inputValue;
    }
}
