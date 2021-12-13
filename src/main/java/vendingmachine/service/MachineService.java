package vendingmachine.service;

import static vendingmachine.constant.ExceptionMessage.*;
import static vendingmachine.constant.Symbol.*;
import static vendingmachine.validator.MoneyValidator.*;
import static vendingmachine.validator.ProductListValidator.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.constant.Coin;
import vendingmachine.domain.Deposit;
import vendingmachine.domain.Product;
import vendingmachine.repository.DepositRepository;
import vendingmachine.repository.ProductRepository;
import vendingmachine.validator.ProductListValidator;

public class MachineService {

	private final DepositRepository depositRepository;
	private final ProductService productService;
	private int money;

	public MachineService() {
		this(new DepositRepository(), new ProductService());
	}

	public MachineService(DepositRepository depositRepository, ProductService productService) {
		this.depositRepository = depositRepository;
		this.productService = productService;
		this.money = 0;
	}

	public void setDepositsRandomized(String input) {
		validateInteger(input);
		int deposit = Integer.parseInt(input);
		List<Coin> coinList = Arrays.asList(Coin.values());
		Map<Coin, Integer> countMap = new TreeMap<>();
		coinList.forEach(coin -> countMap.put(coin, 0));

		while (deposit > 0) {
			int amountRandomized = Randoms.pickNumberInList(
				coinList.stream().map(Coin::getAmount).collect(Collectors.toList()));
			int amountToSub = getAmountToSub(deposit, amountRandomized);
			if (Coin.ofValue(amountToSub).isPresent()) {
				Coin target = Coin.ofValue(amountToSub).get();
				deposit -= amountToSub;
				countMap.put(target, countMap.get(target) + 1);
			}
		}
		depositRepository.save(
			countMap.keySet().stream().map(coin -> new Deposit(coin, countMap.get(coin))).collect(Collectors.toList()));
	}

	public String getDeposits() {
		return depositRepository.toString();
	}

	private int getAmountToSub(int deposit, int amountRandomized) {
		if (deposit - amountRandomized < 0)
			return 0;
		return amountRandomized;
	}

	public void setProducts(String input) {
		productService.setProducts(input);
	}

	public void addMoney(String inputMoney) {
		validateInteger(inputMoney);
		this.money += Integer.parseInt(inputMoney);
	}

	private void decreaseMoney(int amount) {
		if (amount > money)
			throw new IllegalArgumentException(NOT_ENOUGH_MONEY.getMessage());
		this.money -= amount;
	}

	public final int getMoney() {
		return money;
	}

	public List<Product> getAffordableList() {
		return productService.getAffordableList(money);
	}

	public void purchaseProduct(String productName) {
		decreaseMoney(productService.getPrice(productName));
		productService.decreaseProduct(productName);
	}

	public String spitChanges() {
		DepositRepository changes = depositRepository.spit(money);
		decreaseMoney(changes.getDepositTotal());
		return changes.toStringSkipZero();
	}
}
