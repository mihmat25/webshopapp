package com.shop.webshop.validator;

import com.shop.webshop.model.User;
import com.shop.webshop.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    private final UserService userService;


    public UserValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "error.not_empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.not_empty");

        if (userService.verifyUserName(user.getUserName()) != null) {
            errors.rejectValue("userName", "register.error.duplicated.username");
        }

       /* if (user.getUserName().length() < 4) {
            errors.rejectValue("userName", "register.error.username.less_4");
        }
        if (user.getUserName().length() > 32) {
            errors.rejectValue("userName", "register.error.username.over_32");
        }


        if (userService.findByEmail(user.getEmail()) != null) {
            errors.rejectValue("email", "register.error.duplicated.email");
        }

        if (user.getPassword().length() < 8) {
            errors.rejectValue("password", "register.error.password.less_8");
        }
        if (user.getPassword().length() > 32) {
            errors.rejectValue("password", "register.error.password.over_32");
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "register.error.diff_password");
        }*/

    }
}
