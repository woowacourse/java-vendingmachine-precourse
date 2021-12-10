package vendingmachine.machine;

import vendingmachine.ValidatorMessage;

public class MachineController {
    private final Machine machine;

    public MachineController() {
        machine = new Machine(initInputMoney());
    }

    public int initInputMoney() {
        int inputMoney;
        try {
            String clientInput = MachineInputView.initInputMoneyByClient();
            MachineValidator.validateAmountNaturalNumber(clientInput);
            inputMoney = Integer.parseInt(clientInput);
        } catch (IllegalArgumentException e) {
            ValidatorMessage.printError(e.getMessage());
            inputMoney = initInputMoney();
        }
        return inputMoney;
    }

    public String buyWhichProduct() {
        return MachineInputView.buyWhichProductByClient();
    }

    public void buyProduct(int price) {
        MachineValidator.validateMoneyEnough(machine.getAmountByClient(), price);
        machine.buyProduct(price);
    }

    public int nowInputAmount() {
        return machine.getAmountByClient();
    }

    public void nowInputAmountInfo() {
        MachineOutputView.printInputAmount(machine.toString());
    }
}
