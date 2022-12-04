package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Machine;
import vendingmachine.domain.Product;
import vendingmachine.utils.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static vendingmachine.utils.MachineConst.*;
import static vendingmachine.utils.Message.*;

public class InputView {

    private static final String REGEX_NOT_NUMBER = "\\D";
    private static final int PRODUCT_FORMAT_LENGTH = 3;

    public int inputMachineCoin() {
        try {
            System.out.println(INPUT_INIT);
            String input = Console.readLine();
            validateNumber(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputMachineCoin();
        }
    }

    private void validateNumber(String input) {
        if (isNotNumber(input)) {
            throw new IllegalArgumentException(ErrorMessage.COIN_NOT_NUMBER.getMessage());
        }
        if (isOutOfRange(Integer.parseInt(input))) {
            throw new IllegalArgumentException(ErrorMessage.CHANGE_OUT_OF_RANGE.getMessage());
        }
    }

    private boolean isOutOfRange(int number) {
        return number <= MIN_CASH.get() || number >= MAX_CASH.get();
    }

    private boolean isNotNumber(String input) {
        try {
            int convert = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }

    public List<Product> inputProduct() {
        try {
            System.out.println(INPUT_PRODUCT);
            String input = Console.readLine();
            String[] split = input.split(";");
            return Arrays.stream(split)
                    .map(this::parseProduct)
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputProduct();
        }
    }

    public void inputPurchase(Machine machine) {
        try {
            System.out.println(INPUT_PURCHASE);
            String input = Console.readLine();
            machine.purchase(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputPurchase(machine);
        }
    }

    private Product parseProduct(String input) {
        final String REGEX_PREFIX_SUFFIX = "\\[?\\]?";
        String refined = input.replaceAll(REGEX_PREFIX_SUFFIX, "");
        String[] group = refined.split(",");

        if (group.length != PRODUCT_FORMAT_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.PRODUCT_FORMAT_NOT_MATCH.getMessage());
        }

        return new Product(group[PRODUCT_NAME.get()], Integer.parseInt(group[PRODUCT_AMOUNT.get()]), Integer.parseInt(group[PRODUCT_TOTAL.get()]));
    }

    public int inputcash() {
        try {
            System.out.println(INPUT_CASH);
            String input = Console.readLine();
            validateNumber(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputcash();
        }
    }
}
