package lotto.validator;

public class Validator {

    public static final String INTEGER_ERROR_MESSAGE = "[ERROR] 입력값은 정수여야 합니다.";
    public static final String POSITIVE_ERROR_MESSAGE = "[ERROR] 입력값은 양수여야 합니다.";

    public int checkInteger(String userInput){
        try{
            int result = Integer.parseInt(userInput);
            return result;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(INTEGER_ERROR_MESSAGE);
        }
    }

    public int checkPositive(int userInput) {
        if(userInput<=0){
            throw new IllegalArgumentException(POSITIVE_ERROR_MESSAGE);
        }
        return userInput;
    }

}
