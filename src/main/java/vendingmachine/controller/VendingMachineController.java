package vendingmachine.controller;

import java.util.function.Function;

import vendingmachine.model.change.ChangeSystem;
import vendingmachine.model.change.coingenerator.CoinGenerator;
import vendingmachine.model.item.Items;
import vendingmachine.model.vo.Money;
import vendingmachine.view.input.InputView;
import vendingmachine.view.output.OutputView;

public class VendingMachineController {
    private final OutputView outputView;
    private final InputView inputView;

    private final Items items;
    private final Money remainingInputMoney;
    private final ChangeSystem changeSystem;


    public VendingMachineController(final InputView inputView, final OutputView outputView,
                                    Function<Integer, CoinGenerator> coinGeneratingStrategy) {
        this.outputView = outputView;
        this.inputView = inputView;
        MachineSettingController machineSettingController = new MachineSettingController(inputView);
        int machineOwningMoney = machineSettingController.inputMachineOwningMoney().getValue();
        CoinGenerator coinGenerator = coinGeneratingStrategy.apply(machineOwningMoney);
        changeSystem = new ChangeSystem(coinGenerator);
        outputView.showVendingMachineOwningCoins(changeSystem.getOwningCoins());
        items = machineSettingController.inputItems();
        remainingInputMoney = machineSettingController.inputCustomerInputMoney();
    }

    public void run() {
        while (canBuyMore()) {
            buySomething();
        }
        outputView.showRemainingInputMoney(remainingInputMoney.getValue());
        showChanges();
    }

    private boolean canBuyMore() {
        return items.canSellSomethingWith(remainingInputMoney);
    }

    private void buySomething() {
        boolean wrongItemName = true;
        while (wrongItemName) {
            outputView.showRemainingInputMoney(remainingInputMoney.getValue());
            String wantedItemName = inputView.inputWantedItemName();
            try {
                items.sell(wantedItemName, remainingInputMoney);
                wrongItemName = false;
            } catch (Exception exception) {
                inputView.showErrorMessage(exception.getMessage());
            }
        }
    }

    private void showChanges() {
        int remainingMoneyValue = remainingInputMoney.getValue();
        outputView.showChanges(changeSystem.returnChanges(remainingMoneyValue));
    }
}
