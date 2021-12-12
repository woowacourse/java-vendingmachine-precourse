package vendingmachine.controller;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.Validators;
import vendingmachine.model.Item;
import vendingmachine.model.VendingMachine;

import java.util.Arrays;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class InputManager {
    private static final String PREFIX_ERROR = "[ERROR]";

    private static String getUserInput(String guide) {
        System.out.println(guide);
        String userInput = Console.readLine();
        System.out.println();
        return userInput;
    }

    public static VendingMachine setVendingMachine() {
        while (true) {
            String inputData = getUserInput("자판기가 보유하고 있는 금액을 입력해 주세요.");
            try {
                Validators.validateAmount(inputData);
                return new VendingMachine(Integer.parseInt(inputData));
            } catch (IllegalArgumentException e) {
                System.out.println(PREFIX_ERROR + " 0 또는 자연수만 입력 가능합니다.");
            }
        }
    }

    public static ArrayList<Item> setItemList() {
        while (true) {
            String inputData = getUserInput("상품명과 가격, 수량을 입력해 주세요.");
            try {
                Validators.validateItem(inputData);
                return new ArrayList<Item>(Arrays.stream(inputData.split(";")).map((eachItem) -> {
                    String[] itemData = eachItem.split(",");
                    return new Item(itemData[0], Integer.parseInt(itemData[1]), Integer.parseInt(itemData[2]));
                }).collect(Collectors.toList()));
            } catch (IllegalArgumentException e) {
                System.out.println(PREFIX_ERROR + " 잘못된 상품 입력입니다.");
            }
        }
    }

    public static int setUserAmount() {
        while (true) {
            String inputData = getUserInput("투입 금액을 입력해주세요.");
            try {
                Validators.validateIntegerString(inputData);
            } catch (IllegalArgumentException e) {
                System.out.println(PREFIX_ERROR + " 잘못된 금액 입력입니다.");
            }
        }
    }
}
