package TABA;

/**
 * ClassName: InvalidCountryCodeException
 * Description:
 * <p>
 * Datetime: 18/05/2025 14:37
 * Author: @Likun.Fang
 * Version: 1.0
 */
public class InvalidCountryCodeException extends RuntimeException{

    public InvalidCountryCodeException(){
        super("Incorrect country code in a phone number. Allowed country code is only +353");
    }

    public InvalidCountryCodeException(String message) {
        super(message);
    }
}
