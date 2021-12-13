package vendingmachine.controller;

import static vendingmachine.constants.SystemConstants.*;

import vendingmachine.domain.Merchandise;
import vendingmachine.domain.enums.Coin;
import vendingmachine.service.CoinService;
import vendingmachine.service.CustomerMoneyService;
import vendingmachine.service.MenuService;
import vendingmachine.view.OutputView;

import java.util.HashMap;

public class VendingMachineController {

    private final CoinService coinService = new CoinService();
    private final MenuService menuService = new MenuService();
    private final CustomerMoneyService customerMoneyService = new CustomerMoneyService();

    public VendingMachineController() {
        coinService.initializeCoins();
        menuService.initializeMenu();
        customerMoneyService.initializeCustomerMoneyLeft();
    }

    public void run() {
        while (true) {
            int currentMoneyLeft = customerMoneyService.getCustomerMoneyLeft();
            OutputView.printMoneyLeft(currentMoneyLeft);

            if (!menuService.hasSellableMerchandise(currentMoneyLeft)) break;
            this.sellMerchandise();
        }

        OutputView.printCoinChanges(this.calculateCoinChanges());
    }

    public void sellMerchandise() {
        Merchandise merchandise = menuService.selectAvailableMerchandise();
        customerMoneyService.decreaseCustomerMoneyLeft(merchandise.getPrice());
        merchandise.decreaseNumber();
    }

    public HashMap<Coin, Integer> calculateCoinChanges() {
        HashMap<Coin, Integer> coinChanges = new HashMap<>();
        for (Coin coin : Coin.getCoinsDesc()) {
            if (coinService.getCoins().get(coin) == ZERO_COINS) continue;
            if (customerMoneyService.getCustomerMoneyLeft() < coin.getAmount()) continue;
            int coinNumber = this.calculateMaximumCoinNumber(coin);
            coinChanges.put(coin, coinNumber);
            coinService.getCoins().put(coin, coinService.getCoins().get(coin)-coinNumber);
            customerMoneyService.decreaseCustomerMoneyLeft(coin.getAmount() * coinNumber);
        }
        return coinChanges;
    }

    public int calculateMaximumCoinNumber(Coin coin) {
        int spentCoinNumber = customerMoneyService.getCustomerMoneyLeft()/coin.getAmount();
        if (spentCoinNumber > coinService.getCoins().get(coin)) {
            spentCoinNumber = coinService.getCoins().get(coin);
        }
        return spentCoinNumber;
    }
}
