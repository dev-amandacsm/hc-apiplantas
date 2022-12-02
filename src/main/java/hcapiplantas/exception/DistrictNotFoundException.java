package hcapiplantas.exception;

import hcapiplantas.util.constant.GeneralConstants;

import javax.validation.constraints.Pattern;

public class DistrictNotFoundException extends Exception {
    public DistrictNotFoundException() {
        super(GeneralConstants.DISTRICT_NOT_FOUND_MESSAGE);
    }
}
