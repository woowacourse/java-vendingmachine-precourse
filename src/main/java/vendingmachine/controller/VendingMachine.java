package vendingmachine.controller;

import static vendingmachine.view.InputView.*;
import static vendingmachine.view.OutputView.*;

import vendingmachine.dto.RequestHoldingMoneyDto;
import vendingmachine.dto.RequestInsertMoneyDto;
import vendingmachine.dto.RequestRegisterProductsDto;
import vendingmachine.dto.RequestSellProductDto;
import vendingmachine.dto.ResponseAllCoinQuantity;
import vendingmachine.dto.ResponseMoneyDto;
import vendingmachine.service.VendingMachineService;

public class VendingMachine {
	private final VendingMachineService vendingMachineService;

	public VendingMachine() {
		vendingMachineService = new VendingMachineService();
	}

	public void initHoldingMoney() {
		RequestHoldingMoneyDto requestHoldingMoneyDto = inputHoldingMoney();
		vendingMachineService.initCoinRepository(requestHoldingMoneyDto);
	}

	public void showAllCoinQuantity() {
		ResponseAllCoinQuantity responseAllCoinQuantity = vendingMachineService.getAllCoinQuantity();
		outputAllCoinQuantity(responseAllCoinQuantity);
	}

	public void registerProducts() {
		RequestRegisterProductsDto requestHoldingMoneyDto = inputRegisterProducts();
		vendingMachineService.registerProducts(requestHoldingMoneyDto);
	}

	public void insertMoney() {
		RequestInsertMoneyDto requestInsertMoneyDto = inputInsertMoney();
		vendingMachineService.insertMoney(requestInsertMoneyDto);
	}

	public void sellProduct() {
		while (vendingMachineService.canSell()) {
			sellProductStep();
		}
	}

	private void sellProductStep() {
		while (true) {
			try {
				ResponseMoneyDto responseMoneyDto = vendingMachineService.findMoney();
				RequestSellProductDto requestSellProductDto = inputSellProduct(responseMoneyDto);
				vendingMachineService.sellProduct(requestSellProductDto);
				return;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
