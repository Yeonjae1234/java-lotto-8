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

    public void run(){
        PurchaseAmount purchaseAmount = makePurchaseAmount();
        WinningNumbers winningNumbers = makeBonusNumber(makeWinningNumbers());
    }

    public PurchaseAmount makePurchaseAmount() {
        try {
            return new PurchaseAmount(view.inputPurchaseAmonut());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makePurchaseAmount();
        }
    }

    public Lotto makeWinningNumbers(){
        try {
            ArrayList<Integer> numbers = view.inputWinningNumbers();
            return new Lotto(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makeWinningNumbers();
        }
    }

    public WinningNumbers makeBonusNumber(Lotto winningLotto){
        try {
            int bonusNumber = view.inputBonusNumber();
            return new WinningNumbers(winningLotto, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makeBonusNumber(winningLotto);
        }
    }

}
