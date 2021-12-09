package vendingmachine.reader;

import static java.util.stream.Collectors.toList;
import java.util.List;
import vendingmachine.Item;
import vendingmachine.reader.validator.CompositeValidator;
import vendingmachine.reader.validator.CountOfItemInformationValidator;
import vendingmachine.reader.validator.ItemPriceAndQuantityValidator;
import vendingmachine.reader.validator.Validator;

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

	public static Reader<List<Item>> create() {
		return new ItemListReader(
			new CompositeValidator(new CountOfItemInformationValidator(new ItemLineParser()),
				new ItemPriceAndQuantityValidator(new ItemLineParser())));
	}
}
