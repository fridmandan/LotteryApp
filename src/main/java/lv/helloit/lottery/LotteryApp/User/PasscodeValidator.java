package lv.helloit.lottery.LotteryApp.User;

import lombok.extern.slf4j.Slf4j;
import lv.helloit.lottery.LotteryApp.Lottery.Lottery;
import lv.helloit.lottery.LotteryApp.Lottery.LotteryDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Component
@Slf4j
public class PasscodeValidator implements Validator {
    private static final Logger LOGGER = LoggerFactory.getLogger(PasscodeValidator.class);

    @Autowired
    LotteryDao lotteryDao;

    @Autowired
    UserDao userDao;

    public boolean supports(Class clazz) {
        return UserDto.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors)
    {
        UserDto userDto = (UserDto) target;
        String code = userDto.getCode();
        if (code.length() != 16) {
            LOGGER.info("Code length is incorrect " + code);
            errors.reject("code", "Code length is incorrect");
            return;
        }

        if (!isNumeric(code)) {
            LOGGER.info("Code should be a number " + code);
            errors.reject("code", "Code should be a number");
            return;
        }

        Optional<Lottery> lottery = lotteryDao.findById(userDto.getLotteryId());

        if (lottery.isEmpty()) {
            LOGGER.info("LotteryId is invalid " + lottery);
            errors.reject("lotteryId", "lotteryId is invalid");
            return;
        }

        LocalDateTime startDate = lottery.get().getStartDate();

        if (startDate == null) {
            LOGGER.info("Lottery is not active yet " + lottery);
            errors.reject("lotteryId", "lottery haven't started yet");
            return;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMYY");
        String lotteryFormatted = startDate.format(formatter);

        String date = code.substring(0, 6);
        if (!date.equals(lotteryFormatted)) {
            LOGGER.info("Code is wrong in first 6 digits " + date);
            errors.reject("code", "First 6 digits didn't match");
            return;
        }
        String enteredEmail = code.substring(6, 8);
        String email = userDto.getEmail();
        String emailPattern = (email.length() >= 10 ? "" : "0") + email.length();
        if(!enteredEmail.equals(emailPattern)) {
            LOGGER.info("Code is wrong in part with email " + email);
            errors.reject("code", "Code is wrong in part with email");
            return;
        }

        Optional <User> user = userDao.findByCode(code);

        if(user.isPresent()) {
            LOGGER.info("Code is not unique " + user);
            errors.reject("code", "Code is not unique");
            return;
        }

    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            LOGGER.info("Error in parsing String to Number");
            return false;
        }
    }
}