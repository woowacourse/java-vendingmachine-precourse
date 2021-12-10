package vendingmachine.application;

import static vendingmachine.io.Input.*;
import static vendingmachine.io.Output.*;

import vendingmachine.io.Input;
import vendingmachine.io.Output;

public enum MachineLauncher {
	MACHINE_LAUNCHER(INPUT, OUTPUT);

	private Input input;
	private Output output;

	MachineLauncher(Input input, Output output){
		this.input = input;
		this.output = output;
	}

	public void run(){
		input.inputMachineAmount();
		output.outputMachineNumOfCoins();

		input.inputProducts();
		int minPriceOfProducts = input.inputCustomerAmount();

		while(true){
			if(output.outputCustomerAmount(minPriceOfProducts)) break;
			input.inputCustomerBuyProduct();
		}

		output.outputCustomerChange();
	}
}
