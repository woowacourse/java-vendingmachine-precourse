package vendingmachine.domain;

import vendingmachine.domain.VendingMachine.Item;

import java.util.List;

public class Items {

    private final List<Item> items;

    public Items(List<Item> items) {
        this.items = items;
    }
}
