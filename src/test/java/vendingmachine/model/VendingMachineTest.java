package vendingmachine.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import vendingmachine.dto.InputItemDTO;

class VendingMachineTest {
    @Test
    @DisplayName("사용자 희망 상품을 팔고, 남은 투입 금액을 반환한다.")
    void sell_getRemainingInputMoney() {
        InputItemDTO waterDTO = new InputItemDTO(Arrays.asList("물", "1000", "4"));
        InputItemDTO cokeDTO = new InputItemDTO(Arrays.asList("콜라", "2000", "4"));
        List<InputItemDTO> itemInfos = Arrays.asList(waterDTO, cokeDTO);
        String inputMoney = "6000";
        VendingMachine vendingMachine = new VendingMachine(inputMoney, itemInfos);
        String userWantedItemName = "콜라";
        vendingMachine.sell(userWantedItemName);
        int actual = vendingMachine.getRemainingInputMoney();
        int expected = 4000;
        assertThat(actual).isEqualTo(expected);
    }
}
