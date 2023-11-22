package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.dto.ItemDto;
import vendingmachine.utils.InputAmountValidator;
import vendingmachine.utils.ItemValidator;
import vendingmachine.utils.VendingMachineAmountValidator;

import java.util.List;
import java.util.stream.Collectors;

import static vendingmachine.exception.ErrorMessage.INVALID_ITEMS_FORMAT;

public class InputView {
    private static final String ASK_VENDING_MACHINE_AMOUNT = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String ASK_ITEMS = "상품명과 가격, 수량을 입력해 주세요.";
    private static final String ASK_INPUT_AMOUNT = "투입 금액을 입력해 주세요.";
    private static final String ITEM_START_SYMBOL = "[";
    private static final String ITEM_END_SYMBOL = "]";
    private static final String ITEM_DELIMITER = ";";
    private static final String ITEM_DETAIL_DELIMITER = ",";
    private static final int REQUIRED_ITEM_COMPONENTS = 3;
    private static final int ITEM_NAME_INDEX = 0;
    private static final int ITEM_PRICE_INDEX = 1;
    private static final int ITEM_QUANTITY_INDEX = 2;
    private static final String ASK_ORDER_ITEM = "구매할 상품명을 입력해 주세요.";

    public long readVendingMachineAmount() {
        System.out.println(ASK_VENDING_MACHINE_AMOUNT);
        String input = Console.readLine();
        return VendingMachineAmountValidator.safeParseLong(input);
    }

    public List<ItemDto> readItems() {
        printNewLine();
        System.out.println(ASK_ITEMS);
        String input = Console.readLine();
        List<String> pairs = ItemValidator.safeSplit(input, ITEM_DELIMITER);
        return toItemDto(pairs);
    }

    private void printNewLine() {
        System.out.println();
    }

    private List<ItemDto> toItemDto(List<String> pairs) {
        return pairs.stream()
                .map(pair -> ItemValidator.validateAndCleanPair(pair, ITEM_START_SYMBOL, ITEM_END_SYMBOL))
                .map(this::createItemDto)
                .collect(Collectors.toList());
    }

    private ItemDto createItemDto(String pair) {
        List<String> pairs = ItemValidator.safeSplit(pair, ITEM_DETAIL_DELIMITER);

        if (pairs.size() != REQUIRED_ITEM_COMPONENTS) {
            throw new IllegalArgumentException(INVALID_ITEMS_FORMAT.getMessage());
        }
        String name = pairs.get(ITEM_NAME_INDEX);
        long price = ItemValidator.safeParsePositiveLong(pairs.get(ITEM_PRICE_INDEX));
        long quantity = ItemValidator.safeParsePositiveLong(pairs.get(ITEM_QUANTITY_INDEX));

        return ItemDto.of(name, price, quantity);
    }

    public long readInputAmount() {
        printNewLine();
        System.out.println(ASK_INPUT_AMOUNT);
        String input = Console.readLine();
        return InputAmountValidator.safeParsePositiveLong(input);
    }

    public String readOrderItemName() {
        System.out.println(ASK_ORDER_ITEM);
        return Console.readLine();
    }
}