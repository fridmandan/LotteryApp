package lv.helloit.lottery.LotteryApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LotteryController {

    @PostMapping("/start-registration")
    public void startRegistration () {

    }

    @PostMapping("/register")
    public void registerUser () {

    }

    @PostMapping("/stop-registration")
    public void stopRegistration () {

    }

    @PostMapping("/choose-winner")
    public void chooseWinner() {

    }

    @GetMapping("/status")
    public void getStatus () {

    }

    @GetMapping
    public void getStatistics() {

    }
}
