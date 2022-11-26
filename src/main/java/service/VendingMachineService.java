package service;

import java.util.List;

import dto.CoinsResponseDto;
import dto.HoldingSumRequestDto;
import dto.ProductsRequestDto;
import vendingmachine.CoinChanger;
import vendingmachine.Coins;
import vendingmachine.Products;

public class VendingMachineService {

    public CoinsResponseDto changeHoldingSumToCoins(HoldingSumRequestDto holdingSumRequestDto) {
        int holdingSum = holdingSumRequestDto.getHoldingSum();
        CoinChanger coinChanger = new CoinChanger(holdingSum);
        Coins coins = new Coins(coinChanger.changeToCoin());
        return coins.toCoinsResponseDto();
    }

    public void saveProductsInfo(ProductsRequestDto productsRequestDto) {
        Products products = new Products(productsRequestDto.getProducts());

    }
}
