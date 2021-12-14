package vendingmachine.validator;

public class MachineValidator {
    public int checkAsset(int money) {
        if (money < 0 ) {
            throw new IllegalArgumentException("양의 정수를 입력해주세요.");
        }
        return money;
    }
}
