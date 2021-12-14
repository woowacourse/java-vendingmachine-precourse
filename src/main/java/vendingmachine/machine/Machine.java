package vendingmachine.machine;

public class Machine {
    private int inputMoney;

    public Machine(int inputMoney) {
        this.inputMoney = inputMoney;
    }

    public void renewLeftMoney(int price) {
        inputMoney -= price;
    }

    public int getInputMoney() {
        return this.inputMoney;
    }
    public boolean isLack(int minPrice) {
        return inputMoney < minPrice;
    }

    public String toString() {
        return "투입 금액: " + this.inputMoney + "원";
    }

}
