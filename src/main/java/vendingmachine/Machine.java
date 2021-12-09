package vendingmachine;

public class Machine {
    User user = new User();

    public void start() {
        machineBalance();
    }

    private void machineBalance() {
        boolean check = false;
        while (!check) {
            System.out.println(Message.INPUT_MACHINE_BALANCE);
            check = user.inputMachineBalance();
        }

    }
}
