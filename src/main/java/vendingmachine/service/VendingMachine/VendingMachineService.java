package vendingmachine.service.VendingMachine;

import vendingmachine.domain.VendingMachine.VendingMachine;
import vendingmachine.domain.VendingMachine.Wallet;

public class VendingMachineService {

    public static VendingMachine getVendingMachine(String string) {
        validateNumber(string);
        Wallet wallet = new Wallet(Integer.parseInt(string));
        return new VendingMachine(wallet);
    }

    private static void validateNumber(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력값이 숫자가 아닙니다!");
        }
    }
}
