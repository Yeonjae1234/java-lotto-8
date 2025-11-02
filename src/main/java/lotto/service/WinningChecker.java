package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WinningChecker {
    Map<Rank,Integer> totalResult;

    public WinningChecker(){
        totalResult = new LinkedHashMap<>();

    }

    public void checkTotalResult(List<Lotto> lottos, WinningNumbers winningNumbers) {

    }

    public void findRank(List<Lotto> lottos, WinningNumbers winningNumbers){
        for (Lotto lotto : lottos) {
            Rank result = winningNumbers.countMatchNumbers(lotto);
        }
    }

    public Rank checkResult(Lotto lotto, WinningNumbers winningNumbers) {
        return null;

    }


}
