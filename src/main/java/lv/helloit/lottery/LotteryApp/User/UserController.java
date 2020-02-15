package lv.helloit.lottery.LotteryApp.User;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
@Slf4j
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    public final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register-lotteryp")
    String signUp(@Valid @ModelAttribute UserDto userDto, Model model) {
       String response = userService.registerUser(userDto);
        LOGGER.info("User created: " + userDto);
        model.addAttribute("response",response);

        return "foo";


    }

    @GetMapping("/register-lotteryp")
    String foo (Model model){
        return "foo";
    }
}
