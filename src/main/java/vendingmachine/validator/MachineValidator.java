package vendingmachine.validator;

public class MachineValidator {
    public int checkAsset(int money) {
        if (money < 0 ) {
            throw new IllegalArgumentException();
        }
        return money;
    }
}
