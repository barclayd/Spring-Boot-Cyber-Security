package com.nsa.behaviour.services;

import javax.faces.validator.*;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

//Ref: User Input Validation Tutorial - Cardiff University
//Ref: https://www.mkyong.com/jsf2/custom-validator-in-jsf-2-0/

/**
 * Created by c1673342 on 08/05/2018.
 */
public class passwordValidation implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value)
            throws ValidatorException {
        String passwordValue = value.toString();
        List<FacesMessage> messages = new ArrayList<>();
        if (!Pattern.compile("(?=.*[a-z])").matcher(passwordValue).find()) {
            messages.add(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Password must contain at least one lower case letter",
                    "Missing lower case letter"));
        }
        if (!Pattern.compile("(?=.*[A-Z])").matcher(passwordValue).find()) {
            messages.add(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Password must contain at least one upper case letter",
                    "Missing upper case letter"));
        }
        if (!Pattern.compile("(?=.*[0-9])").matcher(passwordValue).find()) {
            messages.add(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Password must contain at least one number",
                    "Missing number"));
        }
        if (!Pattern.compile("(?=.{8,})").matcher(passwordValue).find()) {
            messages.add(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Password must contain at least 8 characters",
                    "Password not long enough"));
        }
        if (messages.size() > 0) {
            throw new ValidatorException(messages);
        }
    }
}