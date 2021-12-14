package vendingmachine.views;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.utils.BuyingItemValidation;
import vendingmachine.utils.ItemsGenerator;
import vendingmachine.utils.ItemsValidation;
import vendingmachine.utils.MoneyValidation;
import vendingmachine.domain.Item;
import vendingmachine.domain.Items;

public class InputView {
	private static final String ERROR_MESSAGE = "[ERROR] ";
	private static final String ENTER_VENDING_MACHINE_MONEY = "자판기가 보유하고 있는 금액을 입력해 주세요.";
	private static final String ENTER_ITEM_INFO = "상품명과 가격, 수량을 입력해 주세요.";
	private static final String ENTER_INSERT_AMOUNT = "투입 금액을 입력해 주세요.";
	private static final String ENTER_BUYING_ITEM = "구매할 상품명을 입력해 주세요.";

	public int getInputOfVendingMachineMoney() {
		try {
			System.out.println(ENTER_VENDING_MACHINE_MONEY);
			String vendingMachineMoney = Console.readLine();
			MoneyValidation.validateVendingMachineMoney(vendingMachineMoney);
			return Integer.parseInt(vendingMachineMoney);
		} catch (IllegalArgumentException e) {
			System.out.println(ERROR_MESSAGE + e.getMessage());
			return getInputOfVendingMachineMoney();
		}
	}

	public Items getInputOfItems() {
		try {
			System.out.println();
			System.out.println(ENTER_ITEM_INFO);
			String items = Console.readLine();
			ItemsValidation.validateItemsInput(items);
			return ItemsGenerator.generateItems(items);
		} catch (IllegalArgumentException e) {
			System.out.println(ERROR_MESSAGE + e.getMessage());
			return getInputOfItems();
		}
	}

	public int getInputOfInsertAmount() {
		try {
			System.out.println();
			System.out.println(ENTER_INSERT_AMOUNT);
			String insertAmount = Console.readLine();
			MoneyValidation.validateInsertAmount(insertAmount);
			return Integer.parseInt(insertAmount);
		} catch (IllegalArgumentException e) {
			System.out.println(ERROR_MESSAGE + e.getMessage());
			return getInputOfInsertAmount();
		}
	}

	public Item getInputOfBuyingItem(Items items, int insertAmount) {
		try {
			System.out.println(ENTER_BUYING_ITEM);
			String buyingItem = Console.readLine();
			BuyingItemValidation.validateBuyingItem(items, insertAmount, buyingItem);
			return items.findItemWithName(buyingItem);
		} catch (IllegalArgumentException e) {
			System.out.println(ERROR_MESSAGE + e.getMessage());
			return getInputOfBuyingItem(items, insertAmount);
		}
	}
}
