package vendingmachine.dto;

import vendingmachine.domain.coin.Coin;
import vendingmachine.domain.coins.Coins;

// TODO: 장황한 변수 선언과 사용을 개선할 방법이 있을지 고민 필요
public class CoinsOutputDto {
	int coin500Amount = 0;
	int coin100Amount = 0;
	int coin50Amount = 0;
	int coin10Amount = 0;

	private CoinsOutputDto(int coin500Amount, int coin100Amount, int coin50Amount, int coin10Amount) {
		this.coin500Amount = coin500Amount;
		this.coin100Amount = coin100Amount;
		this.coin50Amount = coin50Amount;
		this.coin10Amount = coin10Amount;
	}

	public static CoinsOutputDto from(Coins coins) {
		return new CoinsOutputDto(
			coins.getCoinAmount(Coin.COIN_500).toInt(),
			coins.getCoinAmount(Coin.COIN_100).toInt(),
			coins.getCoinAmount(Coin.COIN_50).toInt(),
			coins.getCoinAmount(Coin.COIN_10).toInt()
		);
	}

	public int getCoin500Amount() {
		return this.coin500Amount;
	}

	public int getCoin100Amount() {
		return this.coin100Amount;
	}

	public int getCoin50Amount() {
		return this.coin50Amount;
	}

	public int getCoin10Amount() {
		return this.coin10Amount;
	}
}
