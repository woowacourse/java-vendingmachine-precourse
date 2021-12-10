package vendingmachine.service;

import java.util.Map;

import vendingmachine.domain.Machine;
import vendingmachine.domain.MachineClip;
import vendingmachine.domain.RandomBox;

public class MachineClipService {

	private final MachineClip machineClip;
	private final RandomBox randomBox;
	private final Machine machine;

	public MachineClipService(MachineClip machineClip, RandomBox randomBox, Machine machine) {
		this.machineClip = machineClip;
		this.randomBox = randomBox;
		this.machine = machine;
	}

	public void initMachineClip(int amount){
		machineClip.init(randomBox.getNumOfCoins(amount));
	}

	public Map<Integer, Integer> sendChanges(){
		return machineClip.getAmountToChanges(machine.getAmount());
	}

	public MachineClip sendMachineClipStat(){
		return machineClip;
	}

}
