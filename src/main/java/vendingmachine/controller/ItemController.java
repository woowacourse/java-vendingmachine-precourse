package vendingmachine.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.google.common.base.Splitter;

import vendingmachine.domain.Item;
import vendingmachine.domain.Items;
import vendingmachine.domain.Money;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class ItemController {
	private static final int ZERO = 0;
	private static final String PREFIX = "[";
	private static final String SUFFIX = "]";
	private static final String DELIMITER_COMMA = ",";
	private static final String ERROR = "[ERROR] ";
	private static final String INVALID_PREFIX_AND_SUFFIX_ERROR = ERROR + "각 상품별 정보는 " + PREFIX + "로 시작해서"
		+ SUFFIX + "로 끝나야 합니다.";
	private final InputView inputView;
	private final OutputView outputView;

	public ItemController(final InputView inputView, final OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public Items setupItems() {
		return initializeItems();
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
			outputView.printItemsRequest();
			return inputView.scanItemDetailList();
		} catch (IllegalArgumentException e) {
			outputView.printError(e.getMessage());
			return enterItemList();
		}
	}

	private Items makeItems(final List<String> itemDetails) {
		List<Item> items = new ArrayList<>();
		for (String itemDetail : itemDetails) {
			if (!(itemDetail.startsWith(PREFIX) && itemDetail.endsWith(SUFFIX))) {
				throw new IllegalArgumentException(INVALID_PREFIX_AND_SUFFIX_ERROR);
			}
			items.add(new Item(extractValueFromItemDetail(itemDetail)));
		}
		return new Items(items);
	}

	private List<String> extractValueFromItemDetail(final String itemDetail) {
		String itemDetailBracketRemoved = itemDetail.substring(itemDetail.indexOf(PREFIX) + 1,
			itemDetail.lastIndexOf(SUFFIX));
		return Splitter.on(DELIMITER_COMMA).trimResults().omitEmptyStrings().splitToList(itemDetailBracketRemoved);
	}

	public int getLeastItemCost(final Items items) {
		return items.findAll()
			.stream()
			.filter((item) -> ZERO < item.getAmount())
			.min(Comparator.comparing(Item::getCost))
			.get()
			.getCost();
	}

	public void update(final Items items, final Money money) {
		outputView.printMoney(money);
		outputView.printItemPerChaseRequest();
		Item item = items.findItemByName(inputView.scanItemName(), money);
		item.sell();
		money.pay(item.getCost());
	}

}
