package vendingmachine.view;

import static camp.nextstep.edu.missionutils.Console.*;
import static vendingmachine.constant.Constant.*;
import static vendingmachine.exception.PriceValidator.*;
import static vendingmachine.exception.ProductValidator.*;

import vendingmachine.machine.Machine;

public class Input {
	Output output = new Output();

	public int inputMachineMoney() {
		while (true) {
			output.printInitMoney();
			String input = readLine();
			try {
				validateInitPrice(input);
				return Integer.parseInt(input);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public String inputProducts() {
		while (true) {
			output.printInsertProduct();
			String input = readLine();
			try {
				validateBlank(input);
				validateSplitProduct(input);
				validateSplitInfos(input.split(PRODUCT_SPLITTER));
				return input;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public int inputUserMoney() {
		while (true) {
			System.out.println();
			output.printInsertMoney();
			String input = readLine();
			try {
				validateInitPrice(input);
				return Integer.parseInt(input);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public String inputBuyProduct(Machine machine) {
		while (true) {
			System.out.println();
			output.printBuy(machine);
			String input = readLine();
			try {
				validateIsIn(machine, input);
				validateCanBuy(machine, input);
				return input;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
