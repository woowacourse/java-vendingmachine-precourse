package vendingmachine.application;

import vendingmachine.config.MachineConfig;
import vendingmachine.io.Input;
import vendingmachine.io.Output;

public class MachineLauncher {
	private Input input;
	private Output output;

	public void run(){
		MachineConfig.injectDependencies(this);

		input.inputMachineAmount();
		output.outputMachineNumOfCoins();

		input.inputProducts();
		input.inputCustomerAmount();

		while(true){
			if(!output.outputCustomerAmount()) break;
			input.inputCustomerBuyProduct();
		}

		output.outputCustomerChange();
	}

	public void addDependencies(Input input, Output output){
		this.input = input;
		this.output = output;
	}
}
