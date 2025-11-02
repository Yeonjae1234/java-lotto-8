package lotto.service;

import lotto.domain.Rank;

import java.util.Map;
import java.util.Random;

public class ReturnRateCalculator {

    public double calculateReturnRate(Map<Rank,Integer> totalResult, long money){
        Rank[] ranks = Rank.values();
        long totalPrize = 0;
        for (Rank r : ranks) {
            totalPrize += totalResult.get(r)*(long)r.getPrize();
        }
        return (double) totalPrize /money;
    }

}
