package vendingmachine.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.domain.Item;

public class ItemParser {
	private static final String PARAMETER_SEPARATOR = ",";
	private static final String OBJECT_SEPARATOR = ";";

	public static List<Item> parseList(String itemListStr) {
		List<String> itemStrs = Arrays.asList(itemListStr.split(OBJECT_SEPARATOR));
		List<Item> items = itemStrs.stream().map(itemStr -> {
			itemStr = itemStr.trim();
			return parse(itemStr);
		}).collect(Collectors.toList());

		return items;
	}

	private static Item parse(String itemStr) {
		return null;
	}
}
