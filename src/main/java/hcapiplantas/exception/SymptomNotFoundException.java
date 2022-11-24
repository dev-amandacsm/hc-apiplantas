package hcapiplantas.exception;

import hcapiplantas.util.constant.GeneralConstants;

public class SymptomNotFoundException extends Exception {

    public SymptomNotFoundException(String message){
        super(String.format(GeneralConstants.SYMPTOM_NOT_FOUND_MESSAGE, message));
    }

}
