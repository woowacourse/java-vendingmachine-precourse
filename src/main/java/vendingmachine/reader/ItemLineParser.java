package vendingmachine.reader;

import java.util.List;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

public class ItemLineParser {
	public List<String[]> parse(String value) {
		return splitByComma(removeBracket(splitBySemicolon(value)));
	}

	public String[] splitBySemicolon(String value) {
		return value.split(";");
	}

	private List<String> removeBracket(String[] items) {
		return Stream.of(items).map(item -> item.substring(1, item.length() - 1)).collect(toList());
	}

	private List<String[]> splitByComma(List<String> removeBracket) {
		return removeBracket.stream().map(item -> item.split(",")).collect(toList());
	}
}
