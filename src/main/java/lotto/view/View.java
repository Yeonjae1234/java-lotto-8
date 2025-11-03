package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoListDTO;
import lotto.domain.Rank;
import lotto.domain.TotalResultSnapshot;
import lotto.validator.Validator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class View {

    public static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String WINNING_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    public static final String LOTTO_COUNT_PRINT_MESSAGE = "개를 구매했습니다.";
    public static final String RANK_PRINT_FORMAT = "%s - %d개%n";
    public static final String RETURN_RATE_PRINT_FORMAT = "총 수익률은 %.1f%%입니다.";

    public Validator validator;

    public View(Validator validator) {
        this.validator = validator;
    }


    public Integer inputPurchaseAmonut(){
        try{
            System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);
            String userInput = readLine();
            int result = validator.checkInteger(userInput);
            validator.checkPositive(result);
            return result;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputPurchaseAmonut();
        }
    }

    public ArrayList<Integer> inputWinningNumbers(){
        try {
            System.out.println(WINNING_NUMBERS_INPUT_MESSAGE);
            String userInput = readLine();
            ArrayList<Integer> splitUserInput = validator.checkWinningNumbersInputForm(userInput);
            for (int number : splitUserInput) {
                validator.checkPositive(number);
            }
            return splitUserInput;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningNumbers();
        }
    }

    public int inputBonusNumber(){
        try {
            System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
            int bonusNumber = validator.checkInteger(readLine());
            validator.checkPositive(bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber();
        }
    }

    public void printLottoList(LottoListDTO lottoListDTO){
        var lottos = lottoListDTO.lottoList();
        System.out.println(lottos.size()+LOTTO_COUNT_PRINT_MESSAGE);
        for (var lotto : lottos) {
            System.out.println(lotto.numbers());
        }
    }

    public void printTotalResult(TotalResultSnapshot totalResultSnapshot) {
        Map<Rank, Integer> rankMap = totalResultSnapshot.totalResult();
        double v = totalResultSnapshot.returnRate();
        printRankCount(rankMap);
        printReturnRate(v);
    }

    public void printRankCount(Map<Rank, Integer> rankMap) {
        Rank[] values = Rank.values();
        for (Rank rank : values) {
            System.out.printf(RANK_PRINT_FORMAT, rank.printDescription(), rankMap.get(rank));
        }
    }

    public void printReturnRate(double v) {
        System.out.printf(RETURN_RATE_PRINT_FORMAT, v*100);
    }


}
