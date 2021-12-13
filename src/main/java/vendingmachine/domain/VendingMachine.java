package vendingmachine.domain;

import static vendingmachine.constants.SystemConstants.*;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.enums.Coin;
import vendingmachine.service.CoinService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.HashMap;

public class VendingMachine {

    private final CoinService coinService = new CoinService();
    private Menu menu;
    private int customerMoneyLeft = NO_CUSTOMER_MONEY_LEFT;

    public VendingMachine() {
        coinService.initializeCoins(InputView.getInitialMoneyInput());
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
            if (this.coinService.getCoins().get(coin) == ZERO_COINS) continue;
            if (this.customerMoneyLeft < coin.getAmount()) continue;
            int coinNumber = this.calculateMaximumCoinNumber(coin);
            coinChanges.put(coin, coinNumber);
            this.coinService.getCoins().put(coin, this.coinService.getCoins().get(coin)-coinNumber);
            this.customerMoneyLeft -= coin.getAmount() * coinNumber;
        }
        return coinChanges;
    }

    private int calculateMaximumCoinNumber(Coin coin) {
        int spentCoinNumber = this.customerMoneyLeft/coin.getAmount();
        if (spentCoinNumber > this.coinService.getCoins().get(coin)) {
            spentCoinNumber = this.coinService.getCoins().get(coin);
        }
        return spentCoinNumber;
    }
}
