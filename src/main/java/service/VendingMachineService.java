package service;

import java.util.List;

import dto.CoinsResponseDto;
import dto.HoldingSumRequestDto;
import dto.MoneyRequestDto;
import dto.MoneyResponseDto;
import dto.ProductNameRequestDto;
import dto.ProductsRequestDto;
import vendingmachine.CoinChanger;
import vendingmachine.Coins;
import vendingmachine.Money;
import vendingmachine.Products;

public class VendingMachineService {
    private Money money;
    private Products products;
    private Coins coins;
    public CoinsResponseDto changeHoldingSumToCoins(HoldingSumRequestDto holdingSumRequestDto) {
        int holdingSum = holdingSumRequestDto.getHoldingSum();
        CoinChanger coinChanger = new CoinChanger(holdingSum);
        coins = new Coins(coinChanger.changeToCoin());
        return coins.toCoinsResponseDto();
    }

    public void saveProductsInfo(ProductsRequestDto productsRequestDto) {
        products = new Products(productsRequestDto.getProducts());
    }

    public void saveMoney(MoneyRequestDto moneyRequestDto) {
        money = new Money(moneyRequestDto.getMoney());
    }

    public MoneyResponseDto conveyCurrentMoney() {
        return money.toMoneyResponseDto();
    }

    public void purchaseProduct(ProductNameRequestDto productNameRequestDto) {
        String productName = productNameRequestDto.getProductName();
        money.subtract(products.purchase(productName));
    }

    public boolean isEnd() {
        return products.noStock() || money.noMoney(products.minimumPrice());
    }

    public CoinsResponseDto calculateChange() {
        return coins.calculateChanges(money.getMoney());
    }
}
