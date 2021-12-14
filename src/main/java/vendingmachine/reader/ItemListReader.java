package vendingmachine.reader;

import static java.util.stream.Collectors.toList;

import java.util.List;

import vendingmachine.model.item.Item;
import vendingmachine.reader.validator.CompositeValidator;
import vendingmachine.reader.validator.Validator;
import vendingmachine.reader.validator.item.ItemLineValidator;
import vendingmachine.reader.validator.item.ItemPriceValidator;

public class ItemListReader extends Reader<List<Item>> {
	private final ItemLineParser parser;

	public ItemListReader(Validator validator) {
		super(validator);
		parser = new ItemLineParser();
	}

	@Override
	protected void printInputMessage() {
		System.out.println("상품명과 가격, 수량을 입력해 주세요.");
	}

	@Override
	protected List<Item> parse(String value) {
		return convertToItemList(parser.parse(value));
	}

	@Override
	protected String getInputValueName() {
		return "상품 리스트";
	}

	private List<Item> convertToItemList(List<String[]> splitByComma) {
		return splitByComma.stream().map(item -> Item.of(item[0], Integer.parseInt(item[1]), Integer.parseInt(item[2])))
			.collect(toList());
	}

	public static RecursiveReader<List<Item>> recursiveReader() {
		ItemLineParser parser = new ItemLineParser();
		return new RecursiveReader<>(
			new ItemListReader(
				new CompositeValidator(
					new ItemLineValidator(),
					new ItemPriceValidator(parser))));
	}
}
