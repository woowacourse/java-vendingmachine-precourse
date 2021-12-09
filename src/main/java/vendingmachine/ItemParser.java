package vendingmachine;

import java.util.ArrayList;
import java.util.List;

/**
 * 값을 분석해서 Item 객체를 만드는 model class
 *
 * @author YJGwon
 * @version 1.0
 * @since 1.0
 */
public class ItemParser {
	public Item stringToItem(String string) {
		String[] itemProperties = removeSquareBracket(string).split(",");
		//TODO: 입력값에 대한 예외 검사
		return new Item(itemProperties[0],
			Integer.parseInt(itemProperties[1]),
			Integer.parseInt(itemProperties[2]));
	}

	public List<Item> stringToItemList(String string) {
		List<Item> itemList = new ArrayList<>();
		String[] stringItems = string.split(";");
		for (String stringItem : stringItems) {
			itemList.add(stringToItem(stringItem));
		}
		return itemList;
	}

	private String removeSquareBracket(String stringItem) {
		return stringItem.substring((stringItem.indexOf('[') + 1), stringItem.indexOf(']'));
	}
}
