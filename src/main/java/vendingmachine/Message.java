package vendingmachine;

public class Message {
    public void printInputHolding() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해주세요.");
    }

    public void printInputNumber() {
        System.out.println("[ERROR] 10으로 나누어 떨어지는 0 이상의 숫자를 입력해주세요.");
    }

    public void printCoinCount(String message) {
        System.out.println("자판기가 보유한 동전");
        System.out.println(message);
    }
}
