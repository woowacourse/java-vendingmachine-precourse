package vendingmachine.domain;

public class VendingMachineAmount {

    private int vendingMachineAmount;

    public VendingMachineAmount(int vendingMachineAmount) {
        validate(vendingMachineAmount);
        this.vendingMachineAmount = vendingMachineAmount;
    }

    private void validate(int vendingMachineAmount) {
        if (vendingMachineAmount < 10) {
            throw new IllegalArgumentException("[ERROR] 자판기가 보유 금액은 10원 이상이어야 합니다.");
        }
        if (vendingMachineAmount % 10 != 0) {
            throw new IllegalArgumentException("[ERROR] 자판기 보유 금액은 10원 단위만 가능합니다.");
        }
    }

    public int getVendingMachineAmount() {
        return vendingMachineAmount;
    }
}
