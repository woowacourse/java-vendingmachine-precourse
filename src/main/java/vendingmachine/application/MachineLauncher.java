package vendingmachine.application;

import vendingmachine.config.MachineLauncherConfig;
import vendingmachine.io.Input;
import vendingmachine.io.Output;

public class MachineLauncher {
	private Input input;
	private Output output;

	public void run(){
		MachineLauncherConfig.injectDependencies(this);

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
