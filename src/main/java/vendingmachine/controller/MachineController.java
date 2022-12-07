package vendingmachine.controller;

import vendingmachine.model.Budget;
import vendingmachine.model.MachineMoney;
import vendingmachine.model.MachineStatus;
import vendingmachine.model.Machine;
import vendingmachine.model.Products;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class MachineController {
    private final InputView inputView;
    private final OutputView outputView;
    private Machine machine;

    public MachineController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        MachineMoney machineMoney = setMachineMoney();
        Products products = setProducts();
        Budget budget = setBudget();
        machine = Machine.by(machineMoney, products, budget);

        outputView.printLeftMoney(budget);
        purchaseProducts(products, budget);
        outputView.printFinalLeftMoney(machineMoney.getLeftMoney(budget.getLeftMoney()));
    }

    private Budget setBudget() {
        return Budget.from(inputView.readBudget());
    }

    private Products setProducts() {
        return Products.from(inputView.readProducts());
    }

    private MachineMoney setMachineMoney() {
        MachineMoney machineMoney = MachineMoney.from(inputView.readMachineMoney());
        outputView.printMachineMoney(machineMoney);
        return machineMoney;
    }

    private void purchaseProducts(Products products, Budget budget) {
        while (machine.isAvailable()) {
            machine.purchaseProduct(inputView.readPurchaseProduct(products));
            handleUnableToBuy();
            handleAbleToBuy();
            handleEndMachine(products, budget);
        }
    }

    private void handleUnableToBuy() {
        if (machine.isOutOfStock()) {
            outputView.printOutOfStock();
        }
        if (machine.isOutOfBudget()) {
            outputView.printOutOfBudget();
        }
    }

    private void handleAbleToBuy() {
        if (machine.isAbleToBuy()) {
            machine.purchase();
        }
    }

    private void handleEndMachine(Products products, Budget budget) {
        if (budget.hasTooLittleBudget(products.findMinimumPrice())) {
            updateMachineStatus(MachineStatus.TOO_LITTLE_BUDGET);
        }
        if (products.hasNoProduct()) {
            updateMachineStatus(MachineStatus.NO_PRODUCT);
        }
        outputView.printLeftMoney(budget);
    }


    private void updateMachineStatus(MachineStatus machineStatus) {
        this.machine.updateMachineStatus(machineStatus);
    }

}