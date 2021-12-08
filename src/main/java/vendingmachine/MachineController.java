package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class MachineController {
    private VendingMachine vendingMachine;

    public void run() {
        initMachine();
    }

    private void initMachine() {
        vendingMachine = new VendingMachine(inputAmount());
    }

    private int inputAmount() {
        while (true) {
            try {
                return Validator.validateAmount(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println("invalid amount");
            }
        }
    }
}
