package lotto;

import lotto.domain.Lotto;
import lotto.domain.Person;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;
import lotto.service.Game;
import lotto.service.LottoGenerator;
import lotto.service.LottoListGenerator;
import lotto.service.WinningChecker;
import lotto.view.View;

import java.util.ArrayList;

public class Controller {
    private View view;
    private LottoListGenerator lottoListGenerator;
    private LottoGenerator lottoGenerator;
    private WinningChecker winningChecker;

    public Controller(View view, LottoListGenerator lottoListGenerator, LottoGenerator lottoGenerator, WinningChecker winningChecker) {
        this.view = view;
        this.lottoListGenerator = lottoListGenerator;
        this.lottoGenerator = lottoGenerator;
        this.winningChecker = winningChecker;
    }

    public void run(){
        PurchaseAmount purchaseAmount = makePurchaseAmount();
        Person person = new Person(purchaseAmount,lottoListGenerator,lottoGenerator);
        view.printLottoList(person.makeLottoListDTO());
        WinningNumbers winningNumbers = makeBonusNumber(makeWinningNumbers());
        Game game = new Game(person,winningNumbers);
        game.runGame(winningChecker);
        view.printTotalResult(game.makeSnapshot());
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
