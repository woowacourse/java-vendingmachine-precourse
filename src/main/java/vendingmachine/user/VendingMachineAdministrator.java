package vendingmachine.user;

import vendingmachine.job.ChangeSafeJob;
import vendingmachine.job.Job;
import vendingmachine.job.ProductJob;

public class VendingMachineAdministrator implements Administrator {

	private final ChangeSafeJob changeSafeJob;
	private final ProductJob productJob;

	public VendingMachineAdministrator(ChangeSafeJob changeSafeJob, ProductJob productJob) {
		this.changeSafeJob = changeSafeJob;
		this.productJob = productJob;
	}

	@Override
	public void initialize() {
		changeSafeJob.execute();
		productJob.execute();
	}
}
