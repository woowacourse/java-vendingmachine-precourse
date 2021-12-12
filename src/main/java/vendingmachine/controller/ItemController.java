package vendingmachine.controller;
import java.util.ArrayList;
import vendingmachine.model.Item;

public class ItemController {
    ArrayList<Item> itemList;

    public ItemController() {
        itemList = InputManager.setItemList();
    }
}
