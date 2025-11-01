package lotto;

import lotto.domain.PurchaseAmount;
import lotto.view.View;

public class Controller {
    View view;

    public Controller(View view) {
        this.view = view;
    }

    public PurchaseAmount makePurchaseAmount() {
        try {
            return new PurchaseAmount(view.inputPurchaseAmonut());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makePurchaseAmount();
        }
    }
}
