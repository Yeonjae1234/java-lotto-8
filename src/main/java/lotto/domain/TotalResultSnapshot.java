package lotto.domain;

import java.util.Map;

public record TotalResultSnapshot(
        Map<Rank,Integer> totalResult,
        double returnRate
) {}
