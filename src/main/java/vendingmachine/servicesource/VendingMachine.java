package vendingmachine.servicesource;

import vendingmachine.servicesource.wallet.WalletPrinter;
import vendingmachine.servicesource.wallet.WalletSystem;
import vendingmachine.utils.moneychecker.BalanceInputChecker;

public class VendingMachine {
    private MachineStock stock;
    private WalletSystem wallet;
    private WalletPrinter walletPrinter;

    public void runStart(){
        machineInitialize();
        sellStart();
    }

    private void machineInitialize(){
        wallet = new WalletSystem(BalanceInputChecker.getBalance());
        walletPrinter = wallet.getWalletPrinter();

        stock = new MachineStock();
    }

    private void sellStart(){
        wallet.setInsertedBalance();

        while(!stock.checkIsOutOfAllStock() && wallet.haveEnoughInsertedBalanceToPurchase(stock.getCheapestPrice())){
            sellOneProduct();
        }

        wallet.returnChangeByRemainCoins();
    }

    private void sellOneProduct(){
        Product selectedProduct;
        walletPrinter.printRemainInsertedBalance();

        do{
            selectedProduct = stock.getSelectedProduct();
        }while(!wallet.canBuySelectedProduct(selectedProduct));

        sellSelectedProduct(selectedProduct);
    }

    private void sellSelectedProduct(Product selectedProduct){
        wallet.withdrawInsertedBalance(selectedProduct.getPrice());
        stock.takeOutSelectedProduct(selectedProduct);
    }

}
