package vendingmachine.controller;

import static vendingmachine.view.InputView.*;
import static vendingmachine.view.OutputView.*;

import vendingmachine.dto.RequestHoldingMoneyDto;
import vendingmachine.dto.RequestRegisterProductsDto;
import vendingmachine.dto.ResponseAllCoinQuantity;
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
}
