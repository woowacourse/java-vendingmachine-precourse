package vendingmachine;
import vendingmachine.model.Item;

import java.util.ArrayList;

public class Validators {

    public static int validateIntegerString(String data) {
        try {
            return Integer.parseInt(data);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static int validateAmount(String inputData) {
        try {
            int amount = Integer.parseInt(inputData);
            if (amount <= 0) {
                throw new IllegalArgumentException();
            }
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private static String[] checkItemInformation(String itemString) {
        if (itemString.length() <= 2) {
            throw new IllegalArgumentException();
        }
        itemString = itemString.substring(1, itemString.length()-1);
        String[] itemInformation = itemString.split(",");
        if (itemInformation.length != 3) {
            throw new IllegalArgumentException();
        }
        return itemInformation;
    }

    private static Item checkItemString(String itemString) throws IllegalArgumentException {
        try {
            String[] itemInformation = checkItemInformation(itemString);
            String name = itemInformation[0];
            int price = Integer.parseInt(itemInformation[1]);
            int count = Integer.parseInt(itemInformation[2]);
            return new Item(name, price, count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static ArrayList<Item> validateItem(String inputData) throws IllegalArgumentException {
        String[] itemStringArray = inputData.split(";");
        ArrayList<Item> itemList = new ArrayList<Item>();
        for (String itemString : itemStringArray) {
            itemList.add(checkItemString(itemString));
        }
        return itemList;
    }
}
