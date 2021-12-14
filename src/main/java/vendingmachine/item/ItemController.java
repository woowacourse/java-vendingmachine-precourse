package vendingmachine.item;

import vendingmachine.Validation;

import java.util.ArrayList;
import java.util.List;

public class ItemController {

    Items items;
    private List<Item> itemsList;

    public ItemController() {
        items = new Items();
        itemsList = new ArrayList<>();
    }

    public List<Item> initItmes() {
        String inputItmes = ItemView.inputItems();
        return makeItemsArray(inputItmes);
    }

    public List<Item> makeItemsArray(String inputItems) {
        try {
            itemsArray(inputItems);
            items.setItems(itemsList);
        } catch (IllegalArgumentException e) {
            System.out.println("상품의 이름, 가격, 수량을 정확하게 입력해주세요.");
            initItmes();
        }
        return items.getItems();
    }

    public void itemsArray(String inputItems) {
        String[] itemsStringArray = inputItems.split(";");
        for(String itemDetail : itemsStringArray) {
            int length = itemDetail.length();
            itemsList.add(storageItem(itemDetail.substring(1,length-1)));
        }
    }

    public Item storageItem(String itemDetail) {
        String[] itemInfo = itemDetail.split(",");
        int price = Integer.parseInt(itemInfo[1]);
        Validation.isPositiveNumber(price);
        Validation.isDivideTen(price);

        int count = Integer.parseInt(itemInfo[2]);
        Validation.isPositiveNumber(price);

        Item item = new Item(itemInfo[0], price, count);
        return item;
    }

}
