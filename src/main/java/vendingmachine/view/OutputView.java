package vendingmachine.view;

public class OutputView {
	private String view;

	public OutputView(String view) {
		this.view = view;
	}

	public void output(){
		System.out.println(view);
	}
}
