package vendingmachine;

public class Message {
    public void printInputHolding() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해주세요.");
    }

    public void printInputNumber() {
        System.out.println("[ERROR] 0 이상의 숫자를 입력해주세요.");
    }
}
