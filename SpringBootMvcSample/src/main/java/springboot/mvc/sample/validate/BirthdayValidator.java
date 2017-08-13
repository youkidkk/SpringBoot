package springboot.mvc.sample.validate;

import springboot.mvc.sample.validate.constraints.Birthday;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import java.util.Date;

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
