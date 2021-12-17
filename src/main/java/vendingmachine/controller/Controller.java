package vendingmachine.controller;

import java.util.HashMap;
import java.util.Map;

import static vendingmachine.util.Constants.*;
import vendingmachine.util.InputValidator;
import vendingmachine.model.Coin;
import vendingmachine.model.Machine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Controller {
    Machine machine;
    InputValidator inputValidator;

    public Controller() {
        this.machine = new Machine();
        this.inputValidator = new InputValidator();
    }

    public void run() {
        enterMachineMoney();
        generateMachineCoins();
        printMachineCoins();
        enterMachineMenus();
        enterUserMoney();
        while (continuePurchase()) {
            purchaseMachineMenu();
        }
        printChangeCoins();
    }

    private void enterMachineMoney() {
        String userInput = InputView.enterMachineMoney();
        try {
            inputValidator.money(userInput);
            machine.setMachineMoney(Integer.parseInt(userInput));
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMsg(e);
            enterMachineMoney();
        }
    }

    private void generateMachineCoins() {
        machine.generateRandomCoins();
    }

    private void printMachineCoins() {
        Map<Coin, Integer> coins = machine.getCoins();
        Map<Integer, Integer> amountCounts = new HashMap<>();
        for (int amount : Coin.getAmountsList()) {
            amountCounts.put(amount, coins.get(Coin.pick(amount)));
        }
        OutputView.printMachineCoins(amountCounts);
    }

    private void enterMachineMenus() {
        String userInput = InputView.enterMachineMenus();
        try {
            inputValidator.menus(userInput);
            machine.setMenus(userInput);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMsg(e);
            enterMachineMenus();
        }
    }

    private void enterUserMoney() {
        String userInput = InputView.enterUserMoney();
        try {
            inputValidator.money(userInput);
            machine.setUserMoney(Integer.parseInt(userInput));
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMsg(e);
            enterUserMoney();
        }
    }

    private void purchaseMachineMenu() {
        OutputView.printCurrUserMoney(machine.getUserMoney());
        String userInput = InputView.enterUserPurchaseMenu();
        try {
            machine.purchaseMenu(userInput);
        } catch (Exception e) {
            OutputView.printErrorMsg(e);
            purchaseMachineMenu();
        }
    }

    private boolean continuePurchase() {
        return machine.getUserMoney() >= machine.getLowestPrice() && !machine.allZeroStocks();
    }

    private void printChangeCoins() {
        OutputView.printCurrUserMoney(machine.getUserMoney());
        OutputView.printChangeCoins(machine.changeCoins());
    }
}
