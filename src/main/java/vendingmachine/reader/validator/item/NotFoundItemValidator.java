package vendingmachine.reader.validator.item;

import vendingmachine.model.item.ItemRepository;
import vendingmachine.reader.validator.Validator;

public class NotFoundItemValidator implements Validator {
	@Override
	public boolean validate(String value) {
		return ItemRepository.existsByName(value);
	}

	@Override
	public String getErrorMessage(String value, String inputValueName) {
		return "[ERROR] " + value + "의 이름을 가진 상품이 없습니다.";
	}
}
