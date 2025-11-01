package lotto.validator;

public class Validator {

    public static final String INTEGER_EXCEPTION_MESSAGE = "[ERROR] 입력값은 정수여야 합니다.";

    public int CheckInteger(String userInput){
        try{
            int result = Integer.parseInt(userInput);
            return result;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(INTEGER_EXCEPTION_MESSAGE);
        }
    }
}
