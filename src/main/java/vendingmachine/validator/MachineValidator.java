package vendingmachine.validator;

public class MachineValidator {
    public void checkAsset(int money) {
        if (money % 10 != 0) {
            throw new IllegalArgumentException();
        }
    }
}
