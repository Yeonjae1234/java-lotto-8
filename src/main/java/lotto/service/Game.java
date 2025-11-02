package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Person;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;

import java.util.ArrayList;

public class Game {
    private WinningNumbers winningNumbers;
    private PurchaseAmount purchaseAmount;
    private LottoListGenerator lottoListGenerator;
    private LottoGenerator lottoGenerator;

    public Game(WinningNumbers winningNumbers, PurchaseAmount purchaseAmount
            , LottoListGenerator lottoListGenerator, LottoGenerator lottoGenerator) {
        this.winningNumbers = winningNumbers;
        this.purchaseAmount = purchaseAmount;
        this.lottoListGenerator = lottoListGenerator;
    }

    public void runGame(){
        ArrayList<Lotto> lottoList = purchaseAmount.generateLottoList(lottoListGenerator, lottoGenerator);
        Person person = new Person(lottoList, purchaseAmount);

    }
}
