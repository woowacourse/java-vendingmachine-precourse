package vendingmachine.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Merchandise;
import vendingmachine.domain.Merchandises;
import vendingmachine.domain.Money;
import vendingmachine.domain.User;
import vendingmachine.domain.VendingMachine;
import vendingmachine.utils.ErrorMessage;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
	public static String MERCHANDISE_PARSER = ";";
	public static String MERCHANDISE_INFORMATION_PARSER = ",";

	private VendingMachine vendingMachine;
	private User user;

	public void play() {
		vendingMahchineMoneyWithErrorHandling();
		OutputView.showVendingMahcineCoinStatus(castingCoinToInteger(vendingMachine.saveCoinStatus()));
		vendingMachine.stockMerchandises(new Merchandises(constructMerchandises(parsingMerchandise(InputView.inputMerchandiseInformation()))));
		inputMoneyWithErrorHandling();
		while (true) {
			OutputView.showInputMoneyStatus(user.getUserMoney().getMoney());
			user.buyMerchandise(InputView.inputMerchandiseName(), vendingMachine.getMerchandises());
			if (!isUserBuyMerchandise(vendingMachine, user)) {
				break;
			}
		}
		OutputView.showChangeMoneyStatus(user.getUserMoney().getMoney(), castingCoinToInteger(vendingMachine.changeCoinStatus(user.getUserMoney())));
	}

	public int castingStringMoneyToInt(String stringMoney) {
		return Integer.parseInt(stringMoney);
	}

	public LinkedHashMap<Integer, Integer> castingCoinToInteger(LinkedHashMap<Coin, Integer> coinStatus) {
		LinkedHashMap<Integer, Integer> intCoinStatus = new LinkedHashMap<>();
		for (Coin coin : coinStatus.keySet()) {
			intCoinStatus.put(coin.getAmount(), coinStatus.get(coin));
		}
		return intCoinStatus;
	}

	public List<String> parsingMerchandise(String merchandiseInformations) {
		return Arrays.asList(merchandiseInformations.split(MERCHANDISE_PARSER));
	}

	public Merchandise constructMerchandise(String merchandiseInforamtion) {
		String[] informations = merchandiseInforamtion.split(MERCHANDISE_INFORMATION_PARSER);
		return new Merchandise(informations[0], new Money(Integer.parseInt(informations[1])),
			Integer.parseInt(informations[2]));
	}

	public List<Merchandise> constructMerchandises(List<String> merchandiseInformations) {
		List<Merchandise> merchandiseList = new ArrayList<>();
		for (String merchandiseInformation : merchandiseInformations) {
			String merchandise = merchandiseInformation.substring(1, merchandiseInformation.length() - 1);
			merchandiseList.add(constructMerchandise(merchandise));
		}
		return merchandiseList;
	}

	public boolean isUserBuyMerchandise(VendingMachine vendingMachine, User user) {
		Merchandises merchandises = vendingMachine.getMerchandises();
		for (Merchandise merchandise : merchandises.getMerchandiseList()) {
			if (merchandise.getMoney().getMoney() <= user.getUserMoney().getMoney()) {
				return true;
			}
		}
		return false;
	}

	public void vendingMahchineMoneyWithErrorHandling() {
		try {
			Money vendingMachineMoney = new Money(castingStringMoneyToInt(InputView.inputVendingMachineMoney()));
			vendingMachine = new VendingMachine(vendingMachineMoney);
		} catch (NumberFormatException numberFormatException) {
			System.out.println(ErrorMessage.INVALID_MONEY_TYPE_ERROR_MESSAGE);
			vendingMahchineMoneyWithErrorHandling();
		} catch (IllegalArgumentException illegalArgumentException) {
			System.out.println(illegalArgumentException.getMessage());
			vendingMahchineMoneyWithErrorHandling();
		}
	}

	public void inputMoneyWithErrorHandling() {
		try {
			user = new User(new Money(castingStringMoneyToInt(InputView.inputMoney())));
		} catch (NumberFormatException numberFormatException) {
			System.out.println(ErrorMessage.INVALID_MONEY_TYPE_ERROR_MESSAGE);
			inputMoneyWithErrorHandling();
		} catch (IllegalArgumentException illegalArgumentException) {
			System.out.println(illegalArgumentException.getMessage());
			inputMoneyWithErrorHandling();
		}
	}
}
