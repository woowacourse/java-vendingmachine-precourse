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
		Long id = machineService.generate();
		Machine machine = machineService.findById(id);
		machineService.addCoins(id, 450);
		Map<Coin, Integer> coins = machine.getCoins();
		int totalAmount = 0;
		for (Coin coin : coins.keySet()) {
			totalAmount += coin.getAmount() * coins.get(coin);
		}
		Assertions.assertThat(totalAmount).isEqualTo(450);
	}

	@Test
	void 자판기_동전반환_투입금액이_더_많을때() {
		Long id = machineService.generate();
		machineService.addCoins(id, 450);
		machineService.addInputCoins(id, 1000);
		Map<Coin, Integer> coins = machineService.returnCoins(id);
		int totalAmount = 0;
		for (Coin coin : coins.keySet()) {
			totalAmount += coin.getAmount() * coins.get(coin);
		}
		Assertions.assertThat(totalAmount).isEqualTo(450);
	}

	@Test
	void 자판기_동전반환_투입금액이_더_적을때() {
		Long id = machineService.generate();
		machineService.addCoins(id, 1000);
		machineService.addInputCoins(id, 450);
		Map<Coin, Integer> coins = machineService.returnCoins(id);
		int totalAmount = 0;
		for (Coin coin : coins.keySet()) {
			totalAmount += coin.getAmount() * coins.get(coin);
		}
		Assertions.assertThat(totalAmount).isEqualTo(450);
	}
}