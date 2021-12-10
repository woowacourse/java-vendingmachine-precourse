package vendingmachine.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.domain.Item;

public class ItemParser {
	private static final String OBJECT_SEPARATOR = ";";

	public static List<Item> parseList(String itemListStr) {
		List<String> itemStrs = Arrays.asList(itemListStr.split(OBJECT_SEPARATOR));
		return itemStrs.stream().map(ItemParser::parse).collect(Collectors.toList());
	}

	private static Item parse(String itemStr) {
		return ItemValidator.validate(itemStr);
	}
}
