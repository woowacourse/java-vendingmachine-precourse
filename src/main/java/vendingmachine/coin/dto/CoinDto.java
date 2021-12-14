package vendingmachine.coin.dto;

public class CoinDto {

    private Integer coinAmount;
    private Integer count;

    public CoinDto(Integer coinAmount, Integer count) {
        this.coinAmount = coinAmount;
        this.count = count;
    }

    public Integer getCoinAmount() {
        return coinAmount;
    }

    public Integer getCount() {
        return count;
    }
}