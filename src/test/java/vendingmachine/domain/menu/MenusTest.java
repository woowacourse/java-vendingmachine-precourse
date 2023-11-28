package vendingmachine.domain.menu;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class MenusTest {
    Menus menus = new Menus(List.of(
            Menu.from("[콜라,1500,1]"),
            Menu.from("[사이다,1000,2]")
    ));

    @Nested
    @DisplayName("객체 생성 테스트")
    class 객체_생성_테스트 {

        @Test
        @DisplayName("중복 메뉴 입력시 예외가 발생한다.")
        void duplicatedMenu(){
            Assertions.assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Menus(List.of(
                            Menu.from("콜라,1000,5"),
                            Menu.from("콜라,1200,1")
                    )));
        }

        @Test
        @DisplayName("빈 메뉴 입력시 예외가 발생한다.")
        void emptyMenu(){
            Assertions.assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Menus(List.of()));
        }
    }
}