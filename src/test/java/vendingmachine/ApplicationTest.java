package vendingmachine;

import camp.nextstep.edu.missionutils.test.NsTest;
import vendingmachine.model.item.domain.Item;
import vendingmachine.model.item.service.ItemParser;
import vendingmachine.model.cash.domain.Coin;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInListTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
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

    @Test
    void 예외_테스트() {
        assertSimpleTest(
            () -> {
                runException("-1");
                assertThat(output()).contains(ERROR_MESSAGE);
            }
        );
    }

    @Test
    void 값으로_코인_찾기_테스트() {
        assertThat(Coin.findByAmount(500)).isEqualTo(Coin.COIN_500);
    }

    @Test
    void 아이템_목록_생성_테스트() {
        ItemParser itemParser = new ItemParser();
        List<Item> items = itemParser.listFrom("[콜라,1000,10];[사이다,1200,15]");
        assertThat(items.get(0).isName("콜라")).isTrue();
    }

    @Test
    void 상품_목록_형식_검사_테스트() {
        ItemParser itemParser = new ItemParser();
        assertThrows(IllegalArgumentException.class, () -> itemParser.listFrom("[콜라,1000,1"));
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
