package hcapiplantas.exception;

import hcapiplantas.util.constant.GeneralConstants;

public class RestrictionNotFoundException extends Exception {

    public RestrictionNotFoundException(String message){
        super(String.format(GeneralConstants.RESTRICTION_NOT_FOUND_MESSAGE, message));
    }

}
