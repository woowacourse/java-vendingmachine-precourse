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
	private static final String PREFIX = "[";
	private static final String SUFFIX = "]";
	private static final String DELIMITER_COMMA = ",";
	private static final String INVALID_PREFIX_AND_SUFFIX_ERROR = "각 상품별 정보는 " + PREFIX + "로 시작해서"
		+ SUFFIX + "로 끝나야 합니다.";
	private final InputView inputView;

	ItemController(InputView inputView) {
		this.inputView = inputView;
	}

	public Items giveItems() {
		try {
			List<String> itemDetails = extractItemDetails();
			return initializeItems(itemDetails);
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return giveItems();
		}
	}

	public int getLeastItemCost(Items items) {
		return items.findAll()
			.stream()
			.min(Comparator.comparing(Item::getCost))
			.get()
			.getCost();
	}

	private Items initializeItems(List<String> itemDetails) {
		List<Item> items = new ArrayList<>();
		for (String itemDetail : itemDetails) {
			if (!(itemDetail.startsWith(PREFIX) && itemDetail.endsWith(SUFFIX))) {
				throw new IllegalArgumentException(INVALID_PREFIX_AND_SUFFIX_ERROR);
			}
			items.add(new Item(extractValueFromItemDetail(itemDetail)));
		}
		return new Items(items);
	}

	private List<String> extractItemDetails() {
		try {
			OutputView.printItemsRequest();
			return inputView.scanItemDetailList();
		} catch (IllegalArgumentException e) {
			OutputView.printError(e.getMessage());
			return extractItemDetails();
		}
	}

	private List<String> extractValueFromItemDetail(String itemDetail) {
		String itemDetailBracketRemoved = itemDetail.substring(itemDetail.indexOf(PREFIX) + 1,
			itemDetail.lastIndexOf(SUFFIX));
		return Splitter.on(DELIMITER_COMMA).trimResults().omitEmptyStrings().splitToList(itemDetailBracketRemoved);
	}
}
