package vendingmachine.service;

import java.util.List;
import java.util.stream.Collectors;

import vendingmachine.domain.machine.Machine;
import vendingmachine.domain.machine.coin.Coin;
import vendingmachine.domain.machine.coin.CoinFiller;
import vendingmachine.domain.machine.product.Product;
import vendingmachine.domain.user.User;
import vendingmachine.dto.ProductDto;

public class MachineServiceImpl implements MachineService {

	private CoinFiller coinFiller = new CoinFiller();
	private Machine machine = new Machine();
	private User user = new User(machine);

	@Override
	public void fillWithCoins(int balance) {
		List<Coin> coins = coinFiller.convertMoneyToCoins(balance);
		coins.forEach(machine::saveCoin);
	}

	@Override
	public void saveProducts(List<ProductDto> productDtos) {
		List<Product> products = productDtos.stream().map(ProductDto::toEntity).collect(Collectors.toList());
		machine.saveProducts(products);
	}

	public void depositMoneyOfUser(int balance) {
		user.depositMoney(balance);
	}

	public int getCurrentMoneyOfUser() {
		return user.getCurrentMoney();
	}

	@Override
	public void purchaseProduct(String productName) {
		user.purchase(productName);
	}

	@Override
	public void refundChanges() {
		user.refund();
	}

	@Override
	public List<String> getCoinsOfMachine() {
		return machine.getCoinsByString();
	}

	@Override
	public List<String> getCoinsOfUser() {
		return user.getCoinsByString();
	}

	@Override
	public boolean isUserPossibleToUseMachine() {
		if (user.hasNotEnoughMoney()) {
			return false;
		}
		if (machine.isAllProductSoldOut()) {
			return false;
		}
		return true;
	}

}
