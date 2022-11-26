package service;

import dto.CoinsResponseDto;
import dto.HoldingSumRequestDto;
import vendingmachine.CoinChanger;
import vendingmachine.Coins;

public class VendingMachineService {

    public CoinsResponseDto changeHoldingSumToCoins(HoldingSumRequestDto holdingSumRequestDto) {
        int holdingSum = holdingSumRequestDto.getHoldingSum();
        CoinChanger coinChanger = new CoinChanger(holdingSum);
        Coins coins = new Coins(coinChanger.changeToCoin());
        return coins.toCoinsResponseDto();
    }
}
