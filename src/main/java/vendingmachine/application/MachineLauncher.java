package vendingmachine.application;

import static vendingmachine.domain.Machine.*;
import static vendingmachine.domain.io.Input.*;
import static vendingmachine.domain.io.Output.*;

import vendingmachine.domain.io.Input;
import vendingmachine.domain.io.Output;

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
		int min = input.inputCustomerAmount();

		while(true){
			output.outputCustomerAmount();
			if(MACHINE.isAmountLessThanProductMinPrice(min)) break;
			input.inputCustomerBuyProduct();
		}

		output.outputCustomerChange();
	}
}
