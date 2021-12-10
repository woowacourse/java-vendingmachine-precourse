package vendingmachine.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;

class MachineClipTest extends NsTest {

	private MachineClip machineClip;
	private RandomBox randomBox;

	@BeforeEach
	void beforeEach(){
		machineClip = MachineClip.MACHINE_CLIP;
		randomBox = RandomBox.RANDOM_COIN_BOX;
	}

	@Test
	void 머신_동전상태_출력_테스트(){
		machineClip = machineClip.createMachineClip(randomBox.getNumOfCoins(100));
		System.out.println(machineClip.toString());
		assertThat(output()).contains("10원", "50원", "100원", "500원");
	}

	@Test
	void 머신_잔돈반환_테스트_잔돈일치(){
		machineClip = machineClip.createMachineClip(randomBox.getNumOfCoins(1000));
		assertEquals(getAmountOfChangesSum(1000), 1000);
	}

	// 기능테스트와 충돌
	// @Test
	// void 머신_잔돈반환_테스트_잔돈부족(){
	// 	machineClip = machineClip.createMachineClip(randomBox.getNumOfCoins(500));
	// 	assertEquals(getAmountOfChangesSum(1000), 500);
	// }
	//
	// @Test
	// void 머신_잔돈반환_테스트_잔돈많음(){
	// 	machineClip = machineClip.createMachineClip(randomBox.getNumOfCoins(1500));
	// 	assertEquals(getAmountOfChangesSum(1000), 1000);
	// }

	private int getAmountOfChangesSum(int amount) {
		Map<Integer, Integer> amountToChanges = machineClip.getAmountToChanges(amount);
		return amountToChanges.keySet().stream().mapToInt(k -> k * amountToChanges.get(k)).sum();
	}

	@Override
	protected void runMain() {

	}

}