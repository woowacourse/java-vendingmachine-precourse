package vendingmachine.controller.classes;

import static vendingmachine.constant.PromptConstant.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import vendingmachine.controller.GoodsStackerInterface;
import vendingmachine.model.Goods;
import vendingmachine.model.VendingMachineStorage;

public class GoodsStacker implements GoodsStackerInterface {
	private List<String> goods = new ArrayList<>();
	private List<Goods> goodsList = new ArrayList<>();
	private VendingMachineStorage vendingMachineStorage = new VendingMachineStorage();

	@Override
	public boolean stackGoods(String userGoodsAndPriceInput) {
		String[] goodsAndPriceStringList = userGoodsAndPriceInput.split(GOODS_CLASSIFY_DELI);
		if (!isValidInputFormat(goodsAndPriceStringList)) {
			return false;
		}

		return true;
	}

	@Override
	public int alignGoods() {
		for (String element : goods) {
			element = element.substring(1, element.length() - 1);
			String tmpGoodsName = element.split(NAME_PRICE_COUNT_CLASSIFY_DELI)[0];
			String tmpGoodsPriceString = element.split(NAME_PRICE_COUNT_CLASSIFY_DELI)[1];
			String tmpGoodsCountString = element.split(NAME_PRICE_COUNT_CLASSIFY_DELI)[2];
			Integer priceInvalid = checkPriceValidation(tmpGoodsPriceString, tmpGoodsCountString);
			if (priceInvalid != null)
				return priceInvalid;
			Goods tmpGoods = new Goods(tmpGoodsName, Integer.parseInt(tmpGoodsPriceString),
				Integer.parseInt(tmpGoodsCountString));
			goodsList.add(tmpGoods);
		}
		vendingMachineStorage.setGoodsList(goodsList);
		return ONE_GOODS_VALID;
	}

	private Integer checkPriceValidation(String tmpGoodsPriceString, String tmpGoodsCountString) {
		if (!tmpGoodsPriceString.matches(NUMBER_REGEX)) {
			return PRICE_INVALID;
		}
		if (!tmpGoodsCountString.matches(NUMBER_REGEX)) {
			return COUNT_INVALID;
		}
		return null;
	}

	@Override
	public void setUserInputMoney(int userInputMoney) {
		vendingMachineStorage.setUserInputMoney(userInputMoney);
	}

	@Override
	public String getLeftMoneyString() {
		String leftMoneyString = "";
		leftMoneyString += PROMPT_SHOW_INSERTED_MONEY;
		leftMoneyString += vendingMachineStorage.getUserInputMoney();
		leftMoneyString += WON_STRING;

		return leftMoneyString;
	}

	@Override
	public boolean buyGoods(String userInputGoods) {
		if (checkHasCount()) {
			return false;
		}
		for (Goods goods : vendingMachineStorage.getGoodsList()) {
			if (goods.getName().equals(userInputGoods)) {
				goods.buyOne();
				int originMoney = vendingMachineStorage.getUserInputMoney();
				vendingMachineStorage.setUserInputMoney(originMoney - goods.getPrice());
				return true;
			}
		}
		return false;
	}

	private boolean checkHasCount() {
		int leftCount = 0;
		for (Goods goods : vendingMachineStorage.getGoodsList()) {
			leftCount += goods.getCount();
		}
		if (leftCount == 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isEnoughMoney() {
		return vendingMachineStorage.getMinAmount() <= this.vendingMachineStorage.getUserInputMoney();
	}

	@Override
	public boolean isEnoughMoney(String userInputGoods) {
		for (Goods goods : goodsList) {
			if (goods.getName().equals(userInputGoods)) {
				return goods.getPrice() <= vendingMachineStorage.getUserInputMoney();
			}
		}
		return true;
	}

	@Override
	public void setCoinMap(HashMap<Integer, Integer> coinMap) {
		vendingMachineStorage.setCoinMap(coinMap);
	}

	@Override
	public boolean haveName(String userInputGoods) {
		return vendingMachineStorage.haveName(userInputGoods);
	}

	@Override
	public String getLeftChangeResult() {
		LeftChangeCalculator leftChangeCalculator = new LeftChangeCalculator();
		return leftChangeCalculator.calculate(vendingMachineStorage.getUserInputMoney(),
			vendingMachineStorage.getCoinMap());
	}

	private boolean isValidInputFormat(String[] goodsAndPriceStringList) {
		for (String oneGoodsString : goodsAndPriceStringList) {
			if (oneGoodsString.charAt(0) != GOODS_START_DELI
				|| oneGoodsString.charAt(oneGoodsString.length() - 1) != GOODS_END_DELI) {
				return false;
			}
			goods.add(oneGoodsString);
		}
		return true;
	}

}
