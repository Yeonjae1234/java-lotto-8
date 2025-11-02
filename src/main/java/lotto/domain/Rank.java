package lotto.domain;

import static lotto.domain.RankConstant.*;

public enum Rank {
    FIRST(DESCRIPTION_FIRST,PRIZE_FIRST,0),
    SECOND(DESCRIPTION_SECOND,PRIZE_SECOND,0),
    THIRD(DESCRIPTION_THIRD,PRIZE_THIRD,0),
    FOURTH(DESCRIPTION_FOURTH,PRIZE_FOURTH,0),
    FIFTH(DESCRIPTION_FIFTH,PRIZE_FIFTH,0);

    private String description;
    private int prize;
    private int count;

    Rank(String description, int prize, int count) {
        this.description = description;
        this.prize = prize;
        this.count = count;
    }

    public void plusCount(){
        count++;
    }

}
