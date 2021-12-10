package vendingmachine.service;

import java.util.Map;

import vendingmachine.domain.Machine;
import vendingmachine.domain.MachineWallet;
import vendingmachine.domain.RandomBox;

public class MachineWalletService {

	private final Machine machine;
	private final MachineWallet machineWallet;
	private final RandomBox randomBox;

	public MachineWalletService(Machine machine, MachineWallet machineWallet, RandomBox randomBox) {
		this.machine = machine;
		this.machineWallet = machineWallet;
		this.randomBox = randomBox;
	}

	public void save(int amount){
		machineWallet.save(randomBox.getCoins(amount));
	}

	public Map<Integer, Integer> getChanges(){
		return machineWallet.saveChangesByAmount(machine.getAmount());
	}

	public String getMachineClipStatus(){
		return machineWallet.toString();
	}

}
