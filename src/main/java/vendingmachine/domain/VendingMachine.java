package vendingmachine.domain;

import static vendingmachine.constants.SystemConstants.*;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.enums.Coin;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.HashMap;

public class VendingMachine {

    private final HashMap<Coin, Integer> coins = new HashMap<>();
    private Menu menu;
    private int customerMoneyLeft = NO_CUSTOMER_MONEY_LEFT;

    public VendingMachine() {
        int totalMoney = InputView.getInitialMoneyInput();
        this.initializeCoins(totalMoney);
        OutputView.printCoinsInfo(this.coins);
        this.setMenu(InputView.getMenuInput());
        this.setCustomerMoneyLeft(InputView.getCustomerMoneyInput());
    }

    public void run() {
        while (true) {
            OutputView.printMoneyLeft(this.getCustomerMoneyLeft());

            if (!menu.hasSellableMerchandise(this.customerMoneyLeft)) break;
            this.sellMerchandise();
        }

        OutputView.printCoinChanges(this.calculateCoinChanges());
    }

    private void initializeCoins(int totalMoney) {
        for (Coin coin : Coin.values()) {
            this.coins.put(coin, ZERO_COINS);
        }
        generateCoins(totalMoney);
    }

    private void generateCoins(int totalMoney) {
        while (totalMoney > NO_TOTAL_MONEY_LEFT) {
            int randomCoinAmount = Randoms.pickNumberInList(Coin.getCoinsAmountDesc());
            if (totalMoney >= randomCoinAmount) {
                Coin newCoin = Coin.getCoinByAmount(randomCoinAmount);
                coins.put(newCoin, coins.get(newCoin) + 1);
                totalMoney -= randomCoinAmount;
            }
        }
    }

    private void setMenu(Menu menu) {
        this.menu = menu;
    }

    private int getCustomerMoneyLeft() {
        return this.customerMoneyLeft;
    }

    private void setCustomerMoneyLeft(int moneyInput) {
        this.customerMoneyLeft = moneyInput;
    }

    private void sellMerchandise() {
        Merchandise merchandise = menu.selectAvailableMerchandise();
        customerMoneyLeft -= merchandise.getPrice();
        merchandise.decreaseNumber();
    }

    private HashMap<Coin, Integer> calculateCoinChanges() {
        HashMap<Coin, Integer> coinChanges = new HashMap<>();
        for (Coin coin : Coin.getCoinsDesc()) {
            if (this.coins.get(coin) == ZERO_COINS) continue;
            if (this.customerMoneyLeft < coin.getAmount()) continue;
            int coinNumber = this.calculateMaximumCoinNumber(coin);
            coinChanges.put(coin, coinNumber);
            this.coins.put(coin, this.coins.get(coin)-coinNumber);
            this.customerMoneyLeft -= coin.getAmount() * coinNumber;
        }
        return coinChanges;
    }

    private int calculateMaximumCoinNumber(Coin coin) {
        int spentCoinNumber = this.customerMoneyLeft/coin.getAmount();
        if (spentCoinNumber > this.coins.get(coin)) {
            spentCoinNumber = this.coins.get(coin);
        }
        return spentCoinNumber;
    }
}
