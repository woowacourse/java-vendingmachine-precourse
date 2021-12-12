package vendingmachine.controller;

import static vendingmachine.view.InputView.*;

import vendingmachine.model.Item.Items;
import vendingmachine.model.Item.Name;
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
        setupInputMoney();
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
        if (items.isSellable(buyItemName, money)) {

        }
    }
}
