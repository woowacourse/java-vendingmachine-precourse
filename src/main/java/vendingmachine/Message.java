package vendingmachine;

public class Message {
    public void printInputHolding() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해주세요.");
    }

    public void printInputCorrectNumber() {
        System.out.println("[ERROR] 10으로 나누어 떨어지는 0 이상의 숫자를 입력해주세요.");
    }

    public void printCoinCount(String message) {
        System.out.println("자판기가 보유한 동전");
        System.out.println(message);
    }

    public void printInputProducts() {
        System.out.println("상품명과 가격, 수량을 입력해주세요.");
    }

    public void printInputCorrectFormat() {
        System.out.println("[ERROR] [상품명,가격,수량]의 형식으로 입력해주세요.");
    }

    public void printInputAmount() {
        System.out.println("투입 금액을 입력해 주세요.");
    }

}
