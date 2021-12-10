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
        String buyProductName = "";
        try {
            buyProductName = MachineInputView.buyWhichProductByClient();
            // 검증로직
        } catch (IllegalArgumentException e) {
            buyWhichProduct();
        }
        return buyProductName;
    }

    public boolean buyProduct(int price) {
        if (machine.getAmountByClient() < price) {
            // 검증 로직 (상품 구매 불가)
            return false;
        }
        machine.buyProduct(price);
        return true;
    }

    public int nowInputAmount() {
        return machine.getAmountByClient();
    }

    public void nowInputAmountInfo() {
        MachineOutputView.printInputAmount(machine.toString());
    }
}
