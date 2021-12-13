package vendingmachine;

import vendingmachine.ui.MachineUIImpl;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Machine machine = new Machine(new MachineUIImpl(), new Validator());
        machine.operate();
    }
}
