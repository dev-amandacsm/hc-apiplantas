package hcapiplantas.exception;

import hcapiplantas.util.constant.GeneralConstants;

import java.util.function.Supplier;

public class CategoryNotFoundException extends Exception {

    public CategoryNotFoundException(String message){
        super(String.format(GeneralConstants.CATEGORY_NOT_FOUND_MESSAGE, message));
    }

}
