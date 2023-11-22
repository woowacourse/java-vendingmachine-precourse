package vendingmachine.domain;

import static vendingmachine.constants.Coin.COIN_10;
import static vendingmachine.error.ErrorCode.INVALID_INPUT_AMOUNT;

//TODO: 이름 변경 -> 투입 금액 생으로 쓰니까 어색함. 잔고의 느낌이 나는 정도로 변경하기
public class InputAmount {
    private int currentMoney;

    private InputAmount(int currentMoney) {
        validate(currentMoney);
        this.currentMoney = currentMoney;
    }

    public static InputAmount create(int input) {
        return new InputAmount(input);
    }

    private void validate(int input) {
        if (input % COIN_10.getAmount() != 0) {
            throw new IllegalArgumentException(INVALID_INPUT_AMOUNT.getMessage());
        }
    }

    public void pay(int productPrice) {
        this.currentMoney -= productPrice;
    }

    public int getCurrentMoney() {
        return currentMoney;
    }
}
