package vendingmachine.service;

import vendingmachine.domain.Items;
import vendingmachine.domain.VendingMachine.VendingMachine;
import vendingmachine.domain.VendingMachine.Wallet;
import vendingmachine.util.Validator;

public class VendingMachineService {
    public static VendingMachine getVendingMachine(String walletString, String itemsString) {
        Validator.validateNumber(walletString);
        Wallet wallet = new Wallet(Integer.parseInt(walletString));
        Items items = ItemService.getItems(itemsString);
        return new VendingMachine(wallet, items);
    }
}
