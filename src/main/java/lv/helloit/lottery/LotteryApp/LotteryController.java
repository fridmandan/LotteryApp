package lv.helloit.lottery.LotteryApp;

import lv.helloit.lottery.LotteryApp.Lottery.Lottery;
import lv.helloit.lottery.LotteryApp.Lottery.LotteryDto;
import lv.helloit.lottery.LotteryApp.Lottery.LotteryService;
import lv.helloit.lottery.LotteryApp.User.UserDto;
import lv.helloit.lottery.LotteryApp.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LotteryController {

    @Autowired
    LotteryService lotteryService;


    @GetMapping("/start-registration")
    public String startLottery(Model model, @ModelAttribute LotteryDto lotteryDto) {

      lotteryService.startLottery(lotteryDto);
        return "redirect:/foo";
    }

}
