package com.app.deliveryapp.util;

import com.app.deliveryapp.exception.GeneralException;
import com.app.deliveryapp.general.enums.ResponseCodeAndMessage;
import org.apache.commons.validator.routines.EmailValidator;

public class GeneralUtil {

    public static void validateName(String firstName, String lastName) {
        // check that first name is not null or empty
        if (GeneralUtil.stringIsNullOrEmpty(firstName)) {
            throw new GeneralException(ResponseCodeAndMessage.INCOMPLETE_PARAMETERS_91.responseCode, "First name cannot be null or empty!");
        }

        // check that last name is not null or empty
        if (GeneralUtil.stringIsNullOrEmpty(lastName)) {
            throw new GeneralException(ResponseCodeAndMessage.INCOMPLETE_PARAMETERS_91.responseCode, "Last name cannot be null or empty!");
        }

    }

    public static boolean invalidEmail(String email) {
        if (stringIsNullOrEmpty(email)) return true;

        return !EmailValidator.getInstance().isValid(email);
    }

    public static boolean stringIsNullOrEmpty(String arg) {
        if ((arg == null)) return true;
        else
            return ("".equals(arg)) || (arg.trim().length() == 0);
    }


}
