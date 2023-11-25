package service;

import domain.Coin;
import domain.CoinCountGenerator;
import domain.VendingMachine;
import dto.VendingMachineStatusDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class VendingMachineServiceTest {

    @Test
    void generateRandomCoins_ShouldGenerateRandomCoins() {
        VendingMachine vendingMachine = new VendingMachine();
        CoinCountGenerator coinCountGenerator = new CoinCountGenerator();
        VendingMachineService vendingMachineService = new VendingMachineService(vendingMachine, coinCountGenerator);

        int userAmount = 450;
        List<VendingMachineStatusDto> result = vendingMachineService.generateRandomCoins(userAmount);

        assertEquals(4, result.size());

        int totalAmount = 0;
        for (VendingMachineStatusDto status : result) {
            totalAmount += status.getCoin() * status.getCount();
        }

        // 생성된 동전의 총 금액이 사용자가 입력한 금액과 일치하는지 확인
        assertEquals(userAmount, totalAmount);
    }


}
