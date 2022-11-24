package hcapiplantas.exception;

import hcapiplantas.util.constant.GeneralConstants;

public class DataAlreadyExistsException extends Exception {

    public DataAlreadyExistsException(String message){
        super(String.format(GeneralConstants.DATA_ALREADY_EXISTS_MESSAGE, message));
    }

}
