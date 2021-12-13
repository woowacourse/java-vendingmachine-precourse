package vendingmachine.service;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInList;

import java.util.List;

import vendingmachine.domain.Change;
import vendingmachine.domain.CoinRepository;
import vendingmachine.domain.Money;
import vendingmachine.domain.MoneyRepository;
import vendingmachine.domain.Name;
import vendingmachine.domain.Product;
import vendingmachine.domain.ProductRepository;
import vendingmachine.domain.Products;
import vendingmachine.domain.Quantity;
import vendingmachine.dto.RequestHoldingMoneyDto;
import vendingmachine.dto.RequestInsertMoneyDto;
import vendingmachine.dto.RequestRegisterProductsDto;
import vendingmachine.dto.RequestSellProductDto;
import vendingmachine.dto.ResponseAllCoinQuantityDto;
import vendingmachine.dto.ResponseChangeDto;
import vendingmachine.dto.ResponseMoneyDto;
import vendingmachine.enums.Coin;

public class VendingMachineService {
	public VendingMachineService() {
	}

	public void initCoinRepository(RequestHoldingMoneyDto requestHoldingMoneyDto) {
		int money = requestHoldingMoneyDto.getMoney().get();
		List<Integer> amounts = Coin.getAmounts();
		while (money > 0) {
			int randomAmount = pickNumberInList(amounts);
			if (randomAmount <= money) {
				money -= randomAmount;
				CoinRepository.addOneQuantityByAmount(randomAmount);
			}
		}
	}

	public ResponseAllCoinQuantityDto getAllCoinQuantity() {
		return new ResponseAllCoinQuantityDto(CoinRepository.findAll());
	}

	public void registerProducts(RequestRegisterProductsDto requestHoldingMoneyDto) {
		Products products = requestHoldingMoneyDto.getProducts();
		products.save();
	}

	public void insertMoney(RequestInsertMoneyDto requestInsertMoneyDto) {
		Money money = requestInsertMoneyDto.getMoney();
		MoneyRepository.add(money);
	}

	public ResponseMoneyDto findMoney() {
		Money money = MoneyRepository.get();
		return new ResponseMoneyDto(money);
	}

	public void sellProduct(RequestSellProductDto requestSellProductDto) {
		Name name = requestSellProductDto.getName();
		Product product = ProductRepository.findByName(name);
		product.sell();
	}

	public boolean canSell() {
		return ProductRepository.canSell();
	}

	public ResponseChangeDto returnChange() {
		Change change = new Change();
		for (Coin coin : Coin.values()) {
			Quantity changeQuantity = getChangeQuantity(coin);
			change.put(coin, changeQuantity);
			settleCoinAndMoney(coin, changeQuantity);
		}
		return new ResponseChangeDto(change);
	}

	private Quantity getChangeQuantity(Coin coin) {
		Quantity remainQuantity = CoinRepository.findQuantityByCoin(coin);
		Money remainMoney = MoneyRepository.get();
		Quantity quotientMoneyByAmount = coin.getQuotient(remainMoney);
		int minQuantity = Math.min(remainQuantity.get(), quotientMoneyByAmount.get());
		return new Quantity(minQuantity);
	}

	private void settleCoinAndMoney(Coin coin, final Quantity changeQuantity) {
		CoinRepository.sub(coin, changeQuantity);
		Money money = new Money(coin.get() * changeQuantity.get());
		MoneyRepository.sub(money);
	}
}
