package vendingmachine.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.constant.Coin;
import vendingmachine.domain.Deposit;
import vendingmachine.domain.Machine;
import vendingmachine.domain.Product;
import vendingmachine.repository.DepositRepository;
import vendingmachine.repository.ProductRepository;

public class MachineService {

	private final DepositRepository depositRepository;
	private List<Coin> coinList;
	private ProductRepository productRepository;
	private Machine machine;

	public MachineService(DepositRepository depositRepository, ProductRepository productRepository, Machine machine) {
		this.depositRepository = depositRepository;
		this.productRepository = productRepository;
		this.machine = machine;
	}

	public void setDepositsRandomized(int deposit) {
		this.coinList = Arrays.asList(Coin.values());
		Map<Coin, Integer> countMap = new TreeMap<>();
		coinList.forEach(coin -> countMap.put(coin, 0));
		while (deposit > 0) {
			Deposit randomizedDeposit = getDepositRandomized(deposit);
			deposit -= randomizedDeposit.getCoin().getAmount() * randomizedDeposit.getCount();
			countMap.put(randomizedDeposit.getCoin(),
				countMap.get(randomizedDeposit.getCoin()) + randomizedDeposit.getCount());
		}

		depositRepository.save(
			countMap.keySet().stream().map(coin -> new Deposit(coin, countMap.get(coin))).collect(Collectors.toList()));
	}

	private Deposit getDepositRandomized(int deposit) {
		Coin coinRandomized = coinList.get(Randoms.pickNumberInRange(0, coinList.size() - 1));
		int maxCount = deposit / coinRandomized.getAmount();
		int countRandomized = Randoms.pickNumberInRange(0, maxCount);
		return new Deposit(coinRandomized, countRandomized);
	}

	public void setProducts(List<String> inputList) {
		List<Product> productList = inputList.stream()
			.map(s -> getProduct(trimBrackets(s)))
			.collect(Collectors.toList());
		productRepository.save(productList);
	}

	private String trimBrackets(String s) {
		return s.substring(1, s.length() - 1);
	}

	private Product getProduct(String s) {
		List<String> infoList = Arrays.asList(s.split(",", -1));
		String name = infoList.get(0);
		int price = Integer.parseInt(infoList.get(1));
		int quantity = Integer.parseInt(infoList.get(2));

		return new Product(name, price, quantity);
	}

	public void setMoney(String inputMoney) {
		machine.setUserMoney(Integer.parseInt(inputMoney));
	}

	public List<Product> getAffordableList() {
		return productRepository.findAll()
			.stream()
			.filter(product -> product.getPrice() <= machine.getUserMoney())
			.collect(Collectors.toList());
	}

	public void purchaseProduct(String productName) {
		Product product = productRepository.findByName(productName).orElseThrow(IllegalArgumentException::new);
		machine.decreaseUserMoney(product.getPrice());
		productRepository.decreaseQuantity(productName);
	}

	public boolean isSpitable() {
		return isSpitableRecursive(0, machine.getUserMoney(), new DepositRepository(depositRepository));
	}

	private boolean isSpitableRecursive(int coinIndex, int moneySum, DepositRepository clonedDR) {
		if (moneySum == 0)
			return true;
		if (coinIndex >= Coin.values().length) {
			return false;
		}
		Coin coin = Coin.values()[coinIndex];
		int amount = coin.getAmount();
		Deposit deposit = clonedDR.findByCoin(coin).orElse(new Deposit(Coin.COIN_10, 0));
		int count = Math.min(moneySum / amount, deposit.getCount());

		moneySum -= amount * count;
		deposit.decreaseBy(count);
		return isSpitableRecursive(coinIndex + 1, moneySum, clonedDR);
	}

	public String spitChanges() {
		DepositRepository changes = new DepositRepository();
		DepositRepository leftOver = new DepositRepository(depositRepository);
		spitRecursive(0, machine.getUserMoney(), leftOver, changes);
		depositRepository.save(leftOver);
		return changes.toString();
	}

	private void spitRecursive(int coinIndex, int moneySum, DepositRepository leftOver, DepositRepository changes) {
		if (moneySum == 0)
			return;
		if (coinIndex >= Coin.values().length)
			return;

		Coin coin = Coin.values()[coinIndex];
		Deposit deposit = leftOver.findByCoin(coin).orElse(new Deposit(Coin.COIN_10, 0));
		int count = Math.min(moneySum / coin.getAmount(), deposit.getCount());

		moneySum -= coin.getAmount() * count;
		deposit.decreaseBy(count);
		changes.save(new Deposit(coin, count));
		spitRecursive(coinIndex + 1, moneySum, leftOver, changes);
	}
}
