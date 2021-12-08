package vendingmachine.controller;

import java.util.HashMap;
import java.util.Map;

import vendingmachine.view.InputFirstMoneyView;
import vendingmachine.view.View;

public class VendingMachineController {
	private Map<ViewMappingKey, View> viewMapper = new HashMap<>();

	public VendingMachineController() {
		viewMapper.put(ViewMappingKey.INPUT_FIRST_MONEY, new InputFirstMoneyView());
	}

	public void view(ViewMappingKey key) {
		viewMapper.get(key).show();
	}
}
