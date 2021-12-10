package vendingmachine.reader.validator.item;

import vendingmachine.model.item.Item;
import vendingmachine.model.item.ItemRepository;
import vendingmachine.reader.validator.Validator;

public class HasQuantityItemValidator implements Validator {
	@Override
	public boolean validate(String value) {
		Item item = ItemRepository.findByName(value);
		return !item.isSoldOut();
	}

	@Override
	public String getErrorMessage(String value, String inputValueName) {
		return "[ERROR] " + value + "는 품절입니다.";
	}
}
