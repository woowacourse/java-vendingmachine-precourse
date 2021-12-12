package vendingmachine.view;

public interface InputView {
	final String BLANK_STRING = "";
	String getInput();
	String checkAllConditions(String nowInput);
}
