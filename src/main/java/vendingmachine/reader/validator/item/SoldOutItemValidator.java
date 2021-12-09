package vendingmachine.reader.validator.item;

import vendingmachine.model.item.Item;
import vendingmachine.model.item.ItemRepository;
import vendingmachine.reader.validator.Validator;

public class SoldOutItemValidator implements Validator {
	private final ItemRepository itemRepository;

	public SoldOutItemValidator(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@Override
	public boolean validate(String value) {
		Item item = itemRepository.findByName(value);
		return !item.isSoldOut();
	}

	@Override
	public String getErrorMessage(String value, String inputValueName) {
		return "[ERROR] " + value + "는 품절입니다.";
	}
}
