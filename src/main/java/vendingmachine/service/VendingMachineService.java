package vendingmachine.service;

import vendingmachine.domain.VendingMachine.Wallet;
import vendingmachine.util.Validator;

public class VendingMachineService {
    public static Wallet getWallet(String walletString) {
        Validator.validateNumber(walletString);
        return new Wallet(Integer.parseInt(walletString));
    }
}
