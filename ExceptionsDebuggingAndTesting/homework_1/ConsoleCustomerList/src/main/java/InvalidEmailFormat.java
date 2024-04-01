import java.util.InputMismatchException;

public class InvalidEmailFormat extends InputMismatchException {
    public InvalidEmailFormat(String message){
        super(message);
    }
}
