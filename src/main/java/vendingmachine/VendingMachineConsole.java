package vendingmachine;

import static vendingmachine.StringConstants.*;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.coin.Coins;
import vendingmachine.dto.request.CoinBalanceRequest;
import vendingmachine.dto.request.ItemPurchaseRequest;
import vendingmachine.dto.request.iteminventory.ItemsInventoryRequest;
import vendingmachine.dto.request.AvailableMoneyRequest;
import vendingmachine.dto.response.CoinsResponse;
import vendingmachine.dto.response.MoneyAvailableResponse;
import vendingmachine.dto.servicedto.ItemsInventoryInfo;

public class VendingMachineConsole {

    public int inputCoinBalance() {
        printCoinBalanceRequestMessage();
        int initialCoinBalance = 0;
        int coinBalance = initialCoinBalance;
        boolean isInputEntered = false;
        while (!isInputEntered) {
            try {
                coinBalance = new CoinBalanceRequest(input()).toCoinBalance();
                isInputEntered = true;
            } catch (IllegalArgumentException error) {
                printErrorMessage(error.getMessage());
            }
        }
        return coinBalance;
    }

    public void printCoinBalance(Coins coinBalance) {
        System.out.println();
        System.out.println(NOTICE_PHRASE_FOR_COIN_BALANCE);
        System.out.println(new CoinsResponse(coinBalance).convertCoinBalanceToPrint());
    }

    public ItemsInventoryInfo inputItemInventoryInfo() {
        printItemInventoryInfoRequestMessage();
        ItemsInventoryInfo itemInventoryInfo = new ItemsInventoryInfo();
        boolean isItemsInventoryInfoEntered = false;
        while (!isItemsInventoryInfoEntered) {
            try {
                itemInventoryInfo = new ItemsInventoryRequest(input()).toItemsInventoryInfo();
                isItemsInventoryInfoEntered = true;
            } catch (IllegalArgumentException error) {
                printErrorMessage(error.getMessage());
            }
        }
        return itemInventoryInfo;
    }

    public int inputAvailableMoney() {
        printAvailableMoneyRequestMessage();
        int initialAvailableMoney = 0;
        int availableMoney = initialAvailableMoney;
        boolean isAvailableMoneyEntered = false;
        while (!isAvailableMoneyEntered) {
            try {
                availableMoney = new AvailableMoneyRequest(input()).toAvailableMoney();
                isAvailableMoneyEntered = true;
            } catch (IllegalArgumentException error) {
                printErrorMessage(error.getMessage());
            }
        }
        return availableMoney;
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

    private void printItemInventoryInfoRequestMessage() {
        System.out.println();
        System.out.println(REQUEST_MESSAGE_ABOUT_ITEM_INVENTORY_INFO);
    }

    private void printAvailableMoneyRequestMessage() {
        System.out.println();
        System.out.println(REQUEST_MESSAGE_ABOUT_AVAILABLE_MONEY);
    }

    private String input() {
        return Console.readLine();
    }

}
