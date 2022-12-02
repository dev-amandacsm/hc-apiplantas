package hcapiplantas.exception;

import hcapiplantas.util.constant.GeneralConstants;

public class UserAlreadyExistsException extends Exception {

    public UserAlreadyExistsException(){
        super(GeneralConstants.USER_ALREADY_EXISTS_MESSAGE);
    }

}
