package vendingmachine.controller;

import vendingmachine.ErrorMessage;
import vendingmachine.NormalMessage;
import vendingmachine.Validators;
import vendingmachine.model.Item;
import vendingmachine.model.VendingMachine;
import vendingmachine.view.InputManager;
import vendingmachine.view.OutputManager;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class InputProcessor {
    private static final String SPLIT_ITEM_REGEX = ";";
    private static final String SPLIT_ITEM_INFORMATION_REGEX = ",";
    private static final int NOT_CONTAINED_BRACKET_START_POS = 1;

    public static VendingMachine setVendingMachine() {
        while (true) {
            String inputData = InputManager.getUserInput(NormalMessage.VENDING_MACHINE_AMOUNT_GUIDE);
            try {
                Validators.validateAmount(inputData);
                return new VendingMachine(Integer.parseInt(inputData));
            } catch (IllegalArgumentException e) {
                OutputManager.printErrorMessage(ErrorMessage.INVALID_VENDING_MACHINE_AMOUNT_ERROR);
            }
        }
    }

    private static ArrayList<Item> createItemList(String inputData) {
        List<Item> items = Arrays.stream(inputData.split(SPLIT_ITEM_REGEX))
                .map((eachItem) -> {
                    String removedBracket = eachItem.substring(NOT_CONTAINED_BRACKET_START_POS, eachItem.length()-1);
                    String[] itemData = removedBracket.split(SPLIT_ITEM_INFORMATION_REGEX);
                    return new Item(itemData[0], Integer.parseInt(itemData[1]), Integer.parseInt(itemData[2]));
                }).collect(Collectors.toList());
        return new ArrayList<Item>(items);
    }

    public static ArrayList<Item> setItemList() {
        while (true) {
            String inputData = InputManager.getUserInput(NormalMessage.VENDING_MACHINE_ITEM_SET_GUIDE);
            try {
                Validators.validateItem(inputData);
            } catch (IllegalArgumentException e) {
                OutputManager.printErrorMessage(ErrorMessage.INVALID_ITEM_ERROR);
                continue;
            }
            return createItemList(inputData);
        }
    }

    public static int setUserAmount() {
        while (true) {
            String inputData = InputManager.getUserInput(NormalMessage.USER_AMOUNT_GUIDE);
            try {
                Validators.validateIntegerString(inputData);
                return Integer.parseInt(inputData);
            } catch (IllegalArgumentException e) {
                OutputManager.printErrorMessage(ErrorMessage.INVALID_AMOUNT_ERROR);
            }
        }
    }

    public static String getWantedItemName() {
        while (true) {
            try {
                String inputData = InputManager.getUserInput(NormalMessage.USER_BUY_GUIDE);
                Validators.validateEmptyString(inputData);
                return inputData;
            } catch (IllegalArgumentException e) {
                OutputManager.printErrorMessage(ErrorMessage.INVALID_ITEM_ERROR);
            }
        }
    }
}
