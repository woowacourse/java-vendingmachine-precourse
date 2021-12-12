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
import vendingmachine.utils.Validator;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
	public static String MERCHANDISE_PARSER = ";";
	public static String MERCHANDISE_INFORMATION_PARSER = ",";

	public static String ALL_MERCHANDISE_SOLD_0UT_MESSAGE = "모든 상품은 소진되었습니다.";

	private VendingMachine vendingMachine;
	private User user;

	public void play() {
		vendingMahchineMoneyWithErrorHandling();
		OutputView.showVendingMahcineCoinStatus(castingCoinToInteger(vendingMachine.saveCoinStatus()));
		inputMerchandiseInformationWithErrorHandling();
		if (vendingMachine.getMerchandises().isAllMerchandisesSoldout()) {
			System.out.println(ALL_MERCHANDISE_SOLD_0UT_MESSAGE);
			return;
		}
		inputMoneyWithErrorHandling();
		showMoneyAndInputMerchandise();
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
		Validator.validateEmptyMerchandiseInformation(informations);
		Validator.validateDivideMoneyBy10Coin(Integer.parseInt(informations[1].trim()));
		return new Merchandise(informations[0].trim(), new Money(Integer.parseInt(informations[1].trim())),
			Integer.parseInt(informations[2].trim()));
	}

	public List<Merchandise> constructMerchandises(List<String> merchandiseInformations) {
		List<Merchandise> merchandiseList = new ArrayList<>();
		for (String merchandiseInformation : merchandiseInformations) {
			Validator.validateInputMerchandise(merchandiseInformation);
			String merchandise = merchandiseInformation.substring(1, merchandiseInformation.length() - 1).trim();
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

	public void showMoneyAndInputMerchandise() {
		while (true) {
			OutputView.showInputMoneyStatus(user.getUserMoney().getMoney());
			buyMerchandiseWithErrorHandling();
			if (vendingMachine.getMerchandises().isAllMerchandisesSoldout()) {
				System.out.println(ALL_MERCHANDISE_SOLD_0UT_MESSAGE);
				break;
			}
			if (!isUserBuyMerchandise(vendingMachine, user)) {
				break;
			}
		}
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

	public void inputMerchandiseInformationWithErrorHandling() {
		try {
			vendingMachine.stockMerchandises(
				new Merchandises(constructMerchandises(parsingMerchandise(InputView.inputMerchandiseInformation()))));
		} catch (NumberFormatException numberFormatException) {
			System.out.println(ErrorMessage.INVALID_MONEY_TYPE_ERROR_MESSAGE);
			inputMerchandiseInformationWithErrorHandling();
		} catch (IllegalArgumentException illegalArgumentException) {
			System.out.println(illegalArgumentException.getMessage());
			inputMerchandiseInformationWithErrorHandling();
		}
	}

	public void buyMerchandiseWithErrorHandling() {
		try {
			user.buyMerchandise(InputView.inputMerchandiseName(), vendingMachine.getMerchandises());
		} catch (IllegalArgumentException illegalArgumentException) {
			System.out.println(illegalArgumentException.getMessage());
			buyMerchandiseWithErrorHandling();
		}
	}
}
