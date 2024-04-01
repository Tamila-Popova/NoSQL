import java.security.InvalidParameterException;

public class InvalidPhoneNumberFormat extends InvalidParameterException {
    public InvalidPhoneNumberFormat (String message){
        super(message);
    }
}
