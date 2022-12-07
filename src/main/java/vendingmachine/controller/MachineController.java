package vendingmachine.controller;

import vendingmachine.model.Budget;
import vendingmachine.model.MachineMoney;
import vendingmachine.model.MachineStatus;
import vendingmachine.model.Product;
import vendingmachine.model.Products;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class MachineController {
    private final InputView inputView;
    private final OutputView outputView;
    private MachineStatus machineStatus;

    public MachineController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        try {
            // 자판기가 보유하고 있는 금액 설정
            MachineMoney machineMoney = MachineMoney.from(inputView.readMachineMoney());
            outputView.printMachineMoney(machineMoney);

            // 자판기의 상품 설정
            Products products = Products.from(inputView.readProducts());

            // 투입 금액 및 구매 상품 입력
            Budget budget = Budget.from(inputView.readBudget());
            machineStatus = MachineStatus.AVAILABLE;

            while (machineStatus.isAvailable()) {

                outputView.printLeftMoney(budget);
                Product purchaseProduct = products.findProduct(inputView.readPurchaseProduct());

                if (!purchaseProduct.hasStock()) {
                    System.out.println("해당 상품의 재고가 존재하지 않습니다.");
                }
                if (!budget.isAffordable(purchaseProduct)) {
                    System.out.println("투입 금액이 모자랍니다.");
                }
                if (purchaseProduct.hasStock() && budget.isAffordable(purchaseProduct)) {
                    budget.buy(purchaseProduct);
                }
                if (budget.hasTooLittleBudget(products.findMinimumPrice())) {
                    machineStatus = MachineStatus.TOO_LITTLE_BUDGET;
                }
                if (products.hasNoProduct()) {
                    machineStatus = MachineStatus.NO_PRODUCT;
                }

            }

            // 잔돈 돌려주기



        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
        }
    }

}