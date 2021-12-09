package vendingmachine.reader;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Stream;
import vendingmachine.Item;
import static java.util.stream.Collectors.toList;

public class ItemListReader implements Reader<List<Item>>{
	public List<Item> read() {
		System.out.println("상품명과 가격, 수량을 입력해 주세요.");
		String value = Console.readLine();
		return convertToItemList(splitByComma(removeBracket(splitBySemicolon(value))));
	}

	private List<Item> convertToItemList(List<String[]> splitByComma) {
		return splitByComma.stream().map(item -> Item.of(item[0], Integer.parseInt(item[1]), Integer.parseInt(item[2]))).collect(toList());
	}

	private List<String[]> splitByComma(List<String> removeBracket) {
		return removeBracket.stream().map(item -> item.split(",")).collect(toList());
	}

	private List<String> removeBracket(String[] items) {
		return Stream.of(items).map(item -> item.substring(1, item.length() - 1)).collect(toList());
	}

	private String[] splitBySemicolon(String value) {
		return value.split(";");
	}
}
