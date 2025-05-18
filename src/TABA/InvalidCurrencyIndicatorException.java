package TABA;

/**
 * ClassName: InvalidCurrencyIndicatorException
 * Description:
 * <p>
 * Datetime: 18/05/2025 14:43
 * Author: @Likun.Fang
 * Version: 1.0
 */
public class InvalidCurrencyIndicatorException extends RuntimeException{

    public InvalidCurrencyIndicatorException(){
        super("Missing currency indicator in a salary column. Currency should start with €, £ or $");
    }

    public InvalidCurrencyIndicatorException(String message) {
        super(message);
    }
}
