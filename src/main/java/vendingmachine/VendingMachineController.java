package vendingmachine;

import java.util.EnumMap;
import java.util.List;
import vendingmachine.domain.VendingMachine;
import vendingmachine.domain.coin.Coin;
import vendingmachine.domain.coin.Coins;
import vendingmachine.domain.coin.generator.RandomCoinGenerator;
import vendingmachine.domain.menu.Menu;
import vendingmachine.domain.menu.Menus;
import vendingmachine.domain.money.Cash;
import vendingmachine.domain.money.Money;
import vendingmachine.exception.RetryHandler;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RetryHandler handler = new RetryHandler();

    public void run() {
        VendingMachine vendingMachine = initVendingMachine();
        purchase(vendingMachine);
    }

    private void purchase(VendingMachine vendingMachine) {

        Cash remainCash = handler.getOrRetry(this::insertCash);

        while (vendingMachine.canPurchase(remainCash)) {
            handler.runOrRetry(() -> {
                purchaseMenu(vendingMachine, remainCash);
            });
        }
        returnCoin(vendingMachine, remainCash.toMoney());
    }

    private Cash insertCash() {
        int money = inputView.insertMoney();
        return new Cash(money);
    }

    private void returnCoin(VendingMachine vendingMachine, Money money) {
        outputView.printRemainMoney(money.getPrice());
        EnumMap<Coin, Integer> returnCoin = vendingMachine.returnCoin(money);
        outputView.printReturnCoins(returnCoin);
    }

    private void purchaseMenu(VendingMachine vendingMachine, Cash remainCash) {
        outputView.printRemainMoney(remainCash.getPrice());
        String inputMenu = inputView.purchaseMenu();
        vendingMachine.purchase(inputMenu, remainCash);
    }

    private VendingMachine initVendingMachine() {
        Coins coins = handler.getOrRetry(this::makeCoins);
        Menus menus = handler.getOrRetry(this::makeMenus);
        return new VendingMachine(coins, menus);
    }

    private Coins makeCoins() {
        int initCoins = inputView.getMachineMoney();
        Coins coins = new Coins(initCoins, new RandomCoinGenerator());
        outputView.printMachineCoin(coins);
        return coins;
    }

    private Menus makeMenus() {
        List<String> inputMenus = inputView.getMenus();
        List<Menu> menus = inputMenus.stream()
                .map(Menu::from)
                .toList();
        return new Menus(menus);
    }
}
