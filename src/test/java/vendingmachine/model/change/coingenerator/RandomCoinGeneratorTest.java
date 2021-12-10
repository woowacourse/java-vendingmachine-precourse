package vendingmachine.model.change.coingenerator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vendingmachine.model.change.vo.Coin;

class RandomCoinGeneratorTest {
    @Test
    @DisplayName("돈을 받아 값에 맞춰 500, 100, 50, 10 원 동전들을 랜덤으로 생성한다.")
    void generate() {
        int moneyToGenerate = 3000;
        CoinGenerator coinGenerator = new RandomCoinGenerator(moneyToGenerate);
        Map<Coin, Integer> numbersByCoin = coinGenerator.generate();
        int sum = numbersByCoin.keySet().stream()
                .mapToInt(coin -> coin.getAmount() * numbersByCoin.get(coin))
                .sum();
        assertThat(sum).isEqualTo(moneyToGenerate);
    }

}