package hcapiplantas.exception;

import hcapiplantas.util.constant.GeneralConstants;

public class DataNotFoundException extends Exception {

    public DataNotFoundException(String message){
        super(String.format(GeneralConstants.DATA_NOT_FOUND_MESSAGE, message));
    }

    public DataNotFoundException(){

    }

}
