package vendingmachine.reader.validator.item;

import vendingmachine.model.item.Item;
import vendingmachine.model.item.ItemRepository;
import vendingmachine.model.machine.VendingMachine;
import vendingmachine.model.machine.VendingMachineRepository;
import vendingmachine.reader.validator.Validator;

public class NotEnoughMoneyValidator implements Validator {
	private final ItemRepository itemRepository;
	private final VendingMachineRepository vendingMachineRepository;

	public NotEnoughMoneyValidator(ItemRepository itemRepository,
	                               VendingMachineRepository vendingMachineRepository) {
		this.itemRepository = itemRepository;
		this.vendingMachineRepository = vendingMachineRepository;
	}

	@Override
	public boolean validate(String value) {
		Item item = itemRepository.findByName(value);
		VendingMachine vendingMachine = vendingMachineRepository.find();
		return vendingMachine.isSalable(item);
	}

	@Override
	public String getErrorMessage(String value, String inputValueName) {
		return "[ERROR] " + value + "를 구매하기에 돈이 부족합니다.";
	}
}
