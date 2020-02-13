package lv.helloit.lottery.LotteryApp.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class UserController {

    @PostMapping("/sing-up")
    String signUp(@ModelAttribute User user) {
return null;
    }

}
