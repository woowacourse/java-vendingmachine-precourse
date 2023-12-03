package vendingmachine.domain.VendingMachine;

import vendingmachine.domain.Items;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private final Items items;
    private final Wallet wallet;

    public VendingMachine(Wallet wallet, Items items) {
        this.wallet = wallet;
        this.items = items;
    }

    public String getCoinsMessage() {
        return wallet.getMessage();
    }
}
