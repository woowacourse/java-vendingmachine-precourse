package vendingmachine.controller.handler;

import vendingmachine.view.OutputView;

public abstract class RetryHandler<E> implements RetryHandlerController<E> {
    @Override
    public E process() {
        try {
            return doProcess();
        } catch (IllegalArgumentException exception) {
            OutputView.errorMessage(exception.getMessage());
            return process();
        }
    }

    protected abstract E doProcess();
}
