package vendingmachine;

import camp.nextstep.edu.missionutils.test.NsTest;
import vendingmachine.domain.CoinStorage;
import vendingmachine.enums.Coin;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInListTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumMap;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final int MONEY = 510;
    private static final int COIN = 500;
    private static final int REMAIN_MONEY = 450;

    // @Test
    void 기능_테스트() {
        assertRandomNumberInListTest(
            () -> {
                run("450", "[콜라,1500,20];[사이다,1000,10]", "3000", "콜라", "사이다");
                assertThat(output()).contains(
                    "자판기가 보유한 동전", "500원 - 0개", "100원 - 4개", "50원 - 1개", "10원 - 0개",
                    "투입 금액: 3000원", "투입 금액: 1500원"
                );
            },
            100, 100, 100, 100, 50
        );
    }

    // @Test
    void 예외_테스트() {
        assertSimpleTest(
            () -> {
                runException("-1");
                assertThat(output()).contains(ERROR_MESSAGE);
            }
        );
    }

    // @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

    // @Test
    CoinStorage 동전을_랜덤으로_생성한다() {
        CoinStorage coinStorage = new CoinStorage(MONEY);
        System.out.println("자판기 동전 목록");
        System.out.println(coinStorage.toString());
        return coinStorage;
    }

    // @Test
    void 나누기를_테스트한다() {
        int maxQuantity = MONEY / COIN;
        System.out.println("maxQuantity : " + maxQuantity);
    }

    @Test
    void 잔돈을_받는다() {
        CoinStorage coinStorage = 동전을_랜덤으로_생성한다();
        EnumMap<Coin, Integer> map = coinStorage.getChange(REMAIN_MONEY);
        System.out.println("잔돈 동전 목록");
        System.out.println(map.toString());
    }
}
