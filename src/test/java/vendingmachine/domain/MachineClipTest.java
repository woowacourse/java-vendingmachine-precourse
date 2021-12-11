package vendingmachine.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;

class MachineClipTest extends NsTest {

	private MachineWallet machineClip;
	private RandomBox randomBox;

	@BeforeEach
	void beforeEach() {
		machineClip = new MachineWallet();
		randomBox = RandomBox.RANDOM_BOX;
	}

	@Test
	void 머신_동전상태_출력_테스트() {
		machineClip.save(randomBox.getCoins(100));
		System.out.println(machineClip.toString());
		assertThat(output()).contains("10원", "50원", "100원", "500원");
	}

	@Test
	void 머신_잔돈반환_테스트_잔돈일치() {
		machineClip.save(randomBox.getCoins(1000));
		assertEquals(getAmountOfChangesSum(1000), 1000);
	}

	@Test
	void 머신_잔돈반환_테스트_잔돈부족() {
		machineClip.save(randomBox.getCoins(500));
		assertEquals(getAmountOfChangesSum(1000), 500);
	}

	@Test
	void 머신_잔돈반환_테스트_잔돈많음() {
		machineClip.save(randomBox.getCoins(1500));
		assertEquals(getAmountOfChangesSum(1000), 1000);
	}

	private int getAmountOfChangesSum(int amount) {
		Map<Integer, Integer> amountToChanges = machineClip.saveChangesByAmount(amount);
		return amountToChanges.keySet().stream().mapToInt(k -> k * amountToChanges.get(k)).sum();
	}

	@Override
	protected void runMain() {

	}

}