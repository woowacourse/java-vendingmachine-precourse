package vendingmachine.controller;

import static vendingmachine.Constant.*;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Item;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class InputController {
	public int scanHoldingMoney() {
		while (true) {
			try {
				InputView.askHoldingMoney();
				String holdingMoney = Console.readLine();
				int money = InputValidator.isNumber(holdingMoney);
				InputValidator.checkValidRange(money, HOLDING_MONEY_RANGE);
				return money;
			} catch (IllegalArgumentException e) {
				OutputView.printMoneyError();
			}
		}
	}

	public List<Item> scanItemInform() {
		List<Item> splitItem;
		while (true) {
			try {
				InputView.askItemInform();
				String itemInform = Console.readLine();
				String[] eachItemInform = itemInform.split(COLON_SIGN);
				splitItem = splitItemInform(eachItemInform);
				return splitItem;
			} catch (IllegalArgumentException e) {
				OutputView.printItemError();
			}
		}
	}

	public List<Item> splitItemInform(String[] eachItemInform) {
		List<Item> itemList = new ArrayList<>();
		List<String> itemNameList = new ArrayList<>();
		for (String inform : eachItemInform) {
			InputValidator.checkValidFormat(inform);
			String[] itemInform = inform.split(COMMA_SIGN);
			itemInform[ITEM_NAME_INDEX] = itemInform[ITEM_NAME_INDEX].substring(TO_ELIMINATE_FIRST_BRACKET);
			itemInform[ITEM_COUNT_INDEX] = itemInform[ITEM_COUNT_INDEX].substring(0,
				itemInform[ITEM_COUNT_INDEX].length() - 1);
			InputValidator.checkDuplicateName(itemNameList, itemInform[ITEM_NAME_INDEX]);
			InputValidator.checkValidSplitFormat(itemInform);
			Item item = new Item(itemInform);
			itemList.add(item);
		}
		return itemList;
	}

	public int scanInputMoney() {
		while (true) {
			try {
				InputView.askInputMoney();
				String inputMoney = Console.readLine();
				int money = InputValidator.isNumber(inputMoney);
				InputValidator.checkValidRange(money, INPUT_MONEY_RANGE);
				return money;
			} catch (IllegalArgumentException e) {
				OutputView.printInputMoneyError();
			}
		}
	}

	public int scanBuyingItem(List<Item> itemList) {
		while (true) {
			try {
				InputView.askBuyingItem();
				String buyingItem = Console.readLine();
				int itemIndex = InputValidator.checkValidItem(itemList, buyingItem);
				return itemIndex;
			} catch (IllegalArgumentException e) {
				OutputView.printNotExistingItemError();
			}
		}
	}
}
