package vendingmachine;

import camp.nextstep.edu.missionutils.Console;


public class VendingMachine {
    public VendingMachine() {
        initializeVendingMachine();
    }

    public void initializeVendingMachine() {
        while (true) {
            try {
                this.insertChange();
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println("[ERROR]");
            }
        }
    }

    public void insertChange() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해주세요.");
        String changeInVendingMachine = Console.readLine();
        int change = this.validateOnlyInteger(changeInVendingMachine);
        isGreatThanZero(change);
        isMultipleOfTen(change);
    }

    private int validateOnlyInteger(String insertChange) {
        try {
            return Integer.parseInt(insertChange);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    private void isMultipleOfTen(int change) {
        if (change % 10 != 0) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    private void isGreatThanZero(int change) {
        if (change <= 0) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }
}
