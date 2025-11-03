package lotto.service;

import lotto.domain.*;

import java.util.Map;

public class Game {
    private WinningNumbers winningNumbers;
    private TotalResult totalResult;
    private Person person;

    public Game(Person person, WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
        this.person = person;
    }

    public void runGame(WinningChecker winningChecker){
        Map<Rank,Integer> rankCount = person.checkTotalResult(winningChecker, winningNumbers);
        double returnRate = person.calculateReturnRate(rankCount, new ReturnRateCalculator());
        totalResult = new TotalResult(rankCount, returnRate);
    }

    public TotalResultSnapshot makeSnapshot(){
        return totalResult.makeSnapshot();
    }
}
