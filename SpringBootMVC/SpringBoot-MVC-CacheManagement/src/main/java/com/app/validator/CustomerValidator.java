package com.app.validator;


import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Customer;

@Component
public class CustomerValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Customer.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Customer c= (Customer) target;
		
		
		if(StringUtils.isEmpty(c.getCustName()))
		{
			errors.rejectValue("custName",null," please provide customer name");
		}
		
		if(StringUtils.isEmpty(c.getCustCode()))
		{
			errors.rejectValue("custCode",null," please provide customer code");
		}
		
		if(StringUtils.isEmpty(c.getCustType()))
		{
			errors.rejectValue("custType",null," please provide customer type");
		}
		
		if(StringUtils.isEmpty(c.getNote()))
		{
			errors.rejectValue("note",null," please provide Note");
		}
		
	}

	
	
}
