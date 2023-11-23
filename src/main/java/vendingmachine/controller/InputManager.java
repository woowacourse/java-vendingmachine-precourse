package vendingmachine.controller;

import java.util.ArrayList;
import java.util.List;
import vendingmachine.domain.Machine;
import vendingmachine.domain.Product;
import vendingmachine.utils.Parser;
import vendingmachine.validator.InputMoneyValidator;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class InputManager {

    private final InputView inputView;
    private final OutputView outputView;

    public InputManager(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public int inputMachineMoney() {
        boolean flag = false;
        String money = "";
        while (!flag) {
            try {
                money = inputView.inputMachineMoney();
                InputMoneyValidator.validateInputMoney(money);
                flag = true;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
        return Parser.inputMoneyParser(money);
    }

    public List<Product> inputMachineProduct() {
        boolean flag = false;
        List<Product> machineProducts = new ArrayList<>();
        while (!flag) {
            try {
                String products = inputView.inputMachineProduct();
                machineProducts = Parser.productsParser(products);
                flag = true;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
        return machineProducts;
    }

    public int inputUserAmount() {
        boolean flag = false;
        String money = "";
        while (!flag) {
            try {
                money = inputView.inputUserAmount();
                ;
                InputMoneyValidator.validateInputMoney(money);
                flag = true;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
        return Parser.inputMoneyParser(money);
    }

    public String inputBuyProduct(Machine machine) {
        boolean flag = false;
        String product = "";
        while (!flag) {
            try {
                product = inputView.inputBuyProduct();
                machine.isExistsProduct(product);
                machine.isExistsQuantity(product);
                flag = true;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
        return product;
    }
}
