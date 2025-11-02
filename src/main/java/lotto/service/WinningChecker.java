package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningChecker {
    public Map<Rank,Integer> totalResult;

    public WinningChecker(){
        totalResult = new EnumMap<>(Rank.class);
        for (Rank r : Rank.values()) {
            totalResult.put(r, 0);
        }
    }

    public Map<Rank,Integer> checkTotalResult(List<Lotto> lottos, WinningNumbers winningNumbers) {
        for (Lotto lotto : lottos) {
            findRank(lotto,winningNumbers);
        }
        return totalResult;
    }

    public void findRank(Lotto lotto, WinningNumbers winningNumbers){
        Rank resultRank = winningNumbers.countMatchNumbers(lotto);
        if(resultRank==null) return;
        totalResult.put(resultRank, totalResult.get(resultRank) + 1);
    }


}
