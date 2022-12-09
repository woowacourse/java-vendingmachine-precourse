package vendingmachine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import vendingmachine.Constant.Coin;
import vendingmachine.Domain.Change;
import vendingmachine.Util.Caster;
import vendingmachine.Util.View;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static vendingmachine.Constant.Error.*;

public class ChangesTest {

    private Caster cast = new Caster();
    private View view = new View();

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void outputSetUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @ParameterizedTest
    @ValueSource(ints = {450, 20000, 100000, 7777770})
    @DisplayName("입력한 자판기보유금액 정합성")
    void checkAmount(int money) {
        Change change = cast.toChangeCoins(money);
        LinkedHashMap<Coin, Integer> units = change.getCoins();

        int sum = getCoinSum(units);
        assertThat(money).isEqualTo(sum);
    }

    int getCoinSum(LinkedHashMap<Coin, Integer> coins) {
        int sum = 0;
        for (Coin coin : coins.keySet()) {
            sum += coins.get(coin) * coin.getAmount();
        }
        return sum;
    }


    @ParameterizedTest
    @ValueSource(strings = {"천원", "2천원", "20000원"})
    @DisplayName("자판기 보유금액 입력시 숫자를 입력하지 않았을때")
    void invalidMoneyValue(String invalidInput) {
        outputSetUp();
        try {
            systemIn(invalidInput);
            view.getInitChanges();
        } catch (NoSuchElementException e) {
            assertThat(getOutput()).contains(INPUT_ALLOWED_ONLY_NUMBER.toMessage());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"201", "202", "203", "204", "205", "206", "207", "208", "209"})
    @DisplayName("1원단위의 입력")
    void invalidMoneyNotDividedByTen(String invalidInput) {
        try {
            systemIn(invalidInput);
            view.getInitChanges();
        } catch (NoSuchElementException e) {
            assertThat(getOutput()).contains(NOT_ALLOWED_SINGLE_DIGIT.toMessage());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-450", "-701"})
    @DisplayName("0원 이하의 금액 입력")
    void invalidMoneyUnder0(String invalidInput) {
        try {
            systemIn(invalidInput);
            view.getInitChanges();
        } catch (NoSuchElementException e) {
            assertThat(getOutput()).contains(NOT_ALLOWED_MINUS_NUMBER.toMessage());
        }
    }

    void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    String getOutput() {
        return outputStream.toString();
    }


}


