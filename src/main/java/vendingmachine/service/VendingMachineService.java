package vendingmachine.service;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInList;

import java.util.List;

import vendingmachine.domain.CoinRepository;
import vendingmachine.dto.RequestHoldingMoneyDto;
import vendingmachine.dto.ResponseAllCoinQuantity;
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

	public ResponseAllCoinQuantity getAllCoinQuantity() {
		return new ResponseAllCoinQuantity(CoinRepository.findAll());
	}
}
