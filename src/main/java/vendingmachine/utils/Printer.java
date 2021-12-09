package vendingmachine.utils;

import static vendingmachine.domain.Machine.*;
import static vendingmachine.domain.MachineClip.*;
import static vendingmachine.utils.Constant.*;

import java.util.Map;

import vendingmachine.domain.MachineClip;

public enum Printer {
	PRINTER;

	public void printMachineAmountNotice(){
		System.out.println(INPUT_MACHINE_AMOUNT);
	}

	public void printProductsNotice(){
		System.out.println(INPUT_PRODUCTS);
	}

	public void printCustomerAmountNotice(){
		System.out.println(LINE_SEPARATOR + INPUT_CUSTOMER_AMOUNT);
	}

	public void printCustomerBuyProductNotice(){
		System.out.println(INPUT_CUSTOMER_BUY_PRODUCT);
	}

	public void printMachineNumOfCoinsNotice(MachineClip machineClip) {
		System.out.println(LINE_SEPARATOR + OUTPUT_MACHINE_NUM_OF_COINS);
		System.out.println(machineClip);
	}

	public void printCustomerCurrentAmount(int amount) {
		System.out.printf(LINE_SEPARATOR + OUTPUT_CUSTOMER_AMOUNT + LINE_SEPARATOR, amount);
	}

	public void printCustomerChange(Map<Integer, Integer> amountToChanges) {
		System.out.println(OUTPUT_CUSTOMER_CHANGE);
		amountToChanges.keySet().stream()
			.forEach(k -> System.out.printf(OUTPUT_CUSTOMER_NUN_OF_CHANGES + LINE_SEPARATOR, k, amountToChanges.get(k)));
	}
}
