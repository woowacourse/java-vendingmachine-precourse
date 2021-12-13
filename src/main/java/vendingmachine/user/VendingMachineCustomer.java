package vendingmachine.user;

import vendingmachine.job.ChangeBackJob;
import vendingmachine.job.DepositJob;
import vendingmachine.job.PurchaseJob;

public class VendingMachineCustomer implements Customer {

	private final DepositJob depositJob;
	private final PurchaseJob purchaseJob;
	private final ChangeBackJob changeBackJob;

	public VendingMachineCustomer(DepositJob depositJob, PurchaseJob purchaseJob, ChangeBackJob changeBackJob) {
		this.depositJob = depositJob;
		this.purchaseJob = purchaseJob;
		this.changeBackJob = changeBackJob;
	}

	@Override
	public void purchase() {
		depositJob.execute();
		purchaseJob.execute();
		changeBackJob.execute();
	}
}
