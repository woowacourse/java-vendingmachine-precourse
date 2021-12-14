package vendingmachine.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import vendingmachine.utils.Util;

public class VendingMachine {
	private static final VendingMachine vendingMachine = new VendingMachine();
	private Money machineMoney;
	private Money userMoney;
	private Products products;
	private CoinCounter machineCoinCounter;
	private ProductCounter productCounter;

	private VendingMachine() {
	}

	public static VendingMachine getInstance() {
		return vendingMachine;
	}

	public void init() {
		this.machineMoney = null;
		this.userMoney = null;
		this.products = null;
		this.machineCoinCounter = new CoinCounter();
		this.productCounter = new ProductCounter();
	}

	public void insertMachineMoney(Money machineMoney) {
		this.machineMoney = machineMoney;
	}

	public String generateCoins() {
		int fisrtInsertedAmount = this.machineMoney.toInt();

		boolean canExchange = this.machineMoney.toInt() >= 10;

		while (canExchange) {
			int pickRangdomCoin = Util.pickRandomCoin(makeCoinKinds());
			if (!(this.machineMoney.toInt() >= pickRangdomCoin
				&& pickRangdomCoin != fisrtInsertedAmount
			)) {
				continue;
			}
			this.machineMoney.decreaseWith(pickRangdomCoin);
			this.machineCoinCounter.plusCount(Coin.findByAmount(pickRangdomCoin));

			canExchange = this.machineMoney.toInt() >= 10;
		}

		return this.machineCoinCounter.toString();
	}

	private List<Integer> makeCoinKinds() {
		return Arrays.stream(Coin.values())
			.mapToInt(Coin::toAmount)
			.boxed()
			.collect(Collectors.toList());
	}

	public void insertProducts(Products products) {
		this.products = products;
		this.productCounter.plusCountFromList(this.products.toList());
	}

	public void insertUserMoney(Money userMoney) {
		this.userMoney = userMoney;
	}

	public Product findProductByName(String inputValue) {
		return this.products.findProductByName(inputValue);
	}

	public void sale(Name wantedProductName) {
		//1. 일단은 일부정보(name) -> 객체를찾아야함.
		Product product = this.products.findProductByName(wantedProductName.toString());
		//2.[ db속 존재유무 & 1개이상 유무 & 사용자돈은 충분한상태] 3가지가 이미 검증이 된 체로왔음.(반복에서 입력시마다 검증함)
		// 구매로직 1) 사용자 돈을 깍고, 2) 상품 갯수 1개를 내린다.
		this.userMoney.decreaseWith(product.toAmount());
		this.productCounter.minusCount(product);
	}

	public boolean isProductAvailable(Product product) {
		return this.productCounter.isAvailable(product);
	}

	public boolean isUserPurchasable(Product product) {
		return this.userMoney.isOrGreaterThan(product);

	}

	public boolean canSale() {
		boolean isValidUserMoney = this.userMoney.toInt() >= this.products.findMinAmount();
		boolean anyProductAvailable = this.productCounter.isAnyAvailable();
		return isValidUserMoney && anyProductAvailable;
	}

	public int toCurrentUserMoney() {
		return this.userMoney.toInt();
	}

	public String returnCoins() {
		// 유저머니가 <= 0이 되기전까지.. 큰 순서대로 동전을 빼면서, 차감해준다.
		// 돌리는 조건(0) : 유저돈 > 1이상, --> 최소동전인 >= 10 이상.
		// -> (1) 잔돈반환 못하는경우 = 동전갯수가 0개..  -> 잔돈반환끝낸다.
		// ---> 돌리는 조건 + 끝내는 조건을 합쳐서 사용함. 이 때, isAnyAvailable 재활용된다(동전갯수 1개이상 1개라도..있음 가능)
		// -> (2) 그리디: 것부터 미리 넣어놔서 forEach로 꺼내기만 하면 된다.
		// -> (3) 반환되지 않은 금액은, 자판기 보유금액인 machineMoney에 남겨둔다.
		// boolean isReturnable = isReturnable();// > 0;

		// + 반환받을 결과값용 map객체 생성
		CoinCounter userReturnCoinCounter = new CoinCounter();

		// System.out.println("반환전 : " + this.machineCoinCounter); // 로그

		// while (isReturnable) {
		this.machineCoinCounter.forEach((coin, count) -> {
			//(1) 코인당 1~count까지 가진 갯수만큼 반복하면서  머신-1, 사용자 받아갈 map +1 해준다.
			// -> 이 때, [[[모든 로직을 if에 담아서 , 가능할때까지만 로직이 돌아가도록 하게 함.]]]
			IntStream.rangeClosed(1, count)
				.forEach(i -> {
					//[[[ 최대횟수만큼 돌리되, if안에 다 넣엇, 가능한 경우까지만 알아서 돌다가 멈춤]]]
					int coinAmount = coin.toAmount();
					if (isReturnable()) {
						this.userMoney.decreaseWith(coinAmount);
						this.machineCoinCounter.minusCount(coin);

						userReturnCoinCounter.plusCount(coin);
					}
				});
		});

		// System.out.println("반환후 : " + this.machineCoinCounter); // 로그
		// 	isReturnable = isReturnable();
		// }

		// 남은 금액은 machineMoney 에 넣기
		this.machineMoney.increaseWith(this.userMoney.toInt());

		// 반환용 결과값 반환
		// 예외처리 -> 잔돈이 없는 경우 -> 결과값Map이 모두 count가 0인 경우 ->
		if (!userReturnCoinCounter.isAnyAvailable()) {
			return "";
		}
		// 반환된 동전만 출력 -> toString에서 filter걸기.
		return userReturnCoinCounter.toReturnCoinString();

	}

	private boolean isReturnable() {
		return this.userMoney.toInt() >= 10 && this.machineCoinCounter.isAnyAvailable();
	}
}
