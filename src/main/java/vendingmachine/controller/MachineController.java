package vendingmachine.controller;

import vendingmachine.model.Budget;
import vendingmachine.model.MachineMoney;
import vendingmachine.model.MachineStatus;
import vendingmachine.model.Machine;
import vendingmachine.model.Product;
import vendingmachine.model.Products;
import vendingmachine.util.ConsoleMessage;
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

        MachineMoney machineMoney = MachineMoney.from(inputView.readMachineMoney());
        outputView.printMachineMoney(machineMoney);

        Products products = Products.from(inputView.readProducts());

        Budget budget = Budget.from(inputView.readBudget());

        machine = Machine.by(machineMoney, products, budget);
        outputView.printLeftMoney(budget);

        while (machine.isAvailable()) {
            Product purchaseProduct = inputView.readPurchaseProduct(products);

            if (!purchaseProduct.hasStock()) {
                System.out.println(ConsoleMessage.NO_STOCK.getMessage());
            }
            if (!budget.isAffordable(purchaseProduct)) {
                System.out.println(ConsoleMessage.NO_BUDGET.getMessage());
            }
            if (purchaseProduct.hasStock() && budget.isAffordable(purchaseProduct)) {
                budget.buy(purchaseProduct);
                products.buy(purchaseProduct);
            }

            if (budget.hasTooLittleBudget(products.findMinimumPrice())) {
                updateMachineStatus(MachineStatus.TOO_LITTLE_BUDGET);
            }
            if (products.hasNoProduct()) {
                updateMachineStatus(MachineStatus.NO_PRODUCT);
            }

            outputView.printLeftMoney(budget);


        }

        // 잔돈 돌려주기
        outputView.printFinalLeftMoney(machineMoney.getLeftMoney(budget.getLeftMoney()));


    }

    private void updateMachineStatus(MachineStatus machineStatus) {
        this.machine.updateMachineStatus(machineStatus);
    }

}