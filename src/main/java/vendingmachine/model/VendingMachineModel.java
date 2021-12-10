package vendingmachine.model;

import static vendingmachine.constants.ProgramConstants.*;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.resource.Coin;
import vendingmachine.resource.CoinStorage;

public class VendingMachineModel {
	private final static VendingMachineModel vendingMachineModel = new VendingMachineModel();

	private final CoinStorage coinStorage;

	private VendingMachineModel() {
		coinStorage = CoinStorage.getCoinStorage();
	}

	public static VendingMachineModel getVendingMachineModel() {
		return vendingMachineModel;
	}

	public void generateCoins(int amount) {
		while (amount > 0) {
			List<Integer> possibleMonetaryUnit = getPossibleMonetaryUnit(amount);
			int pickedAmount = Randoms.pickNumberInList(possibleMonetaryUnit);
			coinStorage.createCoin(pickedAmount);
			amount -= pickedAmount;
		}
	}

	private List<Integer> getPossibleMonetaryUnit(int amount) {
		List<Integer> monetaryUnit = Coin.getMonetaryUnitList();
		for (int oneUnit : Coin.getMonetaryUnitList()) {
			if (amount < oneUnit) {
				monetaryUnit.remove(0);
			}
		}
		return monetaryUnit;
	}
}
