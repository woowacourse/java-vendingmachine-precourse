package vendingmachine.reader;

import vendingmachine.model.ItemRepository;
import vendingmachine.reader.validator.Validator;
import vendingmachine.reader.validator.item.NotFoundItemValidator;

public class PurchaseItemNameReader extends Reader<String> {
	public PurchaseItemNameReader(Validator validator) {
		super(validator);
	}

	@Override
	protected void printInputMessage() {
		System.out.println("구매할 상품명을 입력해 주세요.");
	}

	@Override
	protected String parse(String value) {
		return value;
	}

	@Override
	protected String getInputValueName() {
		return "상품명";
	}

	public static Reader<String> create(ItemRepository itemRepository) {
		return new PurchaseItemNameReader(new NotFoundItemValidator(itemRepository));
	}
}
