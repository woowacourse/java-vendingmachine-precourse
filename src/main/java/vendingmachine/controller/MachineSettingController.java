package vendingmachine.controller;

import java.util.List;

import vendingmachine.dto.InputItemDTO;
import vendingmachine.model.item.Items;
import vendingmachine.model.vo.Money;
import vendingmachine.view.input.InputView;

public class MachineSettingController {
    private final InputView inputView;
    private boolean wrongInput;

    public MachineSettingController(final InputView inputView) {
        this.inputView = inputView;
        wrongInput = true;
    }

    public Items inputItems() {
        Items items = null;
        wrongInput = true;
        while(wrongInput) {
            try {
                List<InputItemDTO> itemInfos = inputView.inputItemInfos();
                items = new Items(itemInfos);
                wrongInput = false;
            } catch(Exception exception) {
                inputView.showErrorMessage(exception.getMessage());
            }
        }
        return items;
    }

    public Money inputMachineOwningMoney() {
        wrongInput = true;
        Money money = null;
        while(wrongInput) {
            String userInput = inputView.inputVendingMachineMoney();
            try {
                money = new Money(userInput);
                wrongInput = false;
            } catch (Exception exception) {
                inputView.showErrorMessage(exception.getMessage());
            }
        }
        return money;
    }

    public Money inputCustomerInputMoney() {
        wrongInput = true;
        Money money = null;
        while(wrongInput) {
            String userInput = inputView.inputCustomerMoney();
            try {
                money = new Money(userInput);
                wrongInput = false;
            } catch (Exception exception) {
                inputView.showErrorMessage(exception.getMessage());
            }
        }
        return money;
    }

}
