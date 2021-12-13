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
	private final ProductRepository productRepository;
	private int money;

	public MachineService() {
		this(new DepositRepository(), new ProductRepository());
	}

	public MachineService(DepositRepository depositRepository, ProductRepository productRepository) {
		this.depositRepository = depositRepository;
		this.productRepository = productRepository;
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
		ProductListValidator.validateBracketAndSemiColon(input);
		List<String> inputList = Arrays.asList(input.split(PRODUCT_DELIMITER.getSymbol(), -1));
		List<Product> productList = inputList.stream().map(this::getProduct).collect(Collectors.toList());
		productRepository.save(productList);
	}

	private String trimBrackets(String s) {
		return s.substring(1, s.length() - 1);
	}

	private Product getProduct(String s) {
		validateComma(s);
		validateNameLengthAndInteger(s);
		s = trimBrackets(s);

		List<String> infoList = Arrays.asList(s.split(PRODUCT_INFO_DELIMITER.getSymbol(), -1));
		String name = infoList.get(0);
		int price = Integer.parseInt(infoList.get(1));
		int quantity = Integer.parseInt(infoList.get(2));

		validatePrice(price);
		validateQuantity(quantity);
		return new Product(name, price, quantity);
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
		return productRepository.findAll()
			.stream()
			.filter(product -> product.getPrice() <= money)
			.collect(Collectors.toList());
	}

	public void purchaseProduct(String productName) {
		if (!productRepository.findByName(productName).isPresent())
			throw new IllegalArgumentException(NO_SUCH_PRODUCT.getMessage());
		productRepository.findByName(productName).ifPresent(product -> {
			decreaseMoney(product.getPrice());
			productRepository.decreaseQuantity(productName);
		});
	}

	public String spitChanges() {
		return depositRepository.spit(machine.getUserMoney()).toStringSkipZero();
	}
}
