package vendingmachine.machine;

public class MachineController {
    private final Machine machine;

    public MachineController() {
        machine = new Machine(initInputMoney());
    }

    public int initInputMoney() {
        int inputMoney = 0;
        try {
            String clientInput = MachineInputView.initInputMoneyByClient();
            // 검증 로직
            inputMoney = Integer.parseInt(clientInput);
        } catch (IllegalArgumentException e) {
            initInputMoney();
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
        if (machine.getAmountByClient() > price) {
            return false;
        }
        machine.buyProduct(price);
        return true;
    }

    public void nowInputAmount() {
        MachineOutputView.printInputAmount(machine.toString());
    }
}
