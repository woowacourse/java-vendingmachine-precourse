package vendingmachine.controller;

import vendingmachine.model.Item.Items;
import vendingmachine.model.buy.BuyItemName;
import vendingmachine.model.money.Money;
import vendingmachine.model.money.MoneyCoins;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {

    private Money money;
    private Items items;

    public void start() {
        setupVendingMachine();
        sellItems();
        giveChange();
    }

    private void setupVendingMachine() {
        setupMoney();
        OutputView.showCoins(money.showCoins());
        setupItems();
        setupInputMoney();
    }

    private void setupMoney() {
        try {
            this.money = new Money(Integer.parseInt(InputView.getInitialMoney()));
            money.generateRandomCoins();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setupMoney();
        }
    }

    private void setupItems() {
        this.items = InputView.getInitialItems();
    }

    private void setupInputMoney() {
        money.addMoneyBill(InputView.getInputMoney());
    }

    private void giveChange() {
        MoneyCoins changeResult = money.giveChange();
        OutputView.showChange(changeResult);
    }

    private void sellItems() {
        OutputView.showInputMoney(money);
        if (noMoneyOrItem()) {
            return;
        }
        BuyItemName buyItemName = InputView.getBuyItemName();
        keepSelling(buyItemName);
    }

    private void keepSelling(BuyItemName buyItemName) {
        while (items.isSellable(buyItemName, money)) {
            items.sell(buyItemName, money);
            OutputView.showInputMoney(money);
            if (noMoneyOrItem()) {
                return;
            }
            buyItemName = InputView.getBuyItemName();
        }
    }

    private boolean noMoneyOrItem() {
        if (!items.isLeft() || money.isLowerThanAnyItem(items.getMinPriceAsAmount())) {
            return true;
        }
        return false;
    }
}
