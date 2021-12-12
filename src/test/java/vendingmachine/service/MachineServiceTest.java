package vendingmachine.service;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Machine;

class MachineServiceTest {
	private final MachineService machineService = new MachineService();

	@Test
	void 자판기_동전생성_정상입력() {
		Machine machine = new Machine();
		machineService.addCoins(machine, 450);
		Map<Coin, Integer> coins = machine.getCoins();
		int totalAmount = 0;
		for (Coin coin : coins.keySet()) {
			totalAmount += coin.getAmount() * coins.get(coin);
		}
		Assertions.assertThat(totalAmount).isEqualTo(450);
	}

	@Test
	void 자판기_동전반환_투입금액이_더_많을때() {
		Machine machine = new Machine();
		machineService.addCoins(machine, 450);
		machineService.addInputCoins(machine, 1000);
		Map<Coin, Integer> coins = machineService.returnCoins(machine);
		int totalAmount = 0;
		for (Coin coin : coins.keySet()) {
			totalAmount += coin.getAmount() * coins.get(coin);
		}
		Assertions.assertThat(totalAmount).isEqualTo(450);
	}

	@Test
	void 자판기_동전반환_투입금액이_더_적을때() {
		Machine machine = new Machine();
		machineService.addCoins(machine, 1000);
		machineService.addInputCoins(machine, 450);
		Map<Coin, Integer> coins = machineService.returnCoins(machine);
		int totalAmount = 0;
		for (Coin coin : coins.keySet()) {
			totalAmount += coin.getAmount() * coins.get(coin);
		}
		Assertions.assertThat(totalAmount).isEqualTo(450);
	}
}