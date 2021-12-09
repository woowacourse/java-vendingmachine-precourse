package vendingmachine.utils;

import static vendingmachine.domain.Machine.*;
import static vendingmachine.domain.MachineClip.*;
import static vendingmachine.utils.Constant.*;

import vendingmachine.domain.Machine;

public enum Printer {
	PRINTER;

	private Machine machine;

	Printer() {
		machine = MACHINE;
	}

	public void printMachineAmountNotice(){
		System.out.println(INPUT_MACHINE_AMOUNT);
	}

	public void printProductsNotice(){
		System.out.println(INPUT_PRODUCTS);
	}

	public void printCustomerAmountNotice(){
		System.out.println(INPUT_CUSTOMER_AMOUNT);
	}

	public void printCustomerBuyProductNotice(){
		System.out.println(INPUT_CUSTOMER_BUY_PRODUCT);
	}

	public void printMachineNumOfCoins() {
		System.out.println(OUTPUT_MACHINE_NUM_OF_COINS);
		System.out.println(MACHINE_CLIP);
	}

	public void printCustomerCurrentAmount() {
		System.out.printf(OUTPUT_CUSTOMER_AMOUNT, machine.getAmount());
	}

	public void printCustomerChange() {
		System.out.println(OUTPUT_CUSTOMER_CHANGE);
	}
}
