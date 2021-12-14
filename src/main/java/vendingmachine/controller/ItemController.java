package vendingmachine.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.google.common.base.Splitter;

import vendingmachine.domain.Item;
import vendingmachine.domain.Items;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class ItemController {
	private static final int ZERO = 0;
	private static final String PREFIX = "[";
	private static final String SUFFIX = "]";
	private static final String DELIMITER_COMMA = ",";
	private static final String ERROR = "[ERROR] ";
	private static final String INVALID_PREFIX_AND_SUFFIX_ERROR = ERROR + "각 상품별 정보는 %s로 시작해서 %s로 끝나야 합니다.";
	private static final String NOT_ENOUGH_MONEY_ERROR = ERROR + "투입 금액보다 상품의 금액이 더 비싸므로 상품을 구매할 수 없습니다.";
	private static final String OUT_OF_ORDER_ERROR = ERROR + "상품의 재고가 소진되어 구매할 수 없습니다.";
	private final InputView inputView;
	private final OutputView outputView;
	private Items items;

	public ItemController(final InputView inputView, final OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public void setupItems() {
		this.items = initializeItems();
	}

	private Items initializeItems() {
		try {
			List<String> itemDetails = enterItemList();
			return makeItems(itemDetails);
		} catch (IllegalArgumentException e) {
			outputView.printError(e.getMessage());
			return initializeItems();
		}
	}

	private List<String> enterItemList() {
		try {
			outputView.printEnterItemListRequest();
			return inputView.scanItemList();
		} catch (IllegalArgumentException e) {
			outputView.printError(e.getMessage());
			return enterItemList();
		}
	}

	private Items makeItems(final List<String> itemList) {
		List<Item> items = new ArrayList<>();
		for (String details : itemList) {
			if (!(details.startsWith(PREFIX) && details.endsWith(SUFFIX))) {
				throw new IllegalArgumentException(String.format(INVALID_PREFIX_AND_SUFFIX_ERROR, PREFIX, SUFFIX));
			}
			items.add(new Item(extractValueFromItemDetails(details)));
		}
		return new Items(items);
	}

	private List<String> extractValueFromItemDetails(final String details) {
		String itemDetailBracketRemoved = details.substring(details.indexOf(PREFIX) + 1,
			details.lastIndexOf(SUFFIX));
		return Splitter.on(DELIMITER_COMMA).trimResults().omitEmptyStrings().splitToList(itemDetailBracketRemoved);
	}

	public int getLeastItemCost() {
		return items.findAll()
			.stream()
			.filter((item) -> ZERO < item.getAmount())
			.min(Comparator.comparing(Item::getCost))
			.get()
			.getCost();
	}

	public int sellItem(final int money) {
		Item item = items.findItemByName(inputView.scanItemName());
		checkItemSellable(item, money);
		item.sell();
		return item.getCost();
	}

	public void checkItemSellable(final Item item, final int money) {
		if (!item.isStockExist()) {
			throw new IllegalArgumentException(OUT_OF_ORDER_ERROR);
		}
		if (!(money >= item.getCost())) {
			throw new IllegalArgumentException(NOT_ENOUGH_MONEY_ERROR);
		}
	}

	public boolean checkAllOutOfOrder() {
		return items.findAll().stream()
			.map(Item::isStockExist)
			.noneMatch((condition) -> true);
	}

}
