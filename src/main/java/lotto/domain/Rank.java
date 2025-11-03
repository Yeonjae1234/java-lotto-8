package lotto.domain;

import static lotto.domain.RankConstant.*;

public enum Rank {
    FIFTH(3, DESCRIPTION_FIFTH, PRIZE_FIFTH),
    FOURTH(4, DESCRIPTION_FOURTH, PRIZE_FOURTH),
    THIRD(5, DESCRIPTION_THIRD, PRIZE_THIRD),
    SECOND(5, DESCRIPTION_SECOND, PRIZE_SECOND),
    FIRST(6, DESCRIPTION_FIRST, PRIZE_FIRST),
    ;

    private final int matches;
    private final String description;
    private final int prize;

    Rank(int matches, String description, int prize) {
        this.matches = matches;
        this.description = description;
        this.prize = prize;
    }

    public static Rank valueOf(int matches, boolean bonus) {
        if (bonus && matches == 5) {
            return SECOND;
        }
        for (Rank rank : values()) {
            if (rank.matches == matches) return rank;
        }
        return null;
    }

    public int getPrize() {
        return prize;
    }

    public String printDescription() {
        return String.format("%s (%,d원)", description, prize);
    }
}
