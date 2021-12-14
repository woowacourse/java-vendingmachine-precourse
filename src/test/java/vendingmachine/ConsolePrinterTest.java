package vendingmachine;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vendingmachine.domain.Changes;
import vendingmachine.domain.Coin;
import vendingmachine.domain.HoldingAmount;
import vendingmachine.domain.InputAmount;
import vendingmachine.io.ConsolePrinter;

public class ConsolePrinterTest {

    ByteArrayOutputStream capture;
    PrintStream sysout;

    @BeforeEach
    void setUp() {
        sysout = System.out;
        capture = new ByteArrayOutputStream();
        System.setOut(new PrintStream(capture));
    }

    @AfterEach
    void tearDown() {
        System.setOut(sysout);
    }

    String out() {
        return capture.toString();
    }

    @Test
    void returnChangeTest() {
        Map<Coin, Integer> testCase = new HashMap<Coin, Integer>() {{
            put(Coin.COIN_500, 1);
            put(Coin.COIN_100, 3);
        }};
        ConsolePrinter printer = new ConsolePrinter();
        printer.printChanges(new Changes(testCase));
        assertThat(out()).isEqualTo(
            "잔돈\n500원 - 1개\n100원 - 3개\n"
        );
    }

    @Test
    void emptyChangeTest() {
        ConsolePrinter printer = new ConsolePrinter();
        printer.printChanges(new Changes(new HashMap<>()));
        assertThat(out()).isEqualTo(
            "잔돈\n"
        );
    }

    @Test
    void extremeCountTest() {
        Map<Coin, Integer> testCase = new HashMap<Coin, Integer>() {{
            put(Coin.COIN_500, Integer.MAX_VALUE);
        }};
        ConsolePrinter printer = new ConsolePrinter();
        printer.printChanges(new Changes(testCase));
        assertThat(out()).isEqualTo(
            "잔돈\n500원 - " + Integer.MAX_VALUE + "개\n"
        );
    }

    @Test
    void holdingAmountTest() {
        ConsolePrinter printer = new ConsolePrinter();
        HoldingAmount holdingAmount = mock(HoldingAmount.class);
        when(holdingAmount.getHoldingCoinCount(any())).thenReturn(1);
        printer.printHoldingAmount(holdingAmount);
        assertThat(out()).contains("자판기가 보유한 동전", "500원 - 1개", "100원 - 1개", "50원 - 1개", "10원 - 1개");
    }

    @Test
    void inputAmountTest() {
        final int amount = 1000;
        ConsolePrinter printer = new ConsolePrinter();
        InputAmount inputAmount = mock(InputAmount.class);
        when(inputAmount.getLocalCurrency()).thenReturn("1000원");
        printer.printInputAmount(inputAmount);
        assertThat(out()).contains("투입 금액: " + amount);
    }
}
