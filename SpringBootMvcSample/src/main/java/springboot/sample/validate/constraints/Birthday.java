package springboot.sample.validate.constraints;

import springboot.sample.validate.BirthdayValidator;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@SuppressWarnings("javadoc")
@Target({ java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { BirthdayValidator.class })
public @interface Birthday {

    /**
     * メッセージ
     * @return 入力エラーメッセージ
     */
    String message() default "生年月日は現在日以前を入力してください。";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
