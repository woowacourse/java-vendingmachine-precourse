package vendingmachine.reader.validator.item;

import vendingmachine.model.ItemRepository;
import vendingmachine.reader.validator.Validator;

public class NotFoundItemValidator implements Validator {
	private final ItemRepository itemRepository;

	public NotFoundItemValidator(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@Override
	public boolean validate(String value) {
		return itemRepository.existsByName(value);
	}

	@Override
	public String getErrorMessage(String value, String inputValueName) {
		return "[ERROR] " + value + "의 이름을 가진 상품이 없습니다.";
	}
}
