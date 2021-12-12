package vendingmachine.controller;


import vendingmachine.model.Item.Items;
import vendingmachine.model.buy.BuyItemName;
import vendingmachine.model.money.Money;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {

    private Money money;
    private Items items;

    public void start() {
        setupVendingMachine();
        OutputView.showCoins(money.showCoins());
        setupItems();
        System.out.println("test" + money.toString());
        setupInputMoney();
        System.out.println("test2" + money.toString());
        OutputView.showInputMoney(money);
        sellItems();
        OutputView.showChange(money);
    }

    private void setupVendingMachine() {
        this.money = InputView.getInitialAsset();
        money.generateRandomCoins();
    }

    private void setupItems() {
        this.items = InputView.getInitialItems();
    }

    private void setupInputMoney() {
        money.addMoneyBill(InputView.getInputMoney());
    }

    private void sellItems() {
        BuyItemName buyItemName = InputView.getBuyItemName();
        while (items.isSellable(buyItemName, money)) {
            items.sell(buyItemName, money);
            System.out.println(money.toString());
            buyItemName = InputView.getBuyItemName();
        }
    }
}
