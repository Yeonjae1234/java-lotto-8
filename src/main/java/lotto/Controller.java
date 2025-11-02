package lotto;

import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;
import lotto.view.View;

import java.util.ArrayList;

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

    public WinningNumbers makeWinningNumbers(){
        try {
            ArrayList<Integer> numbers = view.inputWinningNumbers();
            return new WinningNumbers(new Lotto(numbers));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makeWinningNumbers();
        }
    }

}
