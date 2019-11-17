package com.vinsys.app;

import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidator;
import org.apache.wicket.validation.ValidationError;

public class UserValidator implements IValidator<String> {

	@Override
	public void validate(IValidatable<String> arg0) {
		System.out.println("INput Value - "+arg0.getValue());
		System.out.println("Doing Validation");
		ValidationError error =new ValidationError();
		error.setMessage("In correct Namae");
		arg0.error(error);
		
	}

}
