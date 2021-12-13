package vendingmachine.controller;

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
    public static VendingMachine setVendingMachine() {
        while (true) {
            String inputData = InputManager.getUserInput("자판기가 보유하고 있는 금액을 입력해 주세요.");
            try {
                Validators.validateAmount(inputData);
                return new VendingMachine(Integer.parseInt(inputData));
            } catch (IllegalArgumentException e) {
                OutputManager.printErrorMessage("0 또는 자연수만 입력 가능합니다.");
            }
        }
    }

    private static ArrayList<Item> createItemList(String inputData) {
        List<Item> items = Arrays.stream(inputData.split(";"))
                .map((eachItem) -> {
                    String removedBracket = eachItem.substring(1, eachItem.length()-1);
                    String[] itemData = removedBracket.split(",");
                    return new Item(itemData[0], Integer.parseInt(itemData[1]), Integer.parseInt(itemData[2]));
                }).collect(Collectors.toList());
        return new ArrayList<Item>(items);
    }

    public static ArrayList<Item> setItemList() {
        while (true) {
            String inputData = InputManager.getUserInput("상품명과 가격, 수량을 입력해 주세요.");
            try {
                Validators.validateItem(inputData);
            } catch (IllegalArgumentException e) {
                OutputManager.printErrorMessage("잘못된 상품 입력입니다.");
                continue;
            }
            return createItemList(inputData);
        }
    }

    public static int setUserAmount() {
        while (true) {
            String inputData = InputManager.getUserInput("투입 금액을 입력해주세요.");
            try {
                Validators.validateIntegerString(inputData);
                return Integer.parseInt(inputData);
            } catch (IllegalArgumentException e) {
                OutputManager.printErrorMessage("잘못된 금액 입력입니다.");
            }
        }
    }

    public static String getWantedItemName() {
        while (true) {
            try {
                String inputData = InputManager.getUserInput("구매할 상품명을 입력해주세요.");
                Validators.validateEmptyString(inputData);
                return inputData;
            } catch (IllegalArgumentException e) {
                OutputManager.printErrorMessage("잘못된 상품 입력입니다.");
            }
        }
    }
}
