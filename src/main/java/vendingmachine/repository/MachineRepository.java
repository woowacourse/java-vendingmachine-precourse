package vendingmachine.repository;

import java.util.HashMap;
import java.util.Map;

import vendingmachine.domain.Machine;

public class MachineRepository {
	private Long id = 0L;
	private final Map<Long, Machine> machineDB = new HashMap<>();

	public Long generate() {
		Long returnId = id;
		machineDB.put(id, new Machine());
		id += 1;
		return returnId;
	}

	public Machine findById(Long id) {
		return machineDB.get(id);
	}
}
