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
}
