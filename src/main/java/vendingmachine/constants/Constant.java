package vendingmachine.constants;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Item;

public class Constant {
	public static final List<Integer> COIN_VALUES = Stream.of(Coin.values())
			.map(Coin::getAmount)
			.collect(Collectors.toList());
	public static final int INIT_COUNT = 0;
	public static final int RUN_OUT_OF_STOCK = 0;
	public static final int ADD_ONE = 1;
	public static final int MIN_RANGE_VALUE = 0;
	public static final int VALID_UNIT = 0;

	public static final char INVALID_CHAR = ';';

	public static final String ITEM_SPLIT_CRITERIA = ";";
	public static final String INFO_SPLIT_CRITERIA = ",";
	public static final String EMPTY = "";
	public static final String WHITE_SPACE = " ";
	public static final String VALIDATE_ITEM_INFO_FORMAT = "(^\\[)([가-힣a-zA-Z0-9]{1,10}),(\\d{2,10}),(\\d{1,10})(\\]$)";

	public static final Item ELEMENT_NOT_FOUNDED = null;

	private Constant() {

	}
}
