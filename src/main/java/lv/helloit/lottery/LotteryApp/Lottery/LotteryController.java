package lv.helloit.lottery.LotteryApp.Lottery;

import lv.helloit.lottery.LotteryApp.Reason;
import lv.helloit.lottery.LotteryApp.User.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger LOGGER = LoggerFactory.getLogger(LotteryController.class);

    @Autowired
    LotteryService lotteryService;

    @GetMapping("/admin")
    public String adminPage(Model model) {
        return "admin-loginPage";
    }

    @GetMapping("/")
    public String homePage(Model model) {
        return "register";
    }

    @GetMapping("/admin-page")
    public String adminPageTwo(Model model) {
        return "admin-page";
    }

    @PostMapping("/start-registration")
    public ResponseEntity<Object> startLottery(Model model, @ModelAttribute StartLotteryDto startLotteryDto) throws LotteryException {
        Reason reason = new Reason();
            try {
                Lottery lottery = lotteryService.startLottery(startLotteryDto);
                reason.setId(lottery.getId());
                reason.setStatus("OK");
                return new ResponseEntity<Object>(reason, HttpStatus.OK);
            } catch(LotteryException e) {
                LOGGER.info("couldn't start lottery with id" + lotteryService.startLottery(startLotteryDto).getId());
                reason.setStatus("Fail");
                reason.setReason(e.getMessage());
                return new ResponseEntity<Object>(reason, HttpStatus.INTERNAL_SERVER_ERROR);
            }
    }

    @PostMapping("/stop-registration")
    public ResponseEntity<Object> stopLottery(Model model, @ModelAttribute IdLotteryDto idLotteryDto) throws LotteryException {
        Reason reason = new Reason();
        try {
            lotteryService.stopLottery(idLotteryDto.getId());
            reason.setStatus("OK");
            return new ResponseEntity<Object>(reason, HttpStatus.OK);
        } catch(LotteryException e) {
            LOGGER.info("Couldn't stop lottery with id" + lotteryService.stopLottery(idLotteryDto.getId()));
            reason.setStatus("Fail");
            reason.setReason(e.getMessage());
            return new ResponseEntity<Object>(reason, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/choose-winner")
    public ResponseEntity<Object> chooseWinner(Model model, @ModelAttribute IdLotteryDto idLotteryDto) throws LotteryException {
        Reason reason = new Reason();
        try {
            User winner = lotteryService.chooseWinner(idLotteryDto.getId());
            reason.setStatus("OK");
            reason.setWinnerCode(winner.getCode());
            LOGGER.info("Winner in Lottery with id" + lotteryService.chooseWinner(idLotteryDto.getId()) + "has been chosen");
            return new ResponseEntity<Object>(reason, HttpStatus.OK);
        } catch(LotteryException e) {
            LOGGER.info("Couldn't choose winner in Lottery with id " + lotteryService.chooseWinner(idLotteryDto.getId()));
            reason.setStatus("Fail");
            reason.setReason(e.getMessage());
            return new ResponseEntity<Object>(reason, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/stats")
    String stats (Model model){
        List<Lottery> lotteries = lotteryService.getLotteries();

        model.addAttribute("lotteries", lotteries);
        return "stats";
    }


    @GetMapping("/start-registration")
    String startRegistration (Model model){
        return "start-registration";
    }

    @GetMapping("/stop-registration")
    String stopRegistration (Model model){
        return "stop-registration";
    }

    @GetMapping("/choose-winner")
    String chooseWinner (Model model){
        return "choose-winner";
    }
}
