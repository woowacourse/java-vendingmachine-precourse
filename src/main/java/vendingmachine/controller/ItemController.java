package vendingmachine.controller;
import java.util.ArrayList;
import java.util.stream.IntStream;

import vendingmachine.model.Item;

public class ItemController {
    ArrayList<Item> itemList;

    public ItemController() {
        itemList = InputManager.setItemList();
    }

    public int getMinItemPrice() {
        if (isEmpty()) {
            throw new IllegalArgumentException();
        }
        return itemList.stream()
                .filter((item) -> !item.checkNotItem())
                .flatMapToInt((item) -> IntStream.of(item.getPrice()))
                .min()
                .getAsInt();
    }

    public boolean checkAmount(int amount) {
        return getMinItemPrice() <= amount;
    }

    public boolean isEmpty() {
        return itemList.stream().allMatch(item -> item.checkNotItem());
    }

    public boolean checkInList(String itemName) {
        return itemList.stream()
                .filter(item -> item.checkName(itemName))
                .count() > 0;
    }

    public Item find(String itemName) {
        if (!checkInList(itemName)) {
            throw new IllegalArgumentException();
        }
        return itemList.stream()
                .filter(item -> item.checkName(itemName))
                .findFirst()
                .get();
    }

}
