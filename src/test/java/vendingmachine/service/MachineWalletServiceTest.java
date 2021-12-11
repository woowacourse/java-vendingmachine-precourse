package vendingmachine.service;

import static org.junit.jupiter.api.Assertions.*;
import static vendingmachine.config.ConstantConfig.*;
import static vendingmachine.domain.RandomBox.*;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vendingmachine.domain.Machine;
import vendingmachine.domain.MachineWallet;

class MachineWalletServiceTest {

	private Machine machine;
	private MachineWallet machineWallet;
	private MachineWalletService machineWalletService;

	@BeforeEach
	void beforeEach() {
		machine = new Machine();
		machineWallet = new MachineWallet();
		machineWalletService = new MachineWalletService(machine, machineWallet, RANDOM_BOX);

	}

	@Test
	void 머신_보유금액_저장하기() {
		int machineAmount = 100000;
		machineWalletService.save(machineAmount);

		String[] coinSet = machineWallet.toString().replaceAll("[^0-9-개]", "").split("개");
		int total = 0;
		for (String pair : coinSet) {
			String[] coin = pair.split("-");
			total += Integer.parseInt(coin[0]) * Integer.parseInt(coin[1]);
		}
		assertEquals(total, machineAmount);
	}

	@Test
	void 머신_보유금액_잔돈으로_바꾸기_금액일치() {
		int machineAmount = 10000;
		int customerAmount = 10000;
		assertEquals(getTotalChanges(machineAmount, customerAmount), Math.min(machineAmount, customerAmount));
	}

	@Test
	void 머신_보유금액_잔돈으로_바꾸기_잔돈부족() {
		int machineAmount = 100;
		int customerAmount = 10000;
		assertEquals(getTotalChanges(machineAmount, customerAmount), Math.min(machineAmount, customerAmount));
	}

	@Test
	void 머신_보유금액_잔돈으로_바꾸기_잔돈넘침() {
		int machineAmount = 10000;
		int customerAmount = 100;
		assertEquals(getTotalChanges(machineAmount, customerAmount), Math.min(machineAmount, customerAmount));
	}

	private int getTotalChanges(int machineAmount, int customerAmount) {
		machineWalletService.save(machineAmount);
		machine.save(customerAmount);
		Map<Integer, Integer> changes = machineWalletService.getChanges();
		int totalChanges = 0;
		for (int coin : changes.keySet()) {
			totalChanges += coin * changes.get(coin);
		}
		return totalChanges;
	}

	@Test
	void 머신_보유금액_상태_출력하기() {
		System.out.println(machineWalletService.getMachineWalletStatus());
		String status = machineWalletService.getMachineWalletStatus();

		COIN_LIST.stream().forEach(
			c -> assertEquals(status.contains(c + "원"), true)
		);
	}
}