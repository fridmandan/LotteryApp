package lv.helloit.lottery.LotteryApp;

import lv.helloit.lottery.LotteryApp.User.UserDto;
import lv.helloit.lottery.LotteryApp.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LotteryController {

    @Autowired
    UserService userService;


    @PostMapping("/register")
    public String registerUser(Model model, @ModelAttribute UserDto userDto) {
      userService.registerUser(userDto);
        return "redirect:/sign-up";
    }

}
