package vendingmachine.service;

import static vendingmachine.domain.Message.*;

import java.util.LinkedHashMap;

public class MessageService {
    private final MessageFormatService messageFormatService = new MessageFormatService();
    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printChangeAmount(int amount) {
        System.out.printf(INFORM_CHANGE_AMOUNT_MESSAGE, amount);
    }

    public void printCoinCount(LinkedHashMap<Integer, Integer> input) {
        System.out.println(INFORM_COIN_COUNT);
        System.out.println(messageFormatService.makeHoldingMessage(input));
    }

    public void printLastChanges(LinkedHashMap<Integer, Integer> map) {
        System.out.println(messageFormatService.makeLastChanges(map));
    }

    public void printInputProductName() {
        System.out.println(REQUEST_INPUT_PRODUCT_NAME);
    }

    public void printInputHolding() {
        System.out.println(REQUEST_INPUT_MESSAGE);
    }

    public void printInputProducts() {
        System.out.println(REQUEST_PRODUCT_MESSAGE);
    }

    public void printInputAmount() {
        System.out.println(REQUEST_CHANGE_MESSAGE);
    }

    public void printLastAmount() {
        System.out.println(INFORM_CHANGE_MESSAGE);
    }
}
