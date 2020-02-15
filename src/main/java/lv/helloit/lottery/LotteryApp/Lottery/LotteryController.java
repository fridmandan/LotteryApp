package lv.helloit.lottery.LotteryApp.Lottery;

import lv.helloit.lottery.LotteryApp.Reason;
import lv.helloit.lottery.LotteryApp.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class LotteryController {

    @Autowired
    LotteryService lotteryService;


    @PostMapping("/start-registration")
    public ResponseEntity<Object> startLottery(Model model, @ModelAttribute StartLotteryDto startLotteryDto) {
        Reason reason = new Reason();
            try {
                Lottery lottery = lotteryService.startLottery(startLotteryDto);
                reason.setId(lottery.getId());
                reason.setStatus("OK");
                return new ResponseEntity<Object>(reason, HttpStatus.OK);
            } catch(LotteryException e) {
                reason.setStatus("Fail");
                reason.setReason(e.getMessage());
                return new ResponseEntity<Object>(reason, HttpStatus.OK);
            }
    }

    @PostMapping("/stop-lottery")
    public ResponseEntity<Object> stopLottery(Model model, @ModelAttribute IdLotteryDto idLotteryDto) {
        Reason reason = new Reason();
        try {
            lotteryService.stopLottery(idLotteryDto.getId());
            reason.setStatus("OK");
            return new ResponseEntity<Object>(reason, HttpStatus.OK);
        } catch(LotteryException e) {
            reason.setStatus("Fail");
            reason.setReason(e.getMessage());
            return new ResponseEntity<Object>(reason, HttpStatus.OK);
        }
    }

    @PostMapping("/choose-winner")
    public ResponseEntity<Object> chooseWinner(Model model, @ModelAttribute IdLotteryDto idLotteryDto) {
        Reason reason = new Reason();
        try {
            User winner = lotteryService.chooseWinner(idLotteryDto.getId());
            reason.setStatus("OK");
            reason.setWinnerCode(winner.getCode());
            return new ResponseEntity<Object>(reason, HttpStatus.OK);
        } catch(LotteryException e) {
            reason.setStatus("Fail");
            reason.setReason(e.getMessage());
            return new ResponseEntity<Object>(reason, HttpStatus.OK);
        }
    }

    @GetMapping("/stats")
    String stats (Model model){
        List<Lottery> lotteries = lotteryService.getLotteries();

        model.addAttribute("lotteries", lotteries);
        return "stats";
    }


    @GetMapping("/start-registration")
    String startRegistartion (Model model){
        return "start-registration";
    }

    @GetMapping("/stop-lottery")
    String stopRegistration (Model model){
        return "stop-registration";
    }

    @GetMapping("/choose-winner")
    String chooseWinner (Model model){
        return "choose-winner";
    }
}
