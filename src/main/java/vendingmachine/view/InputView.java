package vendingmachine.view;

import static java.lang.System.*;
import static vendingmachine.constant.SystemMessage.*;
import static vendingmachine.domain.Item.*;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.constant.SystemMessage;
import vendingmachine.domain.Item;
import vendingmachine.repository.ItemRepository;
import vendingmachine.validator.InputValidator;

public class InputView {

	public static final String INFO_REMAINING_MONEY = "투입 금액: %d원\n";
	public static final String INPUT_ITEM_NAME_TO_BUY = "구매할 상품명을 입력해 주세요.";

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
				out.println(INPUT_ITEM_NAMES);
				String input = Console.readLine().trim();
				printEmptyLine();
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

	public static int getMoneyToBuy() {
		while (true) {
			try {
				out.println(INPUT_MONEY_TO_BUY);
				String input = Console.readLine().trim();
				InputValidator.validateMoneyToBuy(input);
				SystemMessage.printEmptyLine();
				return Integer.parseInt(input);
			} catch (Exception e) {
				out.println(e.getMessage());
			}
		}
	}

	public static Item printBuying(int remainingMoney) {
		while (true) {
			try {
				out.printf(INFO_REMAINING_MONEY, remainingMoney);
				out.println(INPUT_ITEM_NAME_TO_BUY);
				String input = Console.readLine().trim();
				InputValidator.validateExistItem(input);
				SystemMessage.printEmptyLine();
				return ItemRepository.findItemByName(input);
			} catch (Exception e) {
				out.println(e.getMessage());
			}
		}
	}
}
