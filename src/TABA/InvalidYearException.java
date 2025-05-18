package TABA;

/**
 * ClassName: InvalidYearException
 * Description:
 * <p>
 * Datetime: 18/05/2025 14:33
 * Author: @Likun.Fang
 * Version: 1.0
 */
public class InvalidYearException extends RuntimeException {

    public InvalidYearException(){
        super("Incorrect year part in the date format. The year part of the date should start with four digits followed by “/”");
    }

    public InvalidYearException(String message) {
        super(message);
    }
}
