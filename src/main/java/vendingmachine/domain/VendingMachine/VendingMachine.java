package vendingmachine.domain.VendingMachine;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private final List<Item> items;
    private final Wallet wallet;

    public VendingMachine(Wallet wallet) {
        this.wallet = wallet;
        items = new ArrayList<>();
    }

}
