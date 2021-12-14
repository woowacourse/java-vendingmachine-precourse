package vendingmachine.service;

import static vendingmachine.constants.Constant.*;
import static vendingmachine.constants.Message.*;
import static vendingmachine.utils.Parser.*;
import static vendingmachine.utils.View.*;

import java.util.List;

import vendingmachine.domain.Item;
import vendingmachine.domain.Items;
import vendingmachine.utils.Input;
import vendingmachine.utils.Parser;
import vendingmachine.utils.Validator;
import vendingmachine.utils.View;

public class UserService {
	public int getVendingMachinePossession() {
		while (true) {
			try {
				showAskMessage(ASK_POSSESSION);

				String possession = Input.userInput();
				int parsedPossession = Parser.makeInteger(possession);
				Validator.validatePossession(parsedPossession);

				return parsedPossession;
			} catch (IllegalArgumentException e) {
				View.showErrorMessage(e.getMessage());
			}
		}
	}

	public Items registerItems() {
		while (true) {
			try {
				showAskMessage(ASK_ITEM_REGISTRATION);
				Items items = new Items();

				String addingItemsInfoLine = Input.userInput();
				Validator.validateAddingItemsLineFormat(addingItemsInfoLine);

				String[] eachItemsInfo = splitLine(addingItemsInfoLine, ITEM_INFO_SPLIT_CRITERIA);
				return items.createForSaleItems(eachItemsInfo);
			} catch (IllegalArgumentException e) {
				showErrorMessage(e.getMessage());
			}
		}
	}

	public int getUserMoney() {
		while (true) {
			try {
				showAskMessage(ASK_INPUT_COST);

				String userMoney = Input.userInput();
				int parsedUserMoney = Parser.makeInteger(userMoney);
				Validator.validateUserMoney(parsedUserMoney);

				return parsedUserMoney;
			} catch (IllegalArgumentException e) {
				showErrorMessage(e.getMessage());
			}
		}
	}

	public String getPurchasingItemName(List<Item> forSaleItemList, int userMoney) {
		while (true) {
			try {
				showMoney(userMoney);
				showAskMessage(ASK_PURCHASING_ITEM_NAME);

				String purchasingItemName = Input.userInput();
				Validator.validatePurchaseItemName(purchasingItemName, forSaleItemList);

				return purchasingItemName;
			} catch (IllegalArgumentException e) {
				showErrorMessage(e.getMessage());
			}
		}
	}
}
