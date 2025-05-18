package TABA;

/**
 * ClassName: MissingIdException
 * Description:
 * <p>
 * Datetime: 18/05/2025 14:40
 * Author: @Likun.Fang
 * Version: 1.0
 */
public class MissingIdException extends RuntimeException{

    public MissingIdException(){
        super("Missing an id number at all. Id number should be integer > 0  ");
    }

    public MissingIdException(String message) {
        super(message);
    }
}
