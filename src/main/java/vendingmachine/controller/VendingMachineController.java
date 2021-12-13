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
        OutputView.showInputMoney(money);
    }

    private void setupMoney() {
        this.money = InputView.getInitialMoney();
        money.generateRandomCoins();
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
        if (noMoneyOrItem()) {
            return;
        }
        BuyItemName buyItemName = InputView.getBuyItemName();

        while (items.isSellable(buyItemName, money)) {
            items.sell(buyItemName, money);
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
