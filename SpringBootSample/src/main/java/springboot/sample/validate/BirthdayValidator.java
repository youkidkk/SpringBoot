package springboot.sample.validate;

import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import springboot.sample.validate.constraints.Birthday;

/**
 * 生年月日バリデータ
 */
public class BirthdayValidator implements ConstraintValidator<Birthday, Date> {

	@Override
	public void initialize(Birthday constraintAnnotation) {
	}

	@Override
	public boolean isValid(Date value, ConstraintValidatorContext context) {
		if (value == null) {
			return false;
		}
		return value.compareTo(new Date()) < 0;
	}

}
