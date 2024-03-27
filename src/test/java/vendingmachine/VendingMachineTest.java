package vendingmachine;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import vendingmachine.domain.Product;

import java.io.ByteArrayInputStream;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class VendingMachineTest {
    @Test
    void 사용자로부터_정상적인_보유_금액_입력받기 () {
        // given
        int inputMoney = 500;
        System.setIn(new ByteArrayInputStream(Integer.toString(inputMoney).getBytes()));
        VendingMachine vendingMachine = new VendingMachine();
        // when
        vendingMachine.inputInitialMoney();
        // then
        assertThat(vendingMachine.getCurrentChange()).isEqualTo(inputMoney);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "111"})
    void 사용자로부터_비정상적인_보유_금액_입력받기(String inputString) {
        // given
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        VendingMachine vendingMachine = new VendingMachine();
        // when, then
        assertThrows(IllegalArgumentException.class, vendingMachine::inputInitialMoney);
    }

    @Test
    void 동전_무작위생성() {
        // given
        VendingMachine vendingMachine = new VendingMachine();
        int initialMoneyInputValue = 450;
        System.setIn(new ByteArrayInputStream(Integer.toString(initialMoneyInputValue).getBytes()));
        vendingMachine.inputInitialMoney();
        // when
        vendingMachine.generateInitialCoins();
        //then
        int sumOfCoins = vendingMachine.getCoins().getSumOfCoins();
        int currentMoney = vendingMachine.getCurrentChange();
        assertThat(sumOfCoins).isEqualTo(currentMoney);
    }

    @Test
    void 사용자로부터_상품목록_입력받기() {
        // given
        VendingMachine vendingMachine = new VendingMachine();
        String inputString = "[콜라,1500,20];[사이다,1000,10]";
        Set<Product> correctProducts = new HashSet<Product>();
        correctProducts.add(new Product("콜라", 1500, 20));
        correctProducts.add(new Product("사이다", 1000, 10));
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        // when
        vendingMachine.inputProducts();
        Set<Product> generatedProducts = vendingMachine.getProducts();
        // then
        assertThat(generatedProducts.size()).isEqualTo(2);  // 여기 질문!
    }

    @Test
    void 사용자로부터_투입_금액_입력받기() {
        // given
        VendingMachine vendingMachine = new VendingMachine();
        String inputString = "3000";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        // when
        vendingMachine.inputUsersMoney();
        // then
        assertThat(vendingMachine.getCurrentUsersMoney()).isEqualTo(Integer.parseInt(inputString));
    }

    @Test
    void 사용자가_입력한_구매할_상품_가격에_맞춰_잔여투입금액_값_업데이트_정상입력() {
        // given
        VendingMachine vendingMachine = new VendingMachine();
        System.setIn(new ByteArrayInputStream("[콜라,1500,20]".getBytes()));
        vendingMachine.inputProducts();
        System.setIn(new ByteArrayInputStream("10000".getBytes()));
        vendingMachine.inputUsersMoney();
        String inputString = "콜라";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        int correctResult = 8500;
        // when
        vendingMachine.buyProduct();
        // then
        assertThat(vendingMachine.getCurrentUsersMoney()).isEqualTo(correctResult);
    }

    @Test
    void 사용자가_입력한_구매할_상품_가격에_맞춰_잔여투입금액_값_업데이트_존재하지않는상품() {
        // given
        VendingMachine vendingMachine = new VendingMachine();
        System.setIn(new ByteArrayInputStream("[콜라,1500,20]".getBytes()));
        vendingMachine.inputProducts();
        System.setIn(new ByteArrayInputStream("10000".getBytes()));
        vendingMachine.inputUsersMoney();
        String inputString = "닥터페퍼";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        // when, then
        assertThrows(IllegalArgumentException.class, vendingMachine::buyProduct);
    }

    @Test
    void 사용자가_입력한_구매할_상품_가격에_맞춰_잔여투입금액_값_업데이트_너무비싼상품() {
        // given
        VendingMachine vendingMachine = new VendingMachine();
        System.setIn(new ByteArrayInputStream("[콜라,1500,20]".getBytes()));
        vendingMachine.inputProducts();
        System.setIn(new ByteArrayInputStream("500".getBytes()));
        vendingMachine.inputUsersMoney();
        String inputString = "콜라";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        // when, then
        assertThrows(IllegalArgumentException.class, vendingMachine::buyProduct);
    }

    @Test
    void 사용자가_입력한_구매할_상품_가격에_맞춰_잔여투입금액_값_업데이트_소진된상품() {
        // given
        VendingMachine vendingMachine = new VendingMachine();
        System.setIn(new ByteArrayInputStream("[콜라,1500,0]".getBytes()));
        vendingMachine.inputProducts();
        System.setIn(new ByteArrayInputStream("500".getBytes()));
        vendingMachine.inputUsersMoney();
        String inputString = "콜라";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        // when, then
        assertThrows(IllegalArgumentException.class, vendingMachine::buyProduct);
    }
}