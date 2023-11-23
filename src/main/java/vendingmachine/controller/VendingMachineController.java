package vendingmachine.controller;

import vendingmachine.domain.Coin;
import vendingmachine.domain.CoinMaker;
import vendingmachine.domain.Item;
import vendingmachine.domain.Money;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.Input;
import vendingmachine.view.Output;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VendingMachineController {

    private final Input input = new Input();
    private final Output output = new Output();
    private final CoinMaker coinMaker = new CoinMaker();

    public void run() {
        Map<Coin, Integer> coins = makeCoins();
        List<Item> items = makeItems();
        Money money = makeMoney();
        VendingMachine vendingMachine = new VendingMachine(coins, items, money);

        while (vendingMachine.canPurchase()) {
            output.showMoney(money);
            String itemName = input.readPurchaseItemName();
            vendingMachine.buyItem(itemName);
        }
        output.showMoney(money);
        output.showChanges(vendingMachine.returnChanges());
    }

    private Map<Coin, Integer> makeCoins() {
        try {
            Map<Coin, Integer> coins = coinMaker.make(input.readAmount());
            output.showCoins(coins);
            return coins;
        } catch (IllegalArgumentException e) {
            output.printError(e.getMessage());
            return makeCoins();
        }
    }

    private List<Item> makeItems() {
        try {
            return makeItems(input.readItemInfos());
        } catch (IllegalArgumentException e) {
            output.printError(e.getMessage());
            return makeItems();
        }
    }

    private List<Item> makeItems(List<String[]> itemInfos) {
        return itemInfos.stream()
                .map(Item::from)
                .collect(Collectors.toList());
    }

    private Money makeMoney() {
        try {
            return new Money(input.readMoney());
        } catch (IllegalArgumentException e) {
            output.printError(e.getMessage());
            return makeMoney();
        }
    }
}
