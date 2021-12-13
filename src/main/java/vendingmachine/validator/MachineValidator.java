package vendingmachine.validator;

public class MachineValidator {
    public int checkAsset(int money) {
        if (money % 10 != 0) {
            throw new IllegalArgumentException();
        }
        return money;
    }
}
