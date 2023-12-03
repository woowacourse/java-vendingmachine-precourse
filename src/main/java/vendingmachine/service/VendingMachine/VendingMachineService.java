package vendingmachine.service.VendingMachine;

import vendingmachine.domain.Items;
import vendingmachine.domain.VendingMachine.VendingMachine;
import vendingmachine.domain.VendingMachine.Wallet;
import vendingmachine.service.ItemService;

public class VendingMachineService {

    public static VendingMachine getVendingMachine(String walletString, String itemsString) {
        validateNumber(walletString);
        Wallet wallet = new Wallet(Integer.parseInt(walletString));
        Items items = ItemService.getItems(itemsString);
        return new VendingMachine(wallet, items);
    }

    private static void validateNumber(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력값이 숫자가 아닙니다!");
        }
    }
}
