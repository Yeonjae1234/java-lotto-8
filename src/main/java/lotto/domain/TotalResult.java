package lotto.domain;

import java.util.Map;

public class TotalResult {
    private Map<Rank,Integer> totalResult;
    private double returnRate;

    public TotalResult(Map<Rank, Integer> totalResult, double returnRate) {
        this.totalResult = totalResult;
        this.returnRate = returnRate;
    }

    public TotalResultSnapshot makeSnapshot(){
        return new TotalResultSnapshot(Map.copyOf(totalResult), returnRate);
    }
}
