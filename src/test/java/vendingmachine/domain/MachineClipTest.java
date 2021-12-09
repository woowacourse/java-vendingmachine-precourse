package vendingmachine.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MachineClipTest{

	private MachineClip machineClip;
	private RandomBox randomBox;
	private PrintStream standardOut;
	private OutputStream captor;

	@BeforeEach
	void beforeEach(){
		machineClip = MachineClip.MACHINE_CLIP;
		randomBox = RandomBox.RANDOM_COIN_BOX;

		standardOut = System.out;
		captor = new ByteArrayOutputStream();
		System.setOut(new PrintStream(captor));
	}

	@AfterEach
	void afterEach() {
		System.setOut(standardOut);
		System.out.println(output());
	}

	@Test
	void 머신_동전상태_출력_테스트(){
		machineClip.initMachine(randomBox.getNumOfCoins(100));
		System.out.println(machineClip.toString());
		assertEquals(output().contains("10원"), true);
		assertEquals(output().contains("50원"), true);
		assertEquals(output().contains("100원"), true);
		assertEquals(output().contains("500원"), true);
	}

	@Test
	void 거스름돈_출력_테스트(){
		machineClip.initMachine(randomBox.getNumOfCoins(10));
		machineClip.getAmountToChanges(10);
		assertEquals(output().contains("10원 - 1개"), true);
	}



	private String output() {
		return captor.toString().trim();
	}

}