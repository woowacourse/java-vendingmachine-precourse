package vendingmachine.controller;

import static vendingmachine.view.InputView.*;

import vendingmachine.model.Item.Items;
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
}
