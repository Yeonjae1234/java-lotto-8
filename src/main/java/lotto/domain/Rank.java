package lotto.domain;

import static lotto.domain.RankConstant.*;

public enum Rank {
    FIFTH(3, false, DESCRIPTION_FIFTH, PRIZE_FIFTH),
    FOURTH(4, false, DESCRIPTION_FOURTH, PRIZE_FOURTH),
    THIRD(5, false, DESCRIPTION_THIRD, PRIZE_THIRD),
    SECOND(5, true, DESCRIPTION_SECOND, PRIZE_SECOND),
    FIRST(6, false, DESCRIPTION_FIRST, PRIZE_FIRST),
    ;

    private int matches;
    private boolean bonus;
    private String description;
    private int prize;

    Rank(int matches, boolean bonus, String description, int prize) {
        this.matches = matches;
        this.bonus = bonus;
        this.description = description;
        this.prize = prize;
    }

    public static Rank valueOf(int matches, boolean bonus) {
        if (bonus && matches == 5) {
            return SECOND;
        }
        for (Rank rank : values()) {
            if(rank.matches == matches){
                return rank;
            }
        }
        return null;
    }

}
