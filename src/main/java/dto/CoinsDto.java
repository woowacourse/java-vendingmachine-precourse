package dto;

import domain.Coin;

import java.util.Map;

public class CoinsDto {
	int coin500Quantity;
	int coin100Quantity;
	int coin50Quantity;
	int coin10Quantity;

	private CoinsDto(int coin500Quantity, int coin100Quantity, int coin50Quantity, int coin10Quantity) {
		this.coin500Quantity = coin500Quantity;
		this.coin100Quantity = coin100Quantity;
		this.coin50Quantity = coin50Quantity;
		this.coin10Quantity = coin10Quantity;
	}

	public static CoinsDto from(Map<Coin, Integer> coins) {
		return new CoinsDto(
			coins.get(Coin.COIN_500),
			coins.get(Coin.COIN_100),
			coins.get(Coin.COIN_50),
			coins.get(Coin.COIN_10)
		);
	}

	public int getCoin500Quantity() {
		return coin500Quantity;
	}

	public int getCoin100Quantity() {
		return coin100Quantity;
	}

	public int getCoin50Quantity() {
		return coin50Quantity;
	}

	public int getCoin10Quantity() {
		return coin10Quantity;
	}

	public int getAllCoinQuantity() {
		return coin500Quantity + coin100Quantity + coin50Quantity + coin10Quantity;
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(coin500Quantity + "," + coin100Quantity + "," + coin50Quantity + "," + coin10Quantity);
		return sb.toString();
	}
}
