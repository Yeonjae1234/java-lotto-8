package lotto.validator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public static final String INTEGER_ERROR_MESSAGE = "[ERROR] 입력값은 정수여야 합니다.";
    public static final String POSITIVE_ERROR_MESSAGE = "[ERROR] 입력값은 양수여야 합니다.";
    public static final String WINNIG_NUMBERS_INPUT_FORM_ERROR_MESSAGE = "[ERROR] 입력 형식이 올바르지 않습니다.(정수와 쉼표로 구성되어야 합니다.)";
    public static final String LOTTO_NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1에서 45 사이의 숫자여야 합니다.";
    public static final String LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE = "[ERROR] 로또 번호는 중복될 수 없습니다.";
    public static final String BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE = "[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.";


    public int checkInteger(String userInput){
        try{
            return Integer.parseInt(userInput);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(INTEGER_ERROR_MESSAGE);
        }
    }

    public void checkPositive(int userInput) {
        if(userInput<=0){
            throw new IllegalArgumentException(POSITIVE_ERROR_MESSAGE);
        }
    }

    public ArrayList<Integer> checkWinningNumbersInputForm(String userInput) {
        try {
            String[] splitUserInput = userInput.split(",");
            ArrayList<Integer> WinningNumber = new ArrayList<>();
            for (String number : splitUserInput) {
                WinningNumber.add(Integer.parseInt(number));
            }
            return WinningNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WINNIG_NUMBERS_INPUT_FORM_ERROR_MESSAGE);
        }
    }

    public void checkLottoNumber(int lottoNumber) {
        if(lottoNumber<1||lottoNumber>45){
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    public void checkDuplication(List<Integer> lottoNumbers) {
        Set<Integer> numberSet = new HashSet<>(lottoNumbers);
        if (numberSet.size() != lottoNumbers.size()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE);
        }
    }

    public void checkBonusNumberDuplication(List<Integer> lottoNumbers, int bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE);
        }
    }

}
