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
import java.util.function.Supplier;
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
        Map<Coin, Integer> coins = retry(() -> coinMaker.make(input.readAmount()));
        output.showCoins(coins);
        return coins;
    }

    private List<Item> makeItems() {
        return retry(() -> makeItems(input.readItemInfos()));
    }

    private List<Item> makeItems(List<String[]> itemInfos) {
        return itemInfos.stream()
                .map(Item::from)
                .collect(Collectors.toList());
    }

    private Money makeMoney() {
        return retry(() -> new Money(input.readMoney()));
    }

    public <T> T retry(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                output.printError(e.getMessage());
            }
        }
    }
}
