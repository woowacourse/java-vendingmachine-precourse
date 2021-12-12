package vendingmachine.validation;

import vendingmachine.domain.Machine;

public class MachineValidator {
	private static final String NOT_EXIST_ITEM = "상품이 존재하지 않습니다.";
	private Machine machine;

	public MachineValidator(Machine machine) {
		this.machine = machine;
	}

	public boolean isValidSelectedItem(String name) {
		try {
			validateItemExist(name);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
			return false;
		}
		return true;
	}

	public void validateItemExist(String name) {
		if (machine.isExistItem(name) == false) {
			throw new IllegalArgumentException(InputValidator.ERROR_MESSAGE + NOT_EXIST_ITEM);
		}
	}
}
