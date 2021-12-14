package vendingmachine.view;

import static java.lang.System.*;
import static vendingmachine.constant.SystemMessage.*;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Item;
import vendingmachine.validator.InputValidator;

public class InputView {

	public static final int ITEM_NAME_INDEX = 0;
	public static final int ITEM_PRICE_INDEX = 1;
	public static final int ITEM_COUNT_INDEX = 2;

	public static int getMachineMoney() {
		while (true) {
			try {
				out.println(INPUT_MACHINE_MONEY);
				String input = Console.readLine().trim();
				InputValidator.validateMachineMoney(input);
				printEmptyLine();
				return Integer.parseInt(input);
			} catch (Exception exception) {
				out.println(exception.getMessage());
			}
		}
	}

	public static List<Item> getItems() {
		while (true) {
			try {
				out.println("상품명과 가격, 수량을 입력해 주세요.");
				String input = Console.readLine().trim();
				return getItems(input);
			} catch (Exception exception) {
				out.println(exception.getMessage());
			}
		}

	}

	public static List<Item> getItems(String input) {
		InputValidator.validateItems(input);
		String[] strings = input.split(";");
		List<Item> items = new ArrayList<>();
		for (String string : strings) {
			Item item = getItem(string);
			items.add(item);
		}
		return items;
	}

	private static Item getItem(String input) {
		InputValidator.validateItem(input);
		input = input.replaceAll("[\\[\\]]", "");
		String[] strings = input.split(",");
		String name = strings[ITEM_NAME_INDEX];
		int price = Integer.parseInt(strings[ITEM_PRICE_INDEX]);
		int count = Integer.parseInt(strings[ITEM_COUNT_INDEX]);
		return new Item(name, price, count);
	}
}
